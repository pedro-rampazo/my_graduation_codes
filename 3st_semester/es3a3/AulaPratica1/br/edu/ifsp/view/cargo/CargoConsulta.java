package br.edu.ifsp.view.cargo;

import java.util.List;
import java.util.Scanner;

import br.edu.ifsp.controller.CargoController;
import br.edu.ifsp.model.cargo.Cargo;

public class CargoConsulta {
    static Scanner entrada = new Scanner(System.in);
    
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
            exibeOpcoesAlterarExcluir();
        }
    }

    public static void exibeOpcoesAlterarExcluir() {
        int opcaoOperacao = 0;

        do {
            System.out.println("ALTERACAO / EXCLUSA DE CARGO:");
            System.out.println("1) Alterar");
            System.out.println("2) Excluir");
            System.out.print("Digite uma opcao (0 para voltar): ");

            opcaoOperacao = Integer.parseInt(entrada.nextLine());
            System.out.println();

            switch (opcaoOperacao) {
                case 0:
                    break;
                case 1:
                    CargoAlteracao.exibeInterface();
                    break;
                case 2:
                    CargoExclusao.exibeInterface();
                    break;
                default:
                    if (opcaoOperacao != 1 && opcaoOperacao != 2) {
                        System.out.println("Digite uma opcao valida.");
                    }
                    break;
            }
        } while (opcaoOperacao != 0 && opcaoOperacao != 1 && opcaoOperacao != 2);
    }
}
