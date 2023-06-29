package br.edu.ifsp.aluno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.aluno.db.ConnectionDb;
import br.edu.ifsp.aluno.model.Album;
import br.edu.ifsp.aluno.model.Artist;

public class AlbumDAO {
    
    public Album create(Album album) throws SQLException {
        String sql = """
            INSERT INTO album (name, year, label, artist_id)
            VALUES (?, ?, ?, ?)      
        """;

        try (
            Connection connection = ConnectionDb.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, album.getName());
            statement.setInt(2, album.getYear());
            statement.setString(3, album.getLabel());
            statement.setInt(4, album.getArtist().getId());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                album.setId(rs.getInt(1));
            }

            rs.close();

            return album;
        }
    }

    public Album update(Album album) throws SQLException {
        String sql = """
            UPDATE album SET name = ?, year = ?, label = ?, artist_id = ?
            WHERE id = ?
        """;

        try (
            Connection connection = ConnectionDb.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, album.getName());
            statement.setInt(2, album.getYear());
            statement.setString(3, album.getLabel());
            statement.setInt(4, album.getArtist().getId());
            statement.setInt(5, album.getId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                return album;
            }
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM album WHERE id = ?";

        try (
            Connection connection = ConnectionDb.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Album album) {
        delete(album.getId());
    }

    public Album find(Integer id) throws SQLException {
        String sql = "SELECT * FROM album WHERE id = ?";

        try (
            Connection connection = ConnectionDb.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            return resultSetToAlbum(rs);
        }
    }

    public List<Album> findAll() throws SQLException {
        String sql = "SELECT * FROM album;";
        List<Album> albums = new ArrayList<>();

        try (
            Connection connection = ConnectionDb.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while (rs.next()) {
                albums.add(resultSetToAlbum(rs));
            }

            return albums;
        }
    }
    
    public Artist recoverArtist(Integer id) throws SQLException {
        ArtistDAO artistDao = new ArtistDAO();
        return artistDao.find(id);
    }
    
    private Album resultSetToAlbum(ResultSet rs) throws SQLException {
        return new Album(
            rs.getInt("id"), 
            rs.getString("name"), 
            rs.getInt("year"), 
            rs.getString("label"),
            new ArtistDAO().find(rs.getInt("artist_id"))
        );
    }
}
