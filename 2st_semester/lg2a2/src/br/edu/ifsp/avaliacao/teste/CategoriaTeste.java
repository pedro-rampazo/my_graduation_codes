package src.br.edu.ifsp.avaliacao.teste;

import src.br.edu.ifsp.avaliacao.classe.Categoria;

public class CategoriaTeste {
    public static void main(String[] args) throws Exception{
        String path = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/Categoria.txt";
        Categoria categoria = new Categoria(path, 0, "8");
        System.out.println("---> " + categoria);
    }
}
