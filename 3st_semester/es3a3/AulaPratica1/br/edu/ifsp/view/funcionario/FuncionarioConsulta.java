package br.edu.ifsp.view.funcionario;

import java.util.List;
import java.util.Scanner;

import br.edu.ifsp.controller.FuncionarioController;
import br.edu.ifsp.model.funcionario.Funcionario;

public class FuncionarioConsulta {
    static Scanner entrada = new Scanner(System.in);
    
    public static void exibeInterface() {
        
        String excecaoFuncionarios = null;
        String excecaoCargos = null;
        String planoSaude;

        List<Funcionario> funcionarios = new FuncionarioController().consultaFuncionarios();
        excecaoFuncionarios = new FuncionarioController().getExcecao();
        String formato = "%1$-6s %2$-20s %3$-7s %4$-15s %5$-17s %6$-25s%n";

        if (excecaoFuncionarios != null) {
            System.out.println("Nao foi possivel recuperar os dados dos funcionarios:\n" + excecaoFuncionarios);
        } else {
            System.out.println("\nCONSULTA DE FUNCIONARIOS:");
            System.out.printf(formato, "CODIGO", " | NOME", " | SEXO", " | SALARIO (R$)", " | PLANO DE SAUDE", " | CARGO");

            for (Funcionario f : funcionarios) {
                if (f.isPlanoSaude()) {
                    planoSaude = "Sim";
                } else {
                    planoSaude = "Nao";
                }

                System.out.printf(formato, f.getId(), 
						           " | " + f.getNome(),
						           " | " + f.getSexo(),
						           " | " + f.getSalario(),
						           " | " + planoSaude,
						           " | " + f.getCargo().getDescricao());

            }
            System.out.println();
            // AULA PRATICA 2
            exibeOpcoesAlterarExcluir();
        }
    }

    // AULA PRATICA 2
    public static void exibeOpcoesAlterarExcluir() {
        int opcaoOperacao = 0;

        do {
            System.out.println("ALTERACAO / EXCLUSAO DE FUNCIONARIO:");
            System.out.println("1) Alterar");
            System.out.println("2) Excluir");
            System.out.print("Digite uma opcao (0 para voltar): ");

            opcaoOperacao = Integer.parseInt(entrada.nextLine());
            System.out.println();

            switch (opcaoOperacao) {
                case 0:
                    break;
                case 1:
                    FuncionarioAlteracao.exibeInterface();
                    break;
                case 2:
                    FuncionarioExclusao.exibeInterface();
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
