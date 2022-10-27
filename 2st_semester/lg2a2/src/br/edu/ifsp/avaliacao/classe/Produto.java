package src.br.edu.ifsp.avaliacao.classe;

import src.br.edu.ifsp.avaliacao.leitor.Leitor;
import java.util.ArrayList;
import java.util.Arrays;

public class Produto {
    private int id_produto;
    private String nome;
    private double preco;
    //private Categoria categoria;

    public Produto(String caminho, int indice, String valor) throws Exception {
        Leitor leitor = new Leitor(caminho, indice, valor);
        ArrayList<String> lista_produto = leitor.conteudo();
        String produto = lista_produto.get(0);
        System.out.println(produto);
        String[] campos = produto.split(";");
        this.id_produto = Integer.parseInt(campos[0]);
        this.nome = campos[1];
        this.preco = Double.parseDouble(campos[2]);
    }

    @Override
    public String toString(){
        return "Produto [id_produto = " + this.id_produto + ", nome = " + this.nome + ", preco = " + this.preco + "]";
    }

}
