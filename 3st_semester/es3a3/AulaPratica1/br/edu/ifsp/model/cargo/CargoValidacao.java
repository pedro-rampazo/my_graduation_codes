package br.edu.ifsp.model.cargo;

import java.util.ArrayList;
import java.util.List;

public class CargoValidacao {
    private static List<String> errosValidacao;

    public static List<String> validaCargo(Cargo cargo) {
        errosValidacao = new ArrayList<>();
        if (!cargo.getDescricao().equals("")) {
            if (cargo.getDescricao().length() < 5 || cargo.getDescricao().length() > 100) {
                errosValidacao.add("A descricao deve ter entre 5 e 100 caracteres.");
            }
        } else {
            errosValidacao.add("A descricao nao foi informado.");
        }
        if (cargo.getDepartamento() == null) {
            errosValidacao.add("O departamento nao foi informado.");
        }
        return errosValidacao;
    }
}
