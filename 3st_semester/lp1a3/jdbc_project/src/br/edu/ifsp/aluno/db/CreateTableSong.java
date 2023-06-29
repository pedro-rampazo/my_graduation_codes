package br.edu.ifsp.aluno.db;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableSong {
    
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDb.getConnection();

        String sql = """
            CREATE TABLE song(
                id INTEGER PRIMARY KEY,
                name TEXT,
                duration TEXT,
                track INTEGER,
                album_id INTEGER
            );        
        """;

        Statement statement = connection.createStatement();
        statement.execute(sql);

        statement.close();
        connection.close();
    }
}
