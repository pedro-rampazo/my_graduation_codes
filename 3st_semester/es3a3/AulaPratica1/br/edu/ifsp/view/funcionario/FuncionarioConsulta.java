package br.edu.ifsp.view.funcionario;

import java.util.List;

import br.edu.ifsp.controller.FuncionarioController;
import br.edu.ifsp.model.funcionario.Funcionario;

public class FuncionarioConsulta {
    
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
        }
    }
}
