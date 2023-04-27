package br.edu.ifsp.controller;

import java.util.List;

import br.edu.ifsp.dao.DepartamentoDao;
import br.edu.ifsp.model.departamento.Departamento;

public class DepartamentoController {
    private Departamento departamento;
    private List<String> erros;

    public String getExcecao() {
        return new DepartamentoDao().getExcecao();
    }

    public List<Departamento> consultaDepartamento() {
        return new DepartamentoDao().consultaDepartamento();
    }

    public List<String> alteraFuncionario(Integer id, String nomeDepto, Funcionario gerente) {
        

    }

}
