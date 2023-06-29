package br.edu.ifsp.aluno.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicResponse {
    private int code;
    private String etag;
    private ComicData data;
    
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
    
    public ComicData getData() {
        return data;
    }
    
    public void setData(ComicData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ComicResponse [code=" + code + ", etag=" + etag + ", data=" + data + "]";
    }

}
