package br.edu.ifsp.view.cargo;

import java.util.Scanner;

import br.edu.ifsp.controller.CargoController;

public class CargoExclusao {
    static Scanner entrada = new Scanner(System.in);

    public static void exibeInterface() {
        Integer id;

        System.out.println("EXCLUSAO DE CARGO:");
        System.out.print("Informe o ID do cargo a ser excluido: ");
        id = Integer.parseInt(entrada.nextLine());

        String erro = "";

        erro = new CargoController().excluiCargo(id);

        if (erro == null) {
            System.out.println("Cargo excluido com sucesso.\n");
        } else {
            System.out.println("Nao foi possivel excluir o cargo:\n" + erro + "\n");
        }
    }
}
