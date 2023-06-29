package br.edu.ifsp.aluno;

import java.sql.SQLException;

import br.edu.ifsp.aluno.dao.AlbumDAO;
import br.edu.ifsp.aluno.dao.ArtistDAO;
import br.edu.ifsp.aluno.dao.SongDAO;
import br.edu.ifsp.aluno.model.Album;
import br.edu.ifsp.aluno.model.Artist;
import br.edu.ifsp.aluno.model.Song;

public class Main {
    
    public static void main(String[] args) throws SQLException {
        ArtistDAO artistDao = new ArtistDAO();

        for (Artist g : artistDao.findAll()) {
            System.out.println(g.getGenre());
        }
    }
}
