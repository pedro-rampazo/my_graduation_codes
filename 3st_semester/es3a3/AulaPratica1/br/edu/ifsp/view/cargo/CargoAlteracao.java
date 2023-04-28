package br.edu.ifsp.view.cargo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.ifsp.controller.CargoController;

public class CargoAlteracao {
    static Scanner entrada = new Scanner(System.in);

    public static void exibeInterface() {
        Integer id;
        String descricao;

        System.out.println("ALTERACAO DE CARGO:");
        System.out.print("Informe o ID do cargo a ser alterado: ");
        id = Integer.parseInt(entrada.nextLine());
        System.out.print("DESCRICAO: ");
        descricao = entrada.nextLine();

        List<String> erros = new ArrayList<String>();

        erros = new CargoController().alteraCargo(id, descricao, CargoCadastro.leDepartamento());

        if (erros.get(0) == null) {
            System.out.println("Cargo alterado com sucesso.\n");
        } else {
            String mensagem = "Nao foi possivel alterar o cargo:\n";
            for (String e : erros) {
                mensagem = mensagem + e + "\n";
            }
            System.out.println(mensagem);
        }
    }
}
