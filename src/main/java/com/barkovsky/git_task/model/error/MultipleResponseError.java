package com.barkovsky.git_task.model.error;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MultipleResponseError<T> {
    @JsonProperty("logref")
    private final String logRef;
    @JsonProperty("errors")
    private final List<T> errors;

    public MultipleResponseError(String logRef, List<T> errors) {
        this.logRef = logRef;
        this.errors = errors;
    }

    public String getLogRef() {
        return logRef;
    }

    public List<T> getErrors() {
        return errors;
    }
}
