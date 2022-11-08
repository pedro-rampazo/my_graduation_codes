package src.br.edu.ifsp.avaliacao.classe;

import src.br.edu.ifsp.avaliacao.leitor.Leitor;
import src.br.edu.ifsp.avaliacao.util.Data;
import java.util.ArrayList;

public class Comissao {
    private String vendedor;
    private Data data_inicio;
    private Data data_fim;
    private Pedido[] lista_venda;
    private double comissao_vendedor;

    public Comissao(String caminho, int indice, String valor) throws Exception {
        Leitor leitor = new Leitor(caminho, indice, valor);
        ArrayList<String> lista_comissao = leitor.conteudo();
        String comissao = lista_comissao.get(0);
        String[] campos = comissao.split(";");
        this.vendedor = campos[0];
        for(int i = 1; i < 3; i++){
            String[] campo_data = campos[i].split("/");
            int dia = Integer.parseInt(campo_data[0]);
            int mes = Integer.parseInt(campo_data[1]);
            int ano = Integer.parseInt(campo_data[2]);
            if(i == 1){
                this.data_inicio = new Data(dia, mes, ano);
            }else{
                this.data_fim = new Data(dia, mes, ano);
            }
        }

        String caminho_pedido = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/Pedido.txt";
        leitor = new Leitor(caminho_pedido, 3, this.vendedor);
        ArrayList<String> lista_pedido = leitor.conteudo();
        int quantidade_pedido = lista_pedido.size();
        this.lista_venda = new Pedido[quantidade_pedido];
        int index = 0;
        for(String unidade_pedido_aux : lista_pedido){
            campos = unidade_pedido_aux.split(";");
            String id_pedido = campos[0];
            String cpf_pedido = campos[1];
            String[] campo_data = campos[2].split("/");
            int dia_pedido = Integer.parseInt(campo_data[0]);
            int mes_pedido = Integer.parseInt(campo_data[1]);
            int ano_pedido = Integer.parseInt(campo_data[2]);
            Data data_pedido = new Data(dia_pedido, mes_pedido, ano_pedido);
            if(data_pedido.intervaloData(this.data_inicio, this.data_fim) == true){
                this.lista_venda[index] = new Pedido(Integer.parseInt(id_pedido), cpf_pedido, data_pedido, this.vendedor);
                this.comissao_vendedor += this.lista_venda[index].getComissaoTotal();
                index =+ 1;
            }
        }
    }

    @Override
    public String toString(){
        return "COMISSAO [VENDEDOR = " + this.vendedor + ", DATA_INICIO = " + this.data_inicio + ", DATA_FIM = " + this.data_fim + ", COMISSAO_VENDEDOR = " + this.comissao_vendedor + "]";
    }

}
