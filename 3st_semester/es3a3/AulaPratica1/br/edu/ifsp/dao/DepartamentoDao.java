package br.edu.ifsp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.model.departamento.Departamento;
import br.edu.ifsp.model.funcionario.Funcionario;

public class DepartamentoDao extends GenericDao {
    private String instrucaoSql;
    private PreparedStatement comando;
    private ResultSet registros;
    private static String excecao = null;

    public List<Funcionario> recuperaFuncionarios() {
        Funcionario funcionario;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        instrucaoSql = "SELECT * FROM `Funcionario`";

        try {
            excecao = ConnectionDatabase.conectaBd();
            if (excecao == null) {
                comando = ConnectionDatabase.getConexaoBd().prepareStatement(instrucaoSql);
                registros = comando.executeQuery();

                if (registros.next()) {
                    registros.beforeFirst();
                    while (registros.next()) {
                        funcionario = new Funcionario();
                        funcionario.setId(registros.getInt("Id"));
                        funcionario.setNome(registros.getString("Nome"));
                        funcionario.setSexo(registros.getString("Sexo").charAt(0));
                        funcionario.setSalario(registros.getBigDecimal("Salario"));
                        funcionario.setPlanoSaude(registros.getBoolean("PlanoSaude"));
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

    public List<Departamento> consultaDepartamento() {
        Departamento departamento;
        Funcionario funcionario;
        List<Departamento> departamentos = new ArrayList<Departamento>();
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        instrucaoSql = "SELECT * FROM `Departamento`";

        try {
            excecao = ConnectionDatabase.conectaBd();
            
            if (excecao == null) {
                comando = ConnectionDatabase.getConexaoBd().prepareStatement(instrucaoSql);
                registros = comando.executeQuery();

                if (registros.next()) {
                    registros.beforeFirst();
                    funcionarios = recuperaFuncionarios();

                    while (registros.next()) {
                        departamento = new Departamento();
                        departamento.setId(registros.getInt("Id"));
                        departamento.setNomeDepto(excecao);

                        funcionario = new Funcionario();
                        funcionario.setId(registros.getInt("IdFuncGerente"));
                        for (Funcionario f : funcionarios) {
                            if (f.getId() == funcionario.getId()) {
                                funcionario.setNome(f.getNome());
                                break;
                            }
                        }
                        departamento.setGerente(funcionario);
                        departamentos.add(departamento);
                    }
                }
                registros.close();
                comando.close();
                ConnectionDatabase.getConexaoBd().close();
            }
        } catch (Exception e) {
            excecao = "Tipo de Excecao: " + e.getClass().getSimpleName() + "\nMensagem: " + e.getMessage();
            departamentos = null;
        }
        return departamentos;
    }

}
