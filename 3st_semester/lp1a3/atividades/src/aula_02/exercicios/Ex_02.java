package aula_02.exercicios;

import java.util.Scanner;

public class Ex_02 {
    public static void main(String[] args) {
        double num, media = 0;
        int QUANTIDADE_VALORES = 3;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < QUANTIDADE_VALORES; i++) {
            System.out.println("Digite um valor:");
            num = sc.nextDouble();
            media += num;
        }

        System.out.println("Média: " + media/QUANTIDADE_VALORES);

    }
}
