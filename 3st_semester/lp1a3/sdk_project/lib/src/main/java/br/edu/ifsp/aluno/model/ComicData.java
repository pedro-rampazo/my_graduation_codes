package br.edu.ifsp.aluno.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComicData {
    private int total;
    @JsonProperty("results")
    private List<Comic> comics;
    
    public int getTotal() {
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    
    public List<Comic> getComics() {
        return comics;
    }
    
    public void setComics(List<Comic> comics) {
        this.comics = comics;
    }

    @Override
    public String toString() {
        return "ComicData [total=" + total + ", comics=" + comics + "]";
    }

}
