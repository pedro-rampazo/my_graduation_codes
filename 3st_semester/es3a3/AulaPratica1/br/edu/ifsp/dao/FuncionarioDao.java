package br.edu.ifsp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.model.cargo.Cargo;
import br.edu.ifsp.model.funcionario.Funcionario;

public class FuncionarioDao extends GenericDao {
	private String instrucaoSql; // Atributo para armazenar a instru��o SQL a ser executada.
	private PreparedStatement comando; // Atributo usado para preparar e executar instru��es SQL.
	private ResultSet registros; // Atributo que recebe os dados retornados por uma instru��o SQL.
	private static String excecao = null; // Atributo para armazenar mensagens de excecao.

    // AULA PRÁTICA 2
    public String insereFuncionario(Funcionario funcionario) {
        instrucaoSql = "INSERT INTO Funcionario (Nome, Sexo, Salario, PlanoSaude, IdCargo) VALUES (?,?,?,?,?)";
        return insereAlteraExclui(instrucaoSql, funcionario.getNome(), funcionario.getSexo().toString(), funcionario.getSalario(),
        	                        funcionario.isPlanoSaude(), funcionario.getCargo().getId());
    }
    
    public List<Cargo> recuperaCargos() {
        Cargo cargo;
        List<Cargo> cargos = new ArrayList<Cargo>();
        instrucaoSql = "SELECT * FROM Cargo";
        
        try {
        	excecao = ConnectionDatabase.conectaBd(); // Abre a conex�o com o banco de dados.
        	if (excecao == null) {
                // Obt�m os dados de conex�o com o banco de dados e prepara a instru��o SQL.
                comando = ConnectionDatabase.getConexaoBd().prepareStatement(instrucaoSql);
                
                // Executa a instru��o SQL e retorna os dados ao objeto ResultSet.
                registros = comando.executeQuery();
                
                if (registros.next()) { // Se for retornado pelo menos um registro.
                    registros.beforeFirst(); // Retorna o cursor para antes do 1� registro.
        	        while (registros.next()) {
                        // Atribui o Id e a Descri��o do cargo ao objeto Cargo por meio dos m�todos set e
                        // adiciona este objeto ao ArrayList funcionarios.
        	            cargo = new Cargo();
        	            cargo.setId(registros.getInt("Id"));
        	            cargo.setDescricao(registros.getString("Descricao"));
        	            cargos.add(cargo);
        	        }
        	    }
                registros.close(); // Libera os recursos usados pelo objeto ResultSet.
                comando.close(); // Libera os recursos usados pelo objeto PreparedStatement.
                // Libera os recursos usados pelo objeto Connection e fecha a conex�o com o banco de dados.
                ConnectionDatabase.getConexaoBd().close(); 
            }
        } catch (Exception e) {
        	excecao = "Tipo de Excecao: " + e.getClass().getSimpleName() + "\nMensagem: " + e.getMessage();
        	cargos = null; // Caso ocorra qualquer exce��o.
        }
        return cargos; // Retorna o ArrayList de objetos Cargo.
    }
    
    // Esse m�todo � necess�rio, porque os m�todos "recuperaCargos" e "consultaFuncionarios" retornam List<> e n�o String.
	public String getExcecao() {
		return excecao;
	}

    // AULA 08
    public List<Funcionario> consultaFuncionario() {
        Funcionario funcionario;
        Cargo cargo;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        List<Cargo> cargos = new ArrayList<Cargo>();

        String instrucaoSql = "SELECT * FROM `Funcionario`";
        PreparedStatement comando;
        ResultSet registros;

        try {
            excecao = ConnectionDatabase.conectaBd();
            if (excecao == null) {
                comando = ConnectionDatabase.getConexaoBd().prepareStatement(instrucaoSql);
                registros = comando.executeQuery();

                if (registros.next()) {
                    registros.beforeFirst();
                    cargos = recuperaCargos();

                    while (registros.next()) {
                        funcionario = new Funcionario();
                        funcionario.setId(registros.getInt("Id"));
                        funcionario.setNome(registros.getString("Nome"));
                        funcionario.setSexo(registros.getString("Sexo").charAt(0));
                        funcionario.setSalario(registros.getBigDecimal("Salario"));
                        funcionario.setPlanoSaude(registros.getBoolean("PlanoSaude"));

                        cargo = new Cargo();
                        cargo.setId(registros.getInt("IdCargo"));
                        for (Cargo c : cargos) {
                            if (c.getId() == cargo.getId()) {
                                cargo.setDescricao(c.getDescricao());
                                break;
                            }
                        }
                        funcionario.setCargo(cargo);
                        funcionarios.add(funcionario);
                    }
                }
                registros.close();
                comando.close();
                ConnectionDatabase.getConexaoBd().close();
            }
        } catch (Exception e) {
            excecao = "Tipo de Excecao: " + e.getClass().getSimpleName() + "\nMensagem: " + e.getMessage();
            funcionarios = null;
        }
        return funcionarios;
    }

    // AULA PRÄTICA 2
    public String alteraFuncionario(Funcionario funcionario) {
        instrucaoSql = "UPDATE Funcionario SET Nome = ?, Sexo = ?, Salario = ?, PlanoSaude = ?, IdCargo = ? " + 
        "WHERE Id = ?";
        return insereAlteraExclui(instrucaoSql, funcionario.getNome(), funcionario.getSexo().toString(), funcionario.getSalario(),
                                    funcionario.isPlanoSaude(), funcionario.getCargo().getId(), funcionario.getId());
    }

    // AULA PRÁTICA 2
    public String excluiFuncionario(int id) {
        instrucaoSql = "DELETE FROM `Funcionario` WHERE `Id` = ?";
        return insereAlteraExclui(instrucaoSql, id);
    }

}
