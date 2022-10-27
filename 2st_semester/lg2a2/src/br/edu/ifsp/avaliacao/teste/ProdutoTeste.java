package src.br.edu.ifsp.avaliacao.teste;

import src.br.edu.ifsp.avaliacao.classe.Produto;

public class ProdutoTeste {
    public static void main(String[] args) throws Exception{
        String path = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/Produto.txt";
        Produto produto = new Produto(path, 0, "444");
        System.out.println("---> " + produto);
    }
}
