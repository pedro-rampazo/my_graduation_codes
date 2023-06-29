package br.edu.ifsp.aluno.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatorData {
    private int total;
    @JsonProperty("results")
    private List<Creator> creators;
    
    public int getTotal() {
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    
    public List<Creator> getCreators() {
        return creators;
    }
    
    public void setCreators(List<Creator> creators) {
        this.creators = creators;
    }

    @Override
    public String toString() {
        return "CreatorData [total=" + total + ", creators=" + creators + "]";
    }
    
}
