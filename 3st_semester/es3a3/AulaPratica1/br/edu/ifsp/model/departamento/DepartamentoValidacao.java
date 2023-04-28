package br.edu.ifsp.model.departamento;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoValidacao {
    private static List<String> errosValidacao;

    public static List<String> validaDepartamento(Departamento departamento) {
        errosValidacao = new ArrayList<>();

        if (!departamento.getNomeDepto().equals("")) { 
            if (departamento.getNomeDepto().length() < 5 || departamento.getNomeDepto().length() > 100) {
                errosValidacao.add("O nome do departamento deve ter entre 5 e 100 caracteres.");
            }
        } else {
            errosValidacao.add("O nome do departamento nao foi informado.");
        }

        if (departamento.getGerente() == null) {
            errosValidacao.add("O gerente nao foi informado.");
        }

        return errosValidacao;
    }
}
