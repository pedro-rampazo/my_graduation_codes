package parte2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {
    public static void main(String[] args) throws SQLException {
        
        // 1. Criar a conexão
        String url = "jdbc:sqlite:banco.sqlite";

        try (
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
        ) {
            String sql = """        
            CREATE TABLE alunos(
                id INTEGER PRIMARY KEY,
                nome TEXT,
                prontuario TEXT,
                email TEXT,
                ativo INTEGER
            );
            """;
            statement.execute(sql);
        } catch (SQLException e) {
            // TODO: handle exception
        }

    }
}
