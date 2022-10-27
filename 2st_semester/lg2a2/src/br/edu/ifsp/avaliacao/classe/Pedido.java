package src.br.edu.ifsp.avaliacao.classe;

import src.br.edu.ifsp.avaliacao.classe.Cliente;
import src.br.edu.ifsp.avaliacao.util.Data;
import src.br.edu.ifsp.avaliacao.leitor.Leitor;
import java.util.ArrayList;

public class Pedido {
    private int id_pedido;
    //private Data data_pedido;
    //private Cliente cliente;
    private String vendedor;
    private double valor_pedido;
    //private ItemPedido[] lista_item;

    public Pedido(String caminho, int indice, String valor) throws Exception{
        Leitor leitor = new Leitor(caminho, indice, valor);
        ArrayList<String> lista_pedido = leitor.conteudo();
        String pedido = lista_pedido.get(0);
        String[] campos = pedido.split(";");
        this.id_pedido = Integer.parseInt(campos[0]);
        this.vendedor = campos[1];
        this.valor_pedido = Double.parseDouble(campos[2]);
    }

    @Override
    public String toString(){
        return "Pedido [id_pedido = " + this.id_pedido + ", vendedor = " + this.vendedor + ", valor_pedido = " + this.valor_pedido + "]";
    }

}
