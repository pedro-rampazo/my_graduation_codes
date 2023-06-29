package br.edu.ifsp.aluno.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableArtist {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDb.getConnection();

        String sql = """
            CREATE TABLE artist(
                id INTEGER PRIMARY KEY,
                name TEXT,
                origin TEXT,
                formedIn INTEGER,
                genre TEXT
            );        
        """;

        Statement statement = connection.createStatement();
        statement.execute(sql);

        statement.close();
        connection.close();
    }
}
