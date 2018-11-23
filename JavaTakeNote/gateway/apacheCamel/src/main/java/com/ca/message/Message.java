package com.ca.message;

import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Message {


    @NotNull
    @Valid
    private Metadata metadata;

    private ObjectNode result;

    public void  setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
    public void  setResult(ObjectNode result) {
        this.result = result;
    }


    public Metadata getMetadata() {
        return this.metadata;
    }

    public ObjectNode getObjectNode () {
        return this.result;
    }
}
