package aula_02.exercicios;

import java.util.Scanner;

public class Ex_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite um número:");
        int num = sc.nextInt();
        int antecessor = num - 1;
        int sucessor = num + 1;

        System.out.println("Antecessor: " + antecessor);
        System.out.println("Sucessor: " + sucessor);
    }
}
