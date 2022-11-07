package src.br.edu.ifsp.avaliacao.classe;

import src.br.edu.ifsp.avaliacao.leitor.Leitor;
import java.util.ArrayList;

public class ItemPedido {
    private Produto produto;
    private String id_produto;
    private int quantidade;
    private double preco_venda;
    private String id_pedido;
    private double comissao_item;

    public ItemPedido(String caminho, int indice, String valor) throws Exception{
        Leitor leitor = new Leitor(caminho, indice, valor);
        ArrayList<String> lista_item_pedido = leitor.conteudo();
        String item_pedido = lista_item_pedido.get(0);
        System.out.println(item_pedido);
        String[] campos = item_pedido.split(";");
        this.id_produto = campos[0];
        this.quantidade = Integer.parseInt(campos[1]);
        this.id_pedido = campos[2];
        String caminho_produto = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/Produto.txt";
        this.produto = new Produto(caminho_produto, 0, this.id_produto);
        this.preco_venda = this.quantidade * this.produto.getPreco();
        this.comissao_item = this.preco_venda * this.produto.getComissao();
    }

    public ItemPedido(String id_produto, int quantidade, int id_pedido) throws Exception{
        this.id_produto = id_produto;
        this.quantidade = quantidade;
        this.id_pedido = Integer.toString(id_pedido);
        String caminho_produto = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/Produto.txt";
        this.produto = new Produto(caminho_produto, 0, this.id_produto);
        this.preco_venda = this.quantidade * this.produto.getPreco();
        this.comissao_item = this.preco_venda * this.produto.getComissao();
    }

    public String getProduto(){
        return this.produto.getNome();
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public Double getPrecoVenda(){
        return this.preco_venda;
    }

    public String getIdPedido(){
        return this.id_pedido;
    }

    public Double getComissaoItem(){
        return this.comissao_item;
    }

    public void setQuantidade(int nova_quantidade){
        this.quantidade = nova_quantidade;
    }
        
    @Override
    public String toString(){
        return "ITEM_PEDIDO [PRODUTO = " + this.produto.getNome() + ", QUANTIDADE = " + this.quantidade + ", PRECO_VENDA = " + this.preco_venda + ", ID_PEDIDO = " + this.id_pedido + ", COMISSAO = " + this.comissao_item + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemPedido other = (ItemPedido) obj;
        if (produto == null) {
            if (other.produto != null)
                return false;
        } else if (!produto.equals(other.produto))
            return false;
        if (id_produto == null) {
            if (other.id_produto != null)
                return false;
        } else if (!id_produto.equals(other.id_produto))
            return false;
        if (quantidade != other.quantidade)
            return false;
        if (Double.doubleToLongBits(preco_venda) != Double.doubleToLongBits(other.preco_venda))
            return false;
        if (id_pedido == null) {
            if (other.id_pedido != null)
                return false;
        } else if (!id_pedido.equals(other.id_pedido))
            return false;
        return true;
    }
}
