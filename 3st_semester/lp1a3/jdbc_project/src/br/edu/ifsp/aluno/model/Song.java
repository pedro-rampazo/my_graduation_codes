package br.edu.ifsp.aluno.model;

public class Song {
    private Integer id;
    private String name;
    private String duration;
    private Integer track;
    private Album album;
    
    public Song(Integer id, String name, String duration, Integer track, Album album) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.track = track;
        this.album = album;
    }

    public Song(String name, String duration, Integer track, Album album) {
        this.name = name;
        this.duration = duration;
        this.track = track;
        this.album = album;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getTrack() {
        return track;
    }

    public void setTrack(Integer track) {
        this.track = track;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Song [id=" + id + ", name=" + name + ", duration=" + duration + ", track=" + track + ", album=" + album
                + "]";
    }

}
