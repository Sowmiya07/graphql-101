package org.example.controller;

import org.example.model.response.project.Project;
import org.example.model.response.project.Release;
import org.example.service.ProjectService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @QueryMapping
    public Project project(@Argument String id) {

        return this.projectService.fetchProject(id);
    }

    @SchemaMapping
    public List<Release> releases(Project project) {
        return this.projectService.fetchReleases(project);
    }
}
