package br.edu.ifsp.aluno.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatorResponse {
    private int code;
    private String etag;
    private CreatorData data;
    
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
    
    public CreatorData getData() {
        return data;
    }
    
    public void setData(CreatorData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CreatorResponse [code=" + code + ", etag=" + etag + ", data=" + data + "]";
    }
    
}
