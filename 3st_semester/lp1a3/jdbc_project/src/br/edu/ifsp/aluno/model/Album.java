package br.edu.ifsp.aluno.model;

public class Album {
    private Integer id;
    private String name;
    private Integer year;
    private String label;
    private Artist artist;
    
    public Album(Integer id, String name, Integer year, String label, Artist artist) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.label = label;
        this.artist = artist;
    }

    public Album(String name, Integer year, String label, Artist artist) {
        this.name = name;
        this.year = year;
        this.label = label;
        this.artist = artist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public String toStringFull() {
        return "Album [id=" + id + ", name=" + name + ", year=" + year + ", label=" + label + ", artist=" + artist
                + "]";
    }
    
}
