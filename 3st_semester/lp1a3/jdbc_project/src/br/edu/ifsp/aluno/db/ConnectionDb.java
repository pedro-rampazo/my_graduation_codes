package br.edu.ifsp.aluno.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {

    public static Connection getConnection() {
        String url = "jdbc:sqlite:projectDB.sqlite";

        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
