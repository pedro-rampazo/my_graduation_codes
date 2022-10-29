package src.br.edu.ifsp.avaliacao.classe;

import src.br.edu.ifsp.avaliacao.leitor.Leitor;
import java.util.ArrayList;

public class ItemPedido {
    //private Produto produto;
    private int quantidade;
    private double preco_venda;

    public ItemPedido(String caminho, int indice, String valor) throws Exception{
        Leitor leitor = new Leitor(caminho, indice, valor);
        ArrayList<String> lista_item_pedido = leitor.conteudo();
        String item_pedido = lista_item_pedido.get(0);
        System.out.println(item_pedido);
        String[] campos = item_pedido.split(";");
        this.quantidade = Integer.parseInt(campos[0]);
        this.preco_venda = Double.parseDouble(campos[1]);
    }

    @Override
    public String toString(){
        return "Item Pedido [produto = ..., quantidade = " + this.quantidade + ", preco_venda = " + this.preco_venda + "]";
    }

}
