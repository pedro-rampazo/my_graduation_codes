package br.edu.ifsp.aluno.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterResponse {
    private int code;
    private String etag;
    private CharacterData data;
    
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
    
    public CharacterData getData() {
        return data;
    }
    
    public void setData(CharacterData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CharacterResponse [code=" + code + ", etag=" + etag + ", data=" + data + "]";
    }

}
