package src.br.edu.ifsp.avaliacao.classe;

import java.util.ArrayList;
import java.util.Arrays;

import src.br.edu.ifsp.avaliacao.leitor.Leitor;

public class Categoria {
    private int id_categoria;
    private String nome;
    private double comissao;

    public Categoria(String caminho, int indice, String valor) throws Exception{
        Leitor leitor = new Leitor(caminho, indice, valor);
        ArrayList<String> lista_categoria = leitor.conteudo();
        String categoria = lista_categoria.get(0);
        System.out.println(categoria);
        String[] campos = categoria.split(";");
        this.id_categoria = Integer.parseInt(campos[0]);
        this.nome = campos[1];
        double comissao_decimal = (Integer.parseInt(campos[2]) / 100); //POINT
        this.comissao = comissao_decimal;
    }

    @Override
    public String toString(){
        return "Categoria [id_categoria = " + this.id_categoria + ", nome = " + this.nome + ", comissao = " + String.format("%.2f", this.comissao) + "]";    
    }

}
