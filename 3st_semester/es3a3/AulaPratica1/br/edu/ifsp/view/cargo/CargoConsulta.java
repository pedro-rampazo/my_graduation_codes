package br.edu.ifsp.view.cargo;

import java.util.List;

import br.edu.ifsp.controller.CargoController;
import br.edu.ifsp.model.cargo.Cargo;

public class CargoConsulta {
    
    public static void exibeInterface() {
        String excecaoCargos = null;

        List<Cargo> cargos = new CargoController().consultaCargo();
        excecaoCargos = new CargoController().getExcecao();
        String formato = "%1$-6s %2$-30s %3$-30s%n";

        if (excecaoCargos != null) {
            System.out.println("Nao foi possivel recuperar os dados dos cargos:\n" + excecaoCargos);
        } else {
            System.out.println("\nCONSULTA DE CARGOS:");
            System.out.printf(formato, "CODIGO", " | DESCRICAO", " | DEPARTAMENTO");

            for (Cargo c : cargos) {
                System.out.printf(formato, c.getId(),
                                    " | " + c.getDescricao(),
                                    " | " + c.getDepartamento().getNomeDepto());
            }
            System.out.println();
        }
    }

}
