package org.example;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello GraphQL world!");

//        InputStream stream = ClassLoader.getSystemResourceAsStream("schema.graphqls");
//        SchemaParser schemaParser = new SchemaParser();
//        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(stream);
//
//        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
//                .type("Query", builder -> builder.dataFetcher("greeting", new StaticDataFetcher("hello")))
//                .build();
//
//        SchemaGenerator schemaGenerator = new SchemaGenerator();
//        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
//
//        GraphQL graphQL = GraphQL.newGraphQL(graphQLSchema).build();
//        ExecutionResult executionResult = graphQL.execute("{greeting}");
//
//        System.out.println(executionResult.getData().toString());

        SpringApplication.run(Main.class, args);
    }
}