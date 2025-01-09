package org.example.model.response.project;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Release {
    private String version;
    private boolean current;
}
