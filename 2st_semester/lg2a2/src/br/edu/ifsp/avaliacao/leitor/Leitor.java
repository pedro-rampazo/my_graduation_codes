package src.br.edu.ifsp.avaliacao.leitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Leitor {
    private String caminho_arquivo;
    private int indice_campo;
    private String valor_campo;

    public Leitor(String caminho_arquivo, int indice_campo, String valor_campo){
        this.caminho_arquivo = caminho_arquivo;
        this.indice_campo = indice_campo;
        this.valor_campo = valor_campo;
    }

    public ArrayList<String> conteudo() throws Exception{
        File file = new File(this.caminho_arquivo);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int contador_linha = 0;
        ArrayList<String> linhas = new ArrayList<String>();

        while((st = br.readLine()) != null){
            contador_linha = contador_linha + 1;
            if(contador_linha == 1){
                continue;
            }
            String[] campos = st.split(";");
            if(campos[indice_campo].equals(valor_campo)){
                linhas.add(st);
            }
        }
        br.close();
        return linhas;
    }
}
