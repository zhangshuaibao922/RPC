package com.cardo.common;

import java.io.Serializable;

public class URL implements Serializable {

    private String hostname;
    private Integer port;

    public String getHostname() {
        return hostname;
    }

    public URL(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
