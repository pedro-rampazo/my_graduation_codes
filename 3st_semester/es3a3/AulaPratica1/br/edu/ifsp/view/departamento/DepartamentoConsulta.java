package br.edu.ifsp.view.departamento;

import java.util.List;
import java.util.Scanner;

import br.edu.ifsp.controller.DepartamentoController;
import br.edu.ifsp.model.departamento.Departamento;;

public class DepartamentoConsulta {
    static Scanner entrada = new Scanner(System.in);
    
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
            exibeOpcoesAlterarExcluir();
        }
    }

    public static void exibeOpcoesAlterarExcluir() {
        int opcaoOperacao = 0;

        do {
            System.out.println("ALTERACAO / EXCLUSAO DE DEPARTAMENTO:");
            System.out.println("1) Alterar");
            System.out.println("2) Excluir");
            System.out.print("Digite uma opcao (0 para voltar): ");

            opcaoOperacao = Integer.parseInt(entrada.nextLine());
            System.out.println();

            switch (opcaoOperacao) {
                case 0:
                    break;
                case 1:
                    DepartamentoAlteracao.exibeInterface();
                    break;
                case 2:
                    DepartamentoExclusao.exibeInterface();
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
