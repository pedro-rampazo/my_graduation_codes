package aula_01.exemplos;

import java.util.Scanner;

public class Introducao{
    
    public static void main(String[] args){
        // COMENTÁRIOS
        /* COMENTÁRIO DE MÚLTIPLAS LINHAS */

        // CTRL + /
        // if (condition) {
            
        // } else {
            
        // }

        // TIPOS PRIMITIVOS

        // INTEIROS
        // byte, short, int, long
        int n1 = 10;
        byte n2 = 100; // -128 a 127

        // PONTO FLUTUANTE
        // FLOAT, DOUBLE
        float nota1 = 9.5f;
        double nota2 = 9.5;

        // CHAR
        char letra = 'a';
        
        // BOOL
        boolean ligado = true;
        
        // STRING
        String frase = "Olá, Mundo!";
        System.out.println(frase);
        System.out.println(frase.toLowerCase());
        System.out.println(frase.toUpperCase());

        // ARRAYS
        // double[] numeros = new double[3];
        double[] numeros = {2.3, 6.3, 9.3};
        numeros[0] = 2.3;
        numeros[1] = 6.3;
        numeros[2] = 9.3;

        char[] caracteres = "Olá, Mundo".toCharArray();
        System.out.println(caracteres[0]);
        
        // VARIÁVEIS & CONSTANTES
        int idade = 20;
        int idade2;
        idade2 = 22;

        // JAVA 10 - INFERÊNCIA DE TIPO
        var idade3 = 10;
        var nome = "João";
        var letras = "João".toCharArray();

        // CONSTANTE
        final double TESTE = 10.2;
        final var SOBRENOME = "Santos";

        // ENTRADA E SAÍDA DE DADOS
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com o seu nome:");
        String nome_digitado = sc.nextLine();

        System.out.println("Entre com a sua idade:");
        int idade_digitado = sc.nextInt();

        System.out.println(nome_digitado + " " + idade_digitado);

        sc.close();

    }

}
