package br.edu.ifsp.view.cargo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.ifsp.controller.CargoController;
import br.edu.ifsp.model.departamento.Departamento;

public class CargoCadastro {
    static Scanner entrada = new Scanner(System.in);

    public static Departamento leDepartamento() {
        int codDepartamento;
        Departamento departamento = new Departamento();

        List<Departamento> departamentos = new ArrayList<Departamento>();
        departamentos = new CargoController().recuperaDepartamentos();
        String erro = new CargoController().getExcecao();

        if (erro != null) {
            System.out.println("Nao foi possivel recuperar os dados dos departamentos:\n" + erro);
        }

        if (departamentos.size() != 0) {
            System.out.println("DEPARTAMENTOS CADASTRADOS:");
            for (Departamento d : departamentos) {
                System.out.println(d.getId() + " - " + d.getNomeDepto());
            }
            System.out.print("DEPARTAMENTO (Digite o codigo do departamento): ");
            codDepartamento = Integer.parseInt(entrada.nextLine());
            for (Departamento d : departamentos) {
                if (d.getId() == codDepartamento) {
                    departamento = d;
                }
            }
        }
        return departamento;
    }

}
