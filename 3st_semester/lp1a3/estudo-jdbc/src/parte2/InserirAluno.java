package parte2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirAluno {
    public static void main(String[] args) throws SQLException {
        
        String url = "jdbc:sqlite:banco.sqlite";
        String nome = "João da Silva";
        String prontuario = "SP010101";
        String email = "joao@email.com";
        Boolean ativo = true;
        String sql = """        
            INSERT INTO alunos (nome, prontuario, email, ativo)
            VALUES (?, ?, ?, ?);
        """;
        
        try (
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement statement = connection.prepareStatement(sql);

        ) {
            statement.setString(1, nome);
            statement.setString(2, prontuario);
            statement.setString(3, email);
            statement.setBoolean(4, ativo);
            statement.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
