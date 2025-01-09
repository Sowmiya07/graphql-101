package org.example.service;

import org.example.model.response.project.Project;
import org.example.model.response.project.Release;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Hop;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.server.core.TypeReferences;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.*;

@Service
public class ProjectService {

    private final Traverson traverson;

    public ProjectService(RestTemplateBuilder builder) {
        List<HttpMessageConverter<?>> converters = Traverson.getDefaultMessageConverters(MediaTypes.HAL_JSON);
        RestTemplate restTemplate = builder.messageConverters(converters).build();
        this.traverson = new Traverson(URI.create("https://api.spring.io"), MediaTypes.HAL_JSON);
        this.traverson.setRestOperations(restTemplate);
    }

    public Project fetchProject(String projectId) {

        return this.traverson.follow("projects")
                .follow(Hop.rel("project").withParameter("id", projectId))
                .toObject(Project.class);
    }


    public List<Release> fetchReleases(Project project) {

        TypeReferences.CollectionModelType<Release> releaseCollection =
                new TypeReferences.CollectionModelType<>() {};

        CollectionModel<Release> releases = this.traverson.follow("projects")
                .follow(Hop.rel("project").withParameter("id", project.getSlug())).follow(Hop.rel("releases"))
                .toObject(releaseCollection);

        return new ArrayList(releases.getContent());
    }
}
