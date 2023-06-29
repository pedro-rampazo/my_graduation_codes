package br.edu.ifsp.aluno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.aluno.db.ConnectionDb;
import br.edu.ifsp.aluno.model.Artist;

public class ArtistDAO {
    
    public Artist create(Artist artist) throws SQLException {
        String sql = """
            INSERT INTO artist (name, origin, formedIn, genre)
            VALUES (?, ?, ?, ?)        
        """;
        
        try(
            Connection connection = ConnectionDb.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, artist.getName());
            statement.setString(2, artist.getOrigin());
            statement.setInt(3, artist.getFormedIn());
            statement.setString(4, artist.getGenre());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                artist.setId(rs.getInt(1));
            }

            rs.close();

            return artist;
        } 
    }

    public Artist update(Artist artist) throws SQLException {
        String sql = """
            UPDATE artist SET name = ?, origin = ?, formedIn = ?, genre = ?
            WHERE id = ?        
        """;

        try (
            Connection connection = ConnectionDb.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, artist.getName());
            statement.setString(2, artist.getOrigin());
            statement.setInt(3, artist.getFormedIn());
            statement.setString(4, artist.getGenre());
            statement.setInt(5, artist.getId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                return artist;
            }
            return null;

        } catch (SQLException e) {
            return null;
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM artist WHERE id = ?";

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

    public void delete(Artist artist) {
        delete(artist.getId());
    }

    public Artist find(Integer id) throws SQLException {
        String sql = "SELECT * FROM artist WHERE id = ?";

        try (
            Connection connection = ConnectionDb.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            return resultSetToArtist(rs);
        }
    }

    public List<Artist> findAll() throws SQLException {
        String sql = "SELECT * FROM artist;";
        List<Artist> artists = new ArrayList<>();

        try (
            Connection connection = ConnectionDb.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while (rs.next()) {
                artists.add(resultSetToArtist(rs));
            }

            return artists;
        }
    }

    private Artist resultSetToArtist(ResultSet rs) throws SQLException {
        return new Artist(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("origin"),
            rs.getInt("formedIn"),
            rs.getString("genre")
        );
    }

}
