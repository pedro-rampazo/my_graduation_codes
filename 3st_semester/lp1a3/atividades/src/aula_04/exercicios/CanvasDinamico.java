package aula_04.exercicios;

import aula_03.exemplos.Quadrado;
import aula_03.exemplos.Retangulo;

public class CanvasDinamico {
    private Quadrado[] quadrados;
    private Retangulo[] retangulos;
    private int quantidadeQuadrados;
    private int quantidadeRetangulos;

    public CanvasDinamico(int capacidadeQuadrados, int capacidadeRetangulos) {
        quadrados = new Quadrado[capacidadeQuadrados];
        retangulos = new Retangulo[capacidadeRetangulos];
        quantidadeQuadrados = 0;
        quantidadeRetangulos = 0;
    }

    public void adicionarQuadrado(Quadrado novoQuadrado) {
        if (quantidadeQuadrados < quadrados.length) {
            quadrados[quantidadeQuadrados] = novoQuadrado;
        } else {
            quadrados = adicionarQuadradoDinamico(quantidadeQuadrados, quadrados, novoQuadrado);
        }
        quantidadeQuadrados++;
    }

    public void adicionarRetangulo(Retangulo novoRetangulo) {
        if (quantidadeRetangulos < retangulos.length) {
            retangulos[quantidadeRetangulos] = novoRetangulo;
        } else {
            retangulos = adicionarRetanguloDinamico(quantidadeRetangulos, retangulos, novoRetangulo);
        }
        quantidadeRetangulos++;
    }

    private static Quadrado[] adicionarQuadradoDinamico(int tamanhoArray, Quadrado[] arrayQuadrado, Quadrado novoQuadrado) {
        Quadrado[] novoArrayQuadrado = new Quadrado[tamanhoArray + 1];
        for (int i = 0; i < arrayQuadrado.length; i++) {
            novoArrayQuadrado[i] = arrayQuadrado[i];
        }
        novoArrayQuadrado[tamanhoArray] = novoQuadrado;
        return novoArrayQuadrado;
    }

    private static Retangulo[] adicionarRetanguloDinamico(int tamanhoArray, Retangulo[] arrayRetangulo, Retangulo novoRetangulo) {
        Retangulo[] novoArrayRetangulo = new Retangulo[tamanhoArray + 1];
        for (int i = 0; i < arrayRetangulo.length; i++) {
            novoArrayRetangulo[i] = arrayRetangulo[i];
        }
        novoArrayRetangulo[tamanhoArray] = novoRetangulo;
        return novoArrayRetangulo;
    }

    public int getCapacidadeQuadrados() {
        return quadrados.length;
    }

    public int getCapacidadeRetangulos() {
        return retangulos.length;
    }

    public int getQuantidadeQuadrados() {
        return quantidadeQuadrados;
    }

    public int getQuantidadeRetangulos() {
        return quantidadeRetangulos;
    }

    public double getSomaAreaQuadrados() {
        double soma = 0.0;
        for (int i = 0; i < quantidadeQuadrados; i++) {
            soma += quadrados[i].calcularArea();
        }
        return soma;
    }

    public double getSomaAreaRetangulos() {
        double soma = 0.0;
        for (int i = 0; i < quantidadeRetangulos; i++) {
            soma += retangulos[i].calcularArea();
        }
        return soma;
    }

    public double getSomaPerimetroQuadrados() {
        double soma = 0.0;
        for (int i = 0; i < quantidadeQuadrados; i++) {
            soma += quadrados[i].calcularPerimetro();
        }
        return soma;
    }

    public double getSomaPerimetroRetangulos() {
        double soma = 0.0;
        for (int i = 0; i < quantidadeRetangulos; i++) {
            soma += retangulos[i].calcularPerimetro();
        }
        return soma;
    }

}
