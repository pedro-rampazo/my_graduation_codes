package br.edu.ifsp.aluno.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterData {
    private int total;
    @JsonProperty("results")
    private List<Character> characters;
    
    public int getTotal() {
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    
    public List<Character> getCharacters() {
        return characters;
    }
    
    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Data [total=" + total + ", characters=" + characters + "]";
    }

}
