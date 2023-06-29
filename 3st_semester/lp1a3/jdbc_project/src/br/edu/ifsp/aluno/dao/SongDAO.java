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
import br.edu.ifsp.aluno.model.Song;

public class SongDAO {
    
    public Song create(Song song) throws SQLException {
        String sql = """
            INSERT INTO song (name, duration, track, album_id)
            VALUES (?, ?, ?, ?)       
        """;

        try (
            Connection connection = ConnectionDb.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, song.getName());
            statement.setString(2, song.getDuration());
            statement.setInt(3, song.getTrack());
            statement.setInt(4, song.getAlbum().getId());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
               song.setId(rs.getInt(1));
            }

            rs.close();

            return song;
        }
    }

    public Song update(Song song) {
        String sql = """
            UPDATE song SET name = ?, duration = ?, track = ?, album_id = ?
            WHERE id = ?
        """;

        try (
            Connection connection = ConnectionDb.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, song.getName());
            statement.setString(2, song.getDuration());
            statement.setInt(3, song.getTrack());
            statement.setInt(4, song.getAlbum().getId());
            statement.setInt(5, song.getId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                return song;
            }
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM song WHERE id = ?";

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

    public void delete(Song song) {
        delete(song.getId());
    }

    public Song find(Integer id) throws SQLException {
        String sql = "SELECT * FROM song WHERE id = ?";

        try (
            Connection connection = ConnectionDb.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            return resultSetToSong(rs);
        } 
    }

    public List<Song> findAll() throws SQLException {
        String sql = "SELECT * FROM song;";
        List<Song> songs = new ArrayList<>();

        try (
            Connection connection = ConnectionDb.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while (rs.next()) {
                songs.add(resultSetToSong(rs));
            }

            return songs;
        }        
    }

    public Album recoverAlbum(Integer id) throws SQLException {
        AlbumDAO albumDao = new AlbumDAO();
        return albumDao.find(id);
    }

    private Song resultSetToSong(ResultSet rs) throws SQLException {
        return new Song(
            rs.getInt("id"), 
            rs.getString("name"), 
            rs.getString("duration"), 
            rs.getInt("track"), 
            new AlbumDAO().find(rs.getInt("album_id"))
        );
    }

}
