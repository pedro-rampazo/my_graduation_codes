package src.br.edu.ifsp.avaliacao.classe;

import java.util.ArrayList;
import java.util.Arrays;
import src.br.edu.ifsp.avaliacao.leitor.Leitor;
import src.br.edu.ifsp.avaliacao.util.Data;

public class Cliente {
    private String cpf;
    private String nome;
    private Data data_cadastro;
    private String sexo;
    private String vendedor_atual;
    private Pedido[] lista_pedidos;

    public Cliente(String caminho, int indice, String valor) throws Exception {
        Leitor leitor = new Leitor(caminho, indice, valor);
        ArrayList<String> lista_cliente = leitor.conteudo();
        String cliente = lista_cliente.get(0);
        System.out.println(cliente);
        String[] campos = cliente.split(";");
        this.cpf = campos[0];
        this.nome = campos[1];
        String[] campo_data = campos[2].split("/");
        int dia = Integer.parseInt(campo_data[0]);
        int mes = Integer.parseInt(campo_data[1]);
        int ano = Integer.parseInt(campo_data[2]);
        this.data_cadastro = new Data(dia, mes, ano);
        this.sexo = campos[3];
        this.vendedor_atual = campos[4];

        String caminho_pedido = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/Pedido.txt";
        leitor = new Leitor(caminho_pedido, 1, this.cpf);
        ArrayList<String> pedidos = leitor.conteudo();
        int quantidade_pedidos = pedidos.size();
        this.lista_pedidos = new Pedido[quantidade_pedidos];
        int index = 0;
        for(String pedido_aux : pedidos){
            campos = pedido_aux.split(";");
            int id_pedido = Integer.parseInt(campos[0]);
            String cpf_pedido = campos[1];
            String[] campo_data_pedido = campos[2].split("/");
            int dia_pedido = Integer.parseInt(campo_data_pedido[0]);
            int mes_pedido = Integer.parseInt(campo_data_pedido[1]);
            int ano_pedido = Integer.parseInt(campo_data_pedido[2]);
            Data data_pedido = new Data(dia_pedido, mes_pedido, ano_pedido);
            String vendedor_pedido = campos[3];
            Pedido unidade_pedido = new Pedido(id_pedido, cpf_pedido, data_pedido, vendedor_pedido);
            this.lista_pedidos[index] = unidade_pedido;
            index =+ 1;
        }
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString(){
        return "CLIENTE:\n[\nCPF = " + this.cpf + ",\nNOME = " + this.nome + ",\nDATA_CADASTRO = " + this.data_cadastro + ",\nSEXO = " + this.sexo + ",\nVENDEDOR_ATUAL = " + this.vendedor_atual + ",\nLISTA_PEDIDOS = " + Arrays.toString(this.lista_pedidos) + "\n]";
    }

}
