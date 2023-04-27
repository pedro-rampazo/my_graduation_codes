package br.edu.ifsp.view.funcionario;

import java.util.Scanner;

import br.edu.ifsp.controller.FuncionarioController;

public class FuncionarioExclusao {
    static Scanner entrada = new Scanner(System.in);

    public static void exibeInterface() {
        Integer id;

        System.out.println("EXCLUSAO DE FUNCIONARIO:");
        System.out.print("Informe o ID do funcionario a ser excluido: ");
        id = Integer.parseInt(entrada.nextLine());

        String erro = "";

        erro = new FuncionarioController().excluiFuncionario(id);

        if (erro == null) {
            System.out.println("Funcionario excluido com sucesso.\n");
        } else {
            System.out.println("Nao foi possivel excluir o funcionario:\n" + erro + "\n");
        }

    }

}
