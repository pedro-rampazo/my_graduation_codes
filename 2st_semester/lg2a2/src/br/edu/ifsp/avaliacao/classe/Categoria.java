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

    public int getId(){
        return this.id_categoria;
    }

    public String getNome(){
        return this.nome;
    }

    public int getComissao(){
        return this.comissao;
    }

    public void setNome(String novo_nome){
        this.nome = novo_nome;
    }

    public void setComissao(int nova_comissao){
        this.comissao = nova_comissao;
    }

    @Override
    public String toString(){
        return "Categoria [id_categoria = " + this.id_categoria + ", nome = " + this.nome + ", comissao(%) = " + this.comissao + "]";    
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Categoria other = (Categoria) obj;
        if (id_categoria != other.id_categoria)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (comissao != other.comissao)
            return false;
        return true;
    }
}
