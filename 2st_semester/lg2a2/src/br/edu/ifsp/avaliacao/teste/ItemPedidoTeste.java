package src.br.edu.ifsp.avaliacao.teste;

import src.br.edu.ifsp.avaliacao.classe.ItemPedido;

public class ItemPedidoTeste {
    public static void main(String[] args) throws Exception{
        String path = "/home/pedro/Development/git_space/my_graduation_codes/2st_semester/lg2a2/src/ItemPedido.txt";
        ItemPedido item_pedido = new ItemPedido(path, 0, "444");
        System.out.println("---> " + item_pedido);
    }
}
