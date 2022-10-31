package src.br.edu.ifsp.avaliacao.classe;

import src.br.edu.ifsp.avaliacao.leitor.Leitor;
import java.util.ArrayList;

public class ItemPedido {
    private Produto produto;
    private String id_produto;
    private int quantidade;
    private double preco_venda;
    private String id_pedido;

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
    }

    public ItemPedido(String id_produto, int quantidade, int id_pedido) throws Exception{
        this.id_produto = id_produto;
        this.quantidade = quantidade;
        this.id_pedido = Integer.toString(id_pedido);
        String caminho_produto = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/Produto.txt";
        this.produto = new Produto(caminho_produto, 0, this.id_produto);
        this.preco_venda = this.quantidade * this.produto.getPreco();
    }

    public Double getPrecoVenda(){
        return this.preco_venda;
    }
        
    @Override
    public String toString(){
        return "ITEM_PEDIDO [PRODUTO = " + this.produto.getNome() + ", QUANTIDADE = " + this.quantidade + ", PRECO_VENDA = " + this.preco_venda + ", ID_PEDIDO = " + this.id_pedido + "]";
    }

}
