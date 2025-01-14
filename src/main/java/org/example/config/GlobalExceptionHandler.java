package org.example.config;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.example.exception.AuthorException;
import org.example.exception.BookException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class GlobalExceptionHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if(ex instanceof AuthorException || ex instanceof BookException) {
            return buildError(ex, env);
        }
        return null;
    }

    private static GraphQLError buildError(Throwable ex, DataFetchingEnvironment env) {

        String errorCode;
        String errorMsg;

        switch (ex) {
            case AuthorException ae -> {
                errorCode = ae.getErrorCode();
                errorMsg = ae.getErrorMessage();
            }
            case BookException be -> {
                errorCode = be.getErrorCode();
                errorMsg = be.getErrorMessage();
            }
            default -> throw new IllegalStateException("Unexpected value: " + ex);
        }

        return GraphqlErrorBuilder.newError()
                .errorType(ErrorClassification.errorClassification(errorCode))
                .message(errorMsg)
                .path(env.getExecutionStepInfo().getPath())
                .location(env.getField().getSourceLocation())
                .build();
    }
}
