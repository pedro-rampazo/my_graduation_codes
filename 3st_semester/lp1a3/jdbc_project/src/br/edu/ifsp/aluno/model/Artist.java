package br.edu.ifsp.aluno.model;

public class Artist {
    private Integer id;
    private String name;
    private String origin;
    private Integer formedIn;
    private String genre;
    
    public Artist(Integer id, String name, String origin, Integer formedIn, String genre) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.formedIn = formedIn;
        this.genre = genre;
    }

    public Artist(String name, String origin, Integer formedIn, String genre) {
        this.name = name;
        this.origin = origin;
        this.formedIn = formedIn;
        this.genre = genre;
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getFormedIn() {
        return formedIn;
    }

    public void setFormedIn(Integer formedIn) {
        this.formedIn = formedIn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public String toStringFull() {
        return "Artist [id=" + id + ", name=" + name + ", origin=" + origin + ", formedIn=" + formedIn + ", genre="
                + genre + "]";
    }

}
