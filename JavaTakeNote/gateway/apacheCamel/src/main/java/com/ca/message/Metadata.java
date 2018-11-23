package com.ca.message;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class Metadata {

    private long timestamp;
    private String type;
    private Status status;
    private Long domainId = 0L;
    private Source source;

    public void setTimestamp(long timestamp ) {
        this.timestamp = timestamp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(Status status ) {
        this.status = status;
    }

    public void setDomainId(Long domainId) {
        this.domainId = domainId;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public long getTimestamp() {
        return this.timestamp ;
    }

    public String getType() {
        return this.type ;
    }

    public Status getStatus() {
        return this.status ;
    }

    public Long getDomainId() {
        return this.domainId ;
    }

    public Source getSource() {
        return this.source ;
    }

}
