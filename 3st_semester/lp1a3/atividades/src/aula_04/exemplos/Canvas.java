package aula_04.exemplos;

import aula_03.exemplos.Quadrado;
import aula_03.exemplos.Retangulo;

public class Canvas {
    private Quadrado[] quadrados = new Quadrado[10];
    private Retangulo[] retangulos;
    private int quantidadeQuadrados;
    private int quantidadeRetangulos;

    public Canvas(int capacidadeQuadrados, int capacidadeRetangulos) {
        quadrados = new Quadrado[capacidadeQuadrados];
        retangulos = new Retangulo[capacidadeRetangulos];
        quantidadeQuadrados = 0;
        quantidadeRetangulos = 0;
    }

    public void adicionarQuadrado(Quadrado quadrado) {
        if (quantidadeQuadrados == quadrados.length) {
            throw new RuntimeException("array de quadrados esta cheio");
        }
        quadrados[quantidadeQuadrados] = quadrado;
        quantidadeQuadrados++;
    }

    public void adicionarRetangulo(Retangulo retangulo) {
        if (quantidadeRetangulos == retangulos.length) {
            throw new RuntimeException("array de retangulos esta cheio");
        }
        retangulos[quantidadeRetangulos] = retangulo;
        quantidadeRetangulos++;
    }

    public int getQuantidadeQuadrados() {
        return quantidadeQuadrados;
    }

    public int getQuantidadeRerangulos() {
        return quantidadeRetangulos;
    }

    public int getCapacidadeQuadrados() {
        return quadrados.length;
    }

    public int getCapacidadeRetangulos() {
        return retangulos.length;
    }

    public double getSomaAreaQuadrados() {
        double soma = 0.0;
        for (int i = 0; i < quantidadeQuadrados; i++) {
            soma = soma + quadrados[i].calcularArea();
        }
        return soma;
    }

    public double getSomaAreaRetangulos() {
        double soma = 0.0;
        for (int i = 0; i < quantidadeRetangulos; i++) {
            soma = soma + retangulos[i].calcularArea();
        }
        return soma;
    }

    public double getSomaPerimetroQuadrados() {
        double soma = 0.0;
        for (int i = 0; i < quantidadeQuadrados; i++) {
            soma = soma + quadrados[i].calcularPerimetro();
        }
        return soma;
    }

    public double getSomaPerimetroRetangulos() {
        double soma = 0.0;
        for (int i = 0; i < quantidadeRetangulos; i++) {
            soma = soma + retangulos[i].calcularPerimetro();
        }
        return soma;
    }

}
