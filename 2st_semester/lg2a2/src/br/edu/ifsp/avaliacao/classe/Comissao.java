package src.br.edu.ifsp.avaliacao.classe;

import src.br.edu.ifsp.avaliacao.leitor.Leitor;
import src.br.edu.ifsp.avaliacao.util.Data;
import java.util.ArrayList;

public class Comissao {
    private String vendedor;
    private Data data_inicio;
    private Data data_fim;

    public Comissao(String caminho, int indice, String valor) throws Exception {
        Leitor leitor = new Leitor(caminho, indice, valor);
        ArrayList<String> lista_comissao = leitor.conteudo();
        String comissao = lista_comissao.get(0);
        System.out.println(comissao);
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
    }

    @Override
    public String toString(){
        return "COMISSAO [VENDEDOR = " + this.vendedor + ", DATA_INICIO = " + this.data_inicio + ", DATA_FIM = " + this.data_fim + ", COMISSAO_TOTAL = ...]";
    }

}
