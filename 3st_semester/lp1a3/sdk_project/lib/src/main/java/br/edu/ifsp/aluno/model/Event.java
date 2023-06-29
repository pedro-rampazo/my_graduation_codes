package br.edu.ifsp.aluno.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
    private int id;
    private String title;
    private String description;
    private String start;
    private String end;
    
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
    
    public String getStart() {
        return start;
    }
    
    public void setStart(String start) {
        this.start = start;
    }
    
    public String getEnd() {
        return end;
    }
    
    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", title=" + title + ", description=" + description + ", start=" + start + ", end="
                + end + "]";
    }

}
