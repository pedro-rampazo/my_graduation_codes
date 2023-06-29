package br.edu.ifsp.aluno.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Serie {
    private int id;
    private String title;
    private String description;
    private int startYear;
    private int endYear;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getStartYear() {
        return startYear;
    }
    
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }
    
    public int getEndYear() {
        return endYear;
    }
    
    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    @Override
    public String toString() {
        return "Serie [id=" + id + ", title=" + title + ", description=" + description + ", startYear=" + startYear
                + ", endYear=" + endYear + "]";
    }

}
