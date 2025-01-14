package org.example.controller;

import org.example.config.RequestAttributeFilter;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;

@Controller
public class BaseController {

    @QueryMapping
    public String greeting() {
        return "Hello from Graphql, " +
                RequestContextHolder.getRequestAttributes().getAttribute(RequestAttributeFilter.NAME_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
    }

}
