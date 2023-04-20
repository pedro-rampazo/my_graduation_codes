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
        String formato = "%1$-6s %2$-30s %3$-20s%n";

        if (excecaoDepartamentos != null) {
            System.out.println("Nao foi possivel recuperar os dados dos departamentos:\n" + excecaoDepartamentos);
        } else {
            System.out.println("\nCONSULTA DE DEPARTAMENTOS:");
            System.out.printf(formato, "CODIGO", " | NOME", " | GERENTE");

            for (Departamento d : departamentos) {
                
                System.out.printf(formato, d.getId(),
                                    " | " + d.getNomeDepto(),
                                    " | " + d.getGerente().getNome());

            }
            System.out.println();
        }
    }

}
