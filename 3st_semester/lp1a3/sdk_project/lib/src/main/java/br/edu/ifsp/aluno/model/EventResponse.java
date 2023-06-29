package br.edu.ifsp.aluno.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventResponse {
    private int code;
    private String etag;
    private EventData data;
    
    public int getCode() {
        return code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public String getEtag() {
        return etag;
    }
    
    public void setEtag(String etag) {
        this.etag = etag;
    }
    
    public EventData getData() {
        return data;
    }
    
    public void setData(EventData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EventResponse [code=" + code + ", etag=" + etag + ", data=" + data + "]";
    }
    
}
