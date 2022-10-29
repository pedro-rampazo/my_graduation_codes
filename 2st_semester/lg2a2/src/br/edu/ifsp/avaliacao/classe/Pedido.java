package src.br.edu.ifsp.avaliacao.classe;

import src.br.edu.ifsp.avaliacao.util.Data;
import src.br.edu.ifsp.avaliacao.leitor.Leitor;
import java.util.ArrayList;

public class Pedido {
    private int id_pedido;
    private String cpf_cliente;
    private Data data_pedido;
    private Cliente cliente;
    private String vendedor;
    private double valor_pedido;
    //private ItemPedido[] lista_item;


    public Pedido(String caminho, int indice, String valor) throws Exception{
        Leitor leitor = new Leitor(caminho, indice, valor);
        ArrayList<String> lista_pedido = leitor.conteudo();
        String pedido = lista_pedido.get(0);
        String[] campos = pedido.split(";");
        
        this.id_pedido = Integer.parseInt(campos[0]);
        this.cpf_cliente = campos[1];

        String caminho_cliente = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/Cliente.txt";
        this.cliente = new Cliente(caminho_cliente, 0, this.cpf_cliente);
        
        String[] campo_data = campos[2].split("/");
        int dia = Integer.parseInt(campo_data[0]);
        int mes = Integer.parseInt(campo_data[1]);
        int ano = Integer.parseInt(campo_data[2]);
        this.data_pedido = new Data(dia, mes, ano);
        
        this.vendedor = campos[3];
        this.valor_pedido = Double.parseDouble(campos[4]);
    }

    public Pedido(int id_pedido, String cpf_cliente, Data data_pedido, String vendedor, double valor_pedido){
        this.id_pedido = id_pedido;
        this.cpf_cliente = cpf_cliente;
        this.data_pedido = data_pedido;
        this.vendedor = vendedor;
        this.valor_pedido = valor_pedido;
    }

    @Override
    public String toString(){
        return "\nPEDIDO:\n\t[ID_PEDIDO = " + this.id_pedido + ",CLIENTE = " + this.cliente.getNome() + ", DATA_PEDIDO = " + this.data_pedido + ",VENDEDOR = " + this.vendedor + ",VALOR_PEDIDO = " + this.valor_pedido + "]";
    }

}
