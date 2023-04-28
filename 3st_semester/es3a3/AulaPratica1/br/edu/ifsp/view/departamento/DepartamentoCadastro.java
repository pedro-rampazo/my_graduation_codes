package br.edu.ifsp.view.departamento;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import br.edu.ifsp.controller.DepartamentoController;
import br.edu.ifsp.model.funcionario.Funcionario;

public class DepartamentoCadastro {
    static Scanner entrada = new Scanner(System.in);

    public static Funcionario leFuncionario() {
        int codFuncGerente;
        Funcionario gerente = new Funcionario();
        List<Funcionario> gerentes = new ArrayList<Funcionario>();
        gerentes = new DepartamentoController().recuperaFuncionarios();
        String erro = new DepartamentoController().getExcecao();
        if (erro != null) {
            System.out.println("Nao foi possivel recuperar os dados:\n" + erro);
        }
        if (gerentes.size() != 0) {
            System.out.println("FUNCIONARIOS CADASTRADOS: ");
            for (Funcionario g : gerentes) {
                System.out.println(g.getId() + " - " + g.getNome());
            }
            System.out.print("GERENTE (Digite o codigo do cargo): ");
            codFuncGerente = Integer.parseInt(entrada.nextLine());
            for (Funcionario g : gerentes) {
                if (g.getId() == codFuncGerente) {
                    gerente = g;
                }
            }
        }
        return gerente;
    }
}
