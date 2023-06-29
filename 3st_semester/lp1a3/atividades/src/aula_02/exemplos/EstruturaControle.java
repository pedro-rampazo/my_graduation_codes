package aula_02.exemplos;

public class EstruturaControle {
    private static final int MAIOR_IDADE = 18;

    public static void main(String[] args) {
        var idade = 19;

        if (idade >= MAIOR_IDADE) {
            System.out.println("Maior de Idade");
        }

        var ligado = true;
        if (ligado) {
            System.out.println("Ligado");
        } else {
            System.out.println("Desligado");
        }

        int contador = 0;
        while (contador < 3) {
            System.out.println("Teste" + contador);
        }

        contador = 0;
        do {
            System.out.println("Teste" + contador);
        } while (contador < 3);

        String[] palavras = {"Olá", "Mundo", "!"}; 
        for (int i = 0; i < palavras.length; i++) {
            System.out.println(palavras[i]);
        }

        for (var palavra : palavras) {
            System.out.println(palavra);
        }

        // char, byte, short, int
        // enuns
        // LITERAIS DE STRING

        int x = 3; 
        switch (x) {
            case 1:
                System.out.println("Um");
                break;
            case 2:
                System.out.println("Dois");
            case 3:
                System.out.println("Três");
            default:
                System.out.println("??");
                break;
        }

    }
}
