package aula_04.exercicios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import aula_03.exemplos.Quadrado;
import aula_03.exemplos.Retangulo;

public class CanvasDinamicoTest {
    
    @Test
    public void criaUmCanvasDe6QuadradosE8Retangulos() {
        int quadradosEsperados = 6;
        int retangulosEsperados = 8;
        CanvasDinamico canvasDinamico = new CanvasDinamico(6, 8);
        assertEquals(quadradosEsperados, canvasDinamico.getCapacidadeQuadrados());
        assertEquals(retangulosEsperados, canvasDinamico.getCapacidadeRetangulos());
    }

    @Test
    public void deveInserirUmQuadradoSeAQuantidadeForMenorQueACapacidade6() {
        int quantidadeQuadradosEsperada = 1;
        CanvasDinamico canvasDinamico = new CanvasDinamico(6, 8);
        canvasDinamico.adicionarQuadrado(new Quadrado(12));
        assertEquals(quantidadeQuadradosEsperada, canvasDinamico.getQuantidadeQuadrados());
    }

    @Test
    public void deveInserirUmQuadradoDinamicamenteSeAQuantidadeForMaiorOuIgualACapacidade6() {
        int quantidadeQuadradosEsperada = 7;
        CanvasDinamico canvasDinamico = new CanvasDinamico(6, 8);
        for (int i = 0; i < 7; i++) {
            canvasDinamico.adicionarQuadrado(new Quadrado(12));
        }
        assertEquals(quantidadeQuadradosEsperada, canvasDinamico.getQuantidadeQuadrados());
    }

    @Test
    public void deveInserirUmRetanguloSeAQuantidadeForMenorQueACapacidade8() {
        int quantidadeRetangulosEsperada = 1;
        CanvasDinamico canvasDinamico = new CanvasDinamico(6, 8);
        canvasDinamico.adicionarRetangulo(new Retangulo(15, 20));
        assertEquals(quantidadeRetangulosEsperada, canvasDinamico.getQuantidadeRetangulos());
    }

    @Test
    public void deveInserirUmRetanguloDinamicamenteSeAQuantidadeForMaiorOuIgualACapacidade8() {
        int quantidadeRetangulosEsperada = 9;
        CanvasDinamico canvasDinamico = new CanvasDinamico(6, 8);
        for (int i = 0; i < 9; i++) {
            canvasDinamico.adicionarRetangulo(new Retangulo(15, 20));;
        }
        assertEquals(quantidadeRetangulosEsperada, canvasDinamico.getQuantidadeRetangulos());
    }

    @Test
    public void quadradosDeArea36ComQuantidade12DevemTer432DeSoma() {
        int somaAreaQuadrados = 432;
        CanvasDinamico canvasDinamico = new CanvasDinamico(12, 8);
        for (int i = 0; i < canvasDinamico.getCapacidadeQuadrados(); i++) {
            canvasDinamico.adicionarQuadrado(new Quadrado(6));
        }
        assertEquals(somaAreaQuadrados, canvasDinamico.getSomaAreaQuadrados());
    }

    @Test
    public void retangulosDeArea40ComQuantidade15DevemTer600DeSoma() {
        int somaAreaRetangulos = 600;
        CanvasDinamico canvasDinamico = new CanvasDinamico(12, 15);
        for (int i = 0; i < canvasDinamico.getCapacidadeRetangulos(); i++) {
            canvasDinamico.adicionarRetangulo(new Retangulo(8, 5));
        }
        assertEquals(somaAreaRetangulos, canvasDinamico.getSomaAreaRetangulos());
    }

    @Test
    public void quadradosDePerimetro24ComQuantidade12DevemTer288DeSoma() {
        int somaPerimetroQuadrados = 288;
        CanvasDinamico canvasDinamico = new CanvasDinamico(12, 8);
        for (int i = 0; i < canvasDinamico.getCapacidadeQuadrados(); i++) {
            canvasDinamico.adicionarQuadrado(new Quadrado(6));
        }
        assertEquals(somaPerimetroQuadrados, canvasDinamico.getSomaPerimetroQuadrados());
    }

    @Test
    public void retangulosDePerimetro26ComQuantidade15DevemTer390DeSoma() {
        int somaPerimetroRetangulos = 390;
        CanvasDinamico canvasDinamico = new CanvasDinamico(12, 15);
        for (int i = 0; i < canvasDinamico.getCapacidadeRetangulos(); i++) {
            canvasDinamico.adicionarRetangulo(new Retangulo(8, 5));
        }
        assertEquals(somaPerimetroRetangulos, canvasDinamico.getSomaPerimetroRetangulos());
    }

}
