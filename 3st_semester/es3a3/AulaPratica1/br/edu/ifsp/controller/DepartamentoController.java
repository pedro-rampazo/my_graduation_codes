package br.edu.ifsp.controller;

import java.util.List;
import java.util.ArrayList;

import br.edu.ifsp.dao.DepartamentoDao;
import br.edu.ifsp.model.departamento.Departamento;
import br.edu.ifsp.model.departamento.DepartamentoValidacao;
import br.edu.ifsp.model.funcionario.Funcionario;

public class DepartamentoController {
    private Departamento departamento;
    private List<String> erros;

    // AULA PRÁTICA 2
    public void recebeDadosDepartamento(Integer id, String nomeDepto, Funcionario gerente) {
        departamento = new Departamento();
        erros = new ArrayList<String>();

        departamento.setId(id);
        departamento.setNomeDepto(nomeDepto);
        departamento.setGerente(gerente);

        erros = DepartamentoValidacao.validaDepartamento(departamento);
    }

    // AULA PRÁTICA 2
    public List<Funcionario> recuperaFuncionarios() {
        return new DepartamentoDao().recuperaFuncionarios();
    }
    
    public String getExcecao() {
        return new DepartamentoDao().getExcecao();
    }

    public List<Departamento> consultaDepartamento() {
        return new DepartamentoDao().consultaDepartamento();
    }

    // AULA PRÁTICA 2
    public List<String> alteraDepartamento(Integer id, String nomeDepto, Funcionario gerente) {
        recebeDadosDepartamento(id, nomeDepto, gerente);
        if (erros.size() == 0) {
            erros.add(new DepartamentoDao().alteraDepartamento(departamento));
        }
        return erros;
    }

    // AULA PRÁTICA 2
    public String excluiDepartamento(Integer id) {
        String erro = new DepartamentoDao().excluiDepartamento(id);
        return erro;
    }

}
