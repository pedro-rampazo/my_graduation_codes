package src.br.edu.ifsp.avaliacao.classe;

import src.br.edu.ifsp.avaliacao.leitor.Leitor;
import java.util.ArrayList;

public class Produto {
    private int id_produto;
    private String nome;
    private double preco;
    private String id_categoria;
    private Categoria categoria;

    public Produto(String caminho, int indice, String valor) throws Exception {
        Leitor leitor = new Leitor(caminho, indice, valor);
        ArrayList<String> lista_produto = leitor.conteudo();
        String produto = lista_produto.get(0);
        System.out.println(produto);
        String[] campos = produto.split(";");
        this.id_produto = Integer.parseInt(campos[0]);
        this.nome = campos[1];
        this.preco = Double.parseDouble(campos[2]);
        this.id_categoria = campos[3];
        
        String caminho_categoria = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/Categoria.txt";
        this.categoria = new Categoria(caminho_categoria, 0, this.id_categoria);
    }

    public String getNome(){
        return this.nome;
    }

    public Double getPreco(){
        return this.preco;
    }

    @Override
    public String toString(){
        return "PRODUTO [ID_PRODUTO = " + this.id_produto + ", NOME = " + this.nome + ", PRECO = " + this.preco + ", CATEGORIA = " + this.categoria.getNome() + "]";
    }

}
