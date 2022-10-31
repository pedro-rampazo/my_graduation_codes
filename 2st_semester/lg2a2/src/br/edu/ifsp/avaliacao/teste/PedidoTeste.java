package src.br.edu.ifsp.avaliacao.teste;

import src.br.edu.ifsp.avaliacao.classe.Pedido;

public class PedidoTeste {
    public static void main(String[] args) throws Exception{
        String path = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/Pedido.txt";
        Pedido pedido = new Pedido(path, 0, "52");
        System.out.println("---> " + pedido);
    }
}
