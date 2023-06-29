package aula_02.exercicios;

import java.util.Scanner;

public class Ex_03 {
    public static void main(String[] args) {
        double valor_compra;

        Scanner sc = new Scanner(System.in);

        System.out.println("Valor da Compra: ");
        valor_compra = sc.nextDouble();

        if (valor_compra >= 0.01 && valor_compra <= 9.99) {
            System.out.println("0% de Desconto: " + valor_compra);
        } else if (valor_compra >= 10 && valor_compra <= 99.99) {
            System.out.println("5% de Desconto: " + valor_compra*0.95);
        } else if (valor_compra >= 100 && valor_compra <= 499.99) {
            System.out.println("10% de Desconto: " + valor_compra*0.90);
        } else if (valor_compra >= 500) {
            System.out.println("15% de Desconto: " + valor_compra*0.85);
        } else {
            System.out.println("Valor Inválido");
        }

    }
}
