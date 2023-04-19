package br.edu.ifsp.view.departamento;

import java.util.List;

import br.edu.ifsp.controller.DepartamentoController;
import br.edu.ifsp.model.departamento.Departamento;;

public class DepartamentoConsulta {
    
    public static void exibeInterface() { 
        String excecaoDepartamentos = null;
        String excecaoFuncionarios = null;

        List<Departamento> departamentos = new DepartamentoController().consultaDepartamento();
        excecaoDepartamentos = new DepartamentoController().getExcecao(); // PAREI AQUI

    }

}
