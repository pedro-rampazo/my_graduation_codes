package src.br.edu.ifsp.avaliacao.classe;

import java.util.ArrayList;

import src.br.edu.ifsp.avaliacao.leitor.Leitor;

public class Categoria {
    private int id_categoria;
    private String nome;
    private int comissao;

    public Categoria(String caminho, int indice, String valor) throws Exception{
        Leitor leitor = new Leitor(caminho, indice, valor);
        ArrayList<String> lista_categoria = leitor.conteudo();
        String categoria = lista_categoria.get(0);
        System.out.println(categoria);
        String[] campos = categoria.split(";");
        this.id_categoria = Integer.parseInt(campos[0]);
        this.nome = campos[1];
        this.comissao = Integer.parseInt(campos[2]);
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString(){
        return "Categoria [id_categoria = " + this.id_categoria + ", nome = " + this.nome + ", comissao(%) = " + this.comissao + "]";    
    }

}
