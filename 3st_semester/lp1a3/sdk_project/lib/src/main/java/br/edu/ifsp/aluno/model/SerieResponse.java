package br.edu.ifsp.aluno.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SerieResponse {
    private int code;
    private String etag;
    private SerieData data;
    
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
    
    public SerieData getData() {
        return data;
    }
    
    public void setData(SerieData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SerieResponse [code=" + code + ", etag=" + etag + ", data=" + data + "]";
    } 
    
}
