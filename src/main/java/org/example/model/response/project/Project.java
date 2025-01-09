package org.example.model.response.project;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Project {
    private String slug;
    private String name;
    private String repositoryUrl;
    private ProjectStatus status;
    private List<Release> releases;
}
