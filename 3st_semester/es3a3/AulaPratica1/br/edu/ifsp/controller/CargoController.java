package br.edu.ifsp.controller;

import java.util.List;

import br.edu.ifsp.dao.CargoDao;
import br.edu.ifsp.model.cargo.Cargo;

public class CargoController {
    private Cargo cargo;
    private List<String> erros;

    public String getExcecao() {
        return new CargoDao().getExcecao();
    }

    public List<Cargo> consultaCargo() {
        return new CargoDao().consultaCargo();
    }

}
