package parte4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// DAO = Data Access Object
public class AlunoDAO {
    // CRUD

    // public Aluno save(Aluno aluno) {
    //     return null;
    // }

    public Aluno create(Aluno aluno) {
        String sql = """        
            INSERT INTO alunos (nome, prontuario, email, ativo)
            VALUES (?, ?, ?, ?);
        """;

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
        
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getProntuario());
            statement.setString(3, aluno.getEmail());
            statement.setBoolean(4, aluno.getAtivo());
            statement.executeUpdate();
    
            ResultSet rs = statement.getGeneratedKeys();
    
            if (rs.next()) {
                aluno.setId(rs.getInt(1));
            }
            
            rs.close();

            return aluno;
        } catch (SQLException e) {
            return null;
        }
    }

    public Aluno update(Aluno aluno) throws SQLException {
        String sql = """        
            UPDATE alunos 
            SET nome = ?, prontuario = ?, email = ?, ativo = ?
            WHERE id = ?;
        """;
        
        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql);
        ) {
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getProntuario());
            statement.setString(3, aluno.getEmail());
            statement.setBoolean(4, aluno.getAtivo());
            statement.setInt(5, aluno.getId());

            statement.executeUpdate();

            return aluno;
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM alunos WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            // return null;
        }       
    }

    public void detete(Aluno aluno) {
        delete(aluno.getId());
    }

    public Aluno findById(Integer id) {
        String sql = "SELECT * FROM alunos WHERE id = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql);
        ) {
            statement.setInt(1, id);
    
            ResultSet rs = statement.executeQuery();
    
            return resultSetToAluno(rs);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Aluno> findAll() {
        String sql = "SELECT * FROM alunos;";
        
        List<Aluno> alunos = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            Statement statement = connection
                .createStatement();
        ) {
            ResultSet rs = statement.executeQuery(sql);
    
    
            while(rs.next()) {
                alunos.add(resultSetToAluno(rs));
            }
    
            return alunos;
        } catch (SQLException e) {
            return alunos;
        }
    }

    private Aluno resultSetToAluno(ResultSet rs) throws SQLException {
        return new Aluno(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getString("prontuario"),
            rs.getString("email"),
            rs.getBoolean("ativo")
        );
    }
}
