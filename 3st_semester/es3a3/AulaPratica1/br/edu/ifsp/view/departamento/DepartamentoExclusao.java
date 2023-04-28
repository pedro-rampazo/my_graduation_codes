package br.edu.ifsp.view.departamento;

import java.util.Scanner;

import br.edu.ifsp.controller.DepartamentoController;

public class DepartamentoExclusao {
    static Scanner entrada = new Scanner(System.in);

    public static void exibeInterface() {
        Integer id;

        System.out.println("EXCLUSAO DE DEPARTAMENTO:");
        System.out.print("Informe o ID do departamento a ser excluido: ");
        id = Integer.parseInt(entrada.nextLine());

        String erro = "";
        erro = new DepartamentoController().excluiDepartamento(id);

        if (erro == null) {
            System.out.println("Departamento excluido com sucesso.\n");
        } else {
            System.out.println("Nao foi possivel excluir o departamento:\n" + erro + "\n");
        }
    }

}
