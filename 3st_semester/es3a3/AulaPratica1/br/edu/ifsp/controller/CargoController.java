package br.edu.ifsp.controller;

import java.util.List;
import java.util.ArrayList;

import br.edu.ifsp.dao.CargoDao;
import br.edu.ifsp.model.cargo.Cargo;
import br.edu.ifsp.model.cargo.CargoValidacao;
import br.edu.ifsp.model.departamento.Departamento;

public class CargoController {
    private Cargo cargo;
    private List<String> erros;

    // AULA PRÁTICA 2
    public void recebeDadosCargos(Integer id, String descricao, Departamento departamento) {
        cargo = new Cargo();
        erros = new ArrayList<String>();

        cargo.setId(id);
        cargo.setDescricao(descricao);
        cargo.setDepartamento(departamento);

        erros = CargoValidacao.validaCargo(cargo);
    }

    // AULA PRÁTICA 2
    public List<Departamento> recuperaDepartamentos() {
        return new CargoDao().recuperaDepartamentos();
    }

    public String getExcecao() {
        return new CargoDao().getExcecao();
    }

    public List<Cargo> consultaCargo() {
        return new CargoDao().consultaCargo();
    }

    // AULA PRÁTICA 2
    public List<String> alteraCargo(Integer id, String descricao, Departamento departamento) {
        recebeDadosCargos(id, descricao, departamento);
        if (erros.size() == 0) {
            erros.add(new CargoDao().alteraCargo(cargo));
        }
        return erros;
    }
    
    // AULA PRÁTICA 2
    public String excluiCargo(Integer id) {
        String erro = new CargoDao().excluiCargo(id);
        return erro;
    }

}
