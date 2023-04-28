package br.edu.ifsp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.model.cargo.Cargo;
import br.edu.ifsp.model.departamento.Departamento;

public class CargoDao extends GenericDao {
    private String instrucaoSql;
    private PreparedStatement comando;
    private ResultSet registros;
    private static String excecao = null;

    public List<Departamento> recuperaDepartamentos() {
        Departamento departamento;
        List<Departamento> departamentos = new ArrayList<Departamento>();
        instrucaoSql = "SELECT * FROM `Departamento`";

        try {
            excecao = ConnectionDatabase.conectaBd();
            if (excecao == null) {
                comando = ConnectionDatabase.getConexaoBd().prepareStatement(instrucaoSql);
                registros = comando.executeQuery();

                if (registros.next()) {
                    registros.beforeFirst();
                    while (registros.next()) {
                        departamento = new Departamento();
                        departamento.setId(registros.getInt("Id"));
                        departamento.setNomeDepto(registros.getString("NomeDepto"));
                        departamentos.add(departamento);
                    }
                }
                registros.close();
                comando.close();
            }
        } catch (Exception e) {
            excecao = "Tipo de Excecao: " + e.getClass().getSimpleName() + "\nMensagem: " + e.getMessage();
            departamentos = null;
        }
        return departamentos;
    }

    public String getExcecao() {
        return excecao;
    }

    public List<Cargo> consultaCargo() {
        Cargo cargo;
        Departamento departamento;
        List<Cargo> cargos = new ArrayList<Cargo>();
        List<Departamento> departamentos = new ArrayList<Departamento>();

        String instrucaoSql = "SELECT * FROM `Cargo`";
        PreparedStatement comando;
        ResultSet registros;

        try {
            excecao = ConnectionDatabase.conectaBd();

            if (excecao == null) {
                comando = ConnectionDatabase.getConexaoBd().prepareStatement(instrucaoSql);
                registros = comando.executeQuery();

                if (registros.next()) {
                    registros.beforeFirst();
                    departamentos = recuperaDepartamentos();

                    while (registros.next()) {
                        cargo = new Cargo();
                        cargo.setId(registros.getInt("Id"));
                        cargo.setDescricao(registros.getString("Descricao"));

                        departamento = new Departamento();
                        departamento.setId(registros.getInt("IdDepto"));
                        for (Departamento d : departamentos) {
                            if (d.getId() == departamento.getId()) {
                                departamento.setNomeDepto(d.getNomeDepto());
                                break;
                            }
                        }
                        cargo.setDepartamento(departamento);
                        cargos.add(cargo);
                    }
                registros.close();
                comando.close();
                ConnectionDatabase.getConexaoBd().close();        
                }
            }
        } catch (Exception e) {
            excecao = "Tipo de Excecao: " + e.getClass().getSimpleName() + "\nMensagem: " + e.getMessage();
            cargos = null;
        }
        return cargos;
    }

    // AULA PRÁTICA 2
    public String alteraCargo(Cargo cargo) {
        instrucaoSql = "UPDATE Cargo SET Descricao = ?, IdDepto = ? " + "WHERE Id = ?";
        return insereAlteraExclui(instrucaoSql, cargo.getDescricao(), cargo.getDepartamento().getId(), cargo.getId());
    }

    // AULA PRÁTICA 2
    public String excluiCargo(int id) {
        instrucaoSql = "DELETE FROM Cargo WHERE Id = ?";
        return insereAlteraExclui(instrucaoSql, id);
    }
}
