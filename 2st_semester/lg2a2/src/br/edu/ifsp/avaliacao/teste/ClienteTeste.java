package src.br.edu.ifsp.avaliacao.teste;

import src.br.edu.ifsp.avaliacao.classe.Cliente;

public class ClienteTeste {
    public static void main(String[] args) throws Exception {
        String path = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/Cliente.txt";
        Cliente cliente = new Cliente(path, 0, "256");
        System.out.println("--->" + cliente);
    }
}
