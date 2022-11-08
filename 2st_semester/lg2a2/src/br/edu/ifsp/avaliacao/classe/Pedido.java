package src.br.edu.ifsp.avaliacao.classe;

import src.br.edu.ifsp.avaliacao.util.Data;
import src.br.edu.ifsp.avaliacao.leitor.Leitor;
import java.util.ArrayList;
import java.util.Arrays;

public class Pedido {
    private int id_pedido;
    private String cpf_cliente;
    private Data data_pedido;
    private Cliente cliente;
    private String vendedor;
    private double valor_pedido;
    private ItemPedido[] lista_item;
    private double comissao_total;


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

        String caminho_item_pedido = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/ItemPedido.txt";
        leitor = new Leitor(caminho_item_pedido, 2,  Integer.toString(this.id_pedido));
        ArrayList<String> lista_item_pedido = leitor.conteudo();
        int quantidade_item_pedido = lista_item_pedido.size();
        this.lista_item = new ItemPedido[quantidade_item_pedido];
        int index = 0;
        this.comissao_total = 0;
        for(String item_pedido_aux : lista_item_pedido){
            campos = item_pedido_aux.split(";");
            String id_produto = campos[0];
            int quantidade = Integer.parseInt(campos[1]);
            ItemPedido unidade_item_pedido = new ItemPedido(id_produto, quantidade, this.id_pedido);
            this.lista_item[index] = unidade_item_pedido;
            this.valor_pedido += unidade_item_pedido.getPrecoVenda();
            this.comissao_total += unidade_item_pedido.getComissaoItem();
            index =+ 1;
        }

    }

    
    public Pedido(int id_pedido, String cpf_cliente, Data data_pedido, String vendedor) throws Exception{
        this.id_pedido = id_pedido;
        this.cpf_cliente = cpf_cliente;
        this.data_pedido = data_pedido;
        this.vendedor = vendedor;

        String caminho_item_pedido = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/ItemPedido.txt";
        Leitor leitor = new Leitor(caminho_item_pedido, 2, Integer.toString(this.id_pedido));
        ArrayList<String> lista_item_pedido = leitor.conteudo();
        int quantidade_item_pedido = lista_item_pedido.size();
        this.lista_item = new ItemPedido[quantidade_item_pedido];
        int index = 0;
        for(String item_pedido_aux : lista_item_pedido){
            String[] campos = item_pedido_aux.split(";");
            String id_produto = campos[0];
            int quantidade = Integer.parseInt(campos[1]);
            ItemPedido unidade_item_pedido = new ItemPedido(id_produto, quantidade, this.id_pedido);
            this.lista_item[index] = unidade_item_pedido;
            this.valor_pedido += unidade_item_pedido.getPrecoVenda();
            this.comissao_total += unidade_item_pedido.getComissaoItem();
            index =+ 1;
        }
    }
 
    public int getId(){
        return this.id_pedido;
    }

    public Data getDataPedido(){
        return this.data_pedido;
    }

    public String getCliente(){
        return this.cliente.getNome();
    }

    public String getVendedor(){
        return this.vendedor;
    }

    public Double getValorPedido(){
        return this.valor_pedido;
    }

    public ItemPedido[] getListaItem(){
        return this.lista_item;
    }

    public Double getComissaoTotal(){
        return this.comissao_total;
    }

    public void setVendedor(String novo_vendedor){
        this.vendedor = novo_vendedor;
    }

    @Override
    public String toString() {   
        if(this.cliente == null){
            return "\nPEDIDO:\n\t[ID_PEDIDO = " + this.id_pedido + ", CPF_CLIENTE = " + this.cpf_cliente + ", DATA_PEDIDO = " + this.data_pedido + ", VENDEDOR = " + this.vendedor + ", VALOR_PEDIDO = " + this.valor_pedido + ", COMISSAO_TOTAL = " + this.comissao_total + ", LISTA_ITENS = " + Arrays.toString(this.lista_item) + "]";
        }else{
            return "\nPEDIDO:\n\t[ID_PEDIDO = " + this.id_pedido + ", CLIENTE = " + this.cliente.getNome() + ", DATA_PEDIDO = " + this.data_pedido + ", VENDEDOR = " + this.vendedor + ", VALOR_PEDIDO = " + this.valor_pedido + ", COMISSAO_TOTAL = " + this.comissao_total + " ,LISTA_ITENS = " + Arrays.toString(this.lista_item) + "]";
        }   
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        if (id_pedido != other.id_pedido)
            return false;
        if (cpf_cliente == null) {
            if (other.cpf_cliente != null)
                return false;
        } else if (!cpf_cliente.equals(other.cpf_cliente))
            return false;
        if (data_pedido == null) {
            if (other.data_pedido != null)
                return false;
        } else if (!data_pedido.equals(other.data_pedido))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (vendedor == null) {
            if (other.vendedor != null)
                return false;
        } else if (!vendedor.equals(other.vendedor))
            return false;
        if (Double.doubleToLongBits(valor_pedido) != Double.doubleToLongBits(other.valor_pedido))
            return false;
        if (!Arrays.equals(lista_item, other.lista_item))
            return false;
        return true;
    }
}
