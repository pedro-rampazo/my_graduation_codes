package aula_02.exercicios;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Ex_04 {
    public static void main(String[] args) {
        int NUMERO_CARACTERES = 7;
        int NUMERO_DIGITOS = 4;

        System.out.println("Código Identificador: ");
        Scanner sc = new Scanner(System.in);     
        String cod = sc.nextLine();
        
        String br_var = cod.substring(0, 2);
        var num_var = cod.substring(2, 6);
        var x_var = cod.substring(6);

        if (verificarCaracteres(cod, NUMERO_CARACTERES) == false) {
            throw new RuntimeException("Código Inválido");
        }

        if (verificarSigla("BR", br_var) == false) {
            throw new RuntimeException("Código Inválido");
        }

        if (verificarNumeros(num_var) == false) {
            throw new RuntimeException("Código Inválido");
        }

        if (verificarSigla("X", x_var) == false) {
            throw new RuntimeException("Código Inválido");
        }

        System.out.println("Código Válido");

    }

    public static Boolean verificarCaracteres(String codigo, int numero_caracteres) {
        if (codigo.length() == numero_caracteres) {
            return true;
        }
        return false;
    }

    public static Boolean verificarSigla(String modelo, String sigla) {
        if (sigla.equals(modelo)) {
            return true;
        }
        return false;
    }

    public static Boolean verificarNumeros(String codigo_numerico) {
        if(codigo_numerico == null || codigo_numerico.equals("")) {
            return false;
        }
        for(int i = 0; i < codigo_numerico.length(); i++) {
            char c = codigo_numerico.charAt(i);
            if(c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

}
