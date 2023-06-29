package br.edu.ifsp.aluno.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventData {
    private int total;
    @JsonProperty("results")
    private List<Event> events;
    
    public int getTotal() {
        return total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    
    public List<Event> getEvents() {
        return events;
    }
    
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "EventData [total=" + total + ", events=" + events + "]";
    }

}
