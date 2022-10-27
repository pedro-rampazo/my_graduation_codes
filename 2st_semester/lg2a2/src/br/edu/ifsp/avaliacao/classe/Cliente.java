package src.br.edu.ifsp.avaliacao.classe;

import java.util.ArrayList;
import java.util.Arrays;
import src.br.edu.ifsp.avaliacao.leitor.Leitor;
import src.br.edu.ifsp.avaliacao.util.Data;

public class Cliente {
    private String cpf;
    private String nome;
    //private Pedido[] lista_pedidos;
    //private Data data_cadastro;
    private String sexo;
    private String vendedor_atual;

    public Cliente(String caminho, int indice, String valor) throws Exception {
        Leitor leitor = new Leitor(caminho, indice, valor);
        ArrayList<String> lista_cliente = leitor.conteudo();
        String cliente = lista_cliente.get(0);
        System.out.println(cliente);
        String[] campos = cliente.split(";");
        this.cpf = campos[0];
        this.nome = campos[1];
        this.sexo = campos[2];
        this.vendedor_atual = campos[3];
    }

    @Override
    public String toString(){
        return "Cliente [cpf = " + this.cpf + ", nome = " + this.nome + ", sexo = " + this.sexo + ", vendedor_atual = " + this.vendedor_atual + "]";
    }

}
