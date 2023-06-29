package br.edu.ifsp.aluno.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableAlbum {
    
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDb.getConnection();

        String sql = """
            CREATE TABLE album(
                id INTEGER PRIMARY KEY,
                name TEXT,
                year INTEGER,
                label TEXT,
                artist_id INTEGER
            );        
        """;

        Statement statement = connection.createStatement();
        statement.execute(sql);

        statement.close();
        connection.close();
    }

}
