package src.br.edu.ifsp.avaliacao.teste;

import src.br.edu.ifsp.avaliacao.classe.Comissao;

public class ComissaoTeste {
    public static void main(String[] args) throws Exception {
        String path = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/Comissao.txt";
        Comissao comissao = new Comissao(path, 0, "Marcos");
        System.out.println("---> " + comissao);
    }
}
