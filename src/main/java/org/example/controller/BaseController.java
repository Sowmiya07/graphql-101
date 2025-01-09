package org.example.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

    @QueryMapping
    public String greeting() {
        return "Hello from Graphql";
    }
}
