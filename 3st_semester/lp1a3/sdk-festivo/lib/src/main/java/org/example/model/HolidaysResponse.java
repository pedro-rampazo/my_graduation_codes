package org.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HolidaysResponse {
    private int status;
    private String requestId;
    private Query query;
    private List<Holiday> holidays;
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getRequestId() {
        return requestId;
    }
    
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    
    public Query getQuery() {
        return query;
    }
    
    public void setQuery(Query query) {
        this.query = query;
    }
    
    public List<Holiday> getHolidays() {
        return holidays;
    }
    
    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }

    @Override
    public String toString() {
        return "HolidaysResponse [status=" + status + ", requestId=" + requestId + ", query=" + query + ", holidays="
                + holidays + "]";
    }
    
}
