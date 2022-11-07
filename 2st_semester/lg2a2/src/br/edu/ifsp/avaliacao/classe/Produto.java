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

    public int getId(){
        return this.id_produto;
    }

    public String getNome(){
        return this.nome;
    }

    public Double getPreco(){
        return this.preco;
    }

    public String getCategoria(){
        return this.categoria.getNome();
    }

    public Double getComissao(){
        double decimal_value = ((double) this.categoria.getComissao()) / 100;
        return decimal_value;
    }

    public void setNome(String novo_nome){
        this.nome = novo_nome;
    }

    public void setPreco(double novo_preco){
        this.preco = novo_preco;
    }

    @Override
    public String toString(){
        return "PRODUTO [ID_PRODUTO = " + this.id_produto + ", NOME = " + this.nome + ", PRECO = " + this.preco + ", CATEGORIA = " + this.categoria.getNome() + ", COMISSAO(%) = " + this.categoria.getComissao() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (id_produto != other.id_produto)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
            return false;
        if (id_categoria == null) {
            if (other.id_categoria != null)
                return false;
        } else if (!id_categoria.equals(other.id_categoria))
            return false;
        if (categoria == null) {
            if (other.categoria != null)
                return false;
        } else if (!categoria.equals(other.categoria))
            return false;
        return true;
    }
}
