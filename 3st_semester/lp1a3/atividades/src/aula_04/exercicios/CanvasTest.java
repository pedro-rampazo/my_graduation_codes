package aula_04.exercicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

import aula_03.exemplos.Quadrado;
import aula_03.exemplos.Retangulo;
import aula_04.exemplos.Canvas;

public class CanvasTest {
    
    @Test
    public void criarUmCanvasDe6QuadradosE8Retangulos() {
        int quadradosEsperados = 6;
        int retangulosEsperados = 8;
        Canvas canvas = new Canvas(6, 8);
        assertEquals(quadradosEsperados, canvas.getCapacidadeQuadrados());
        assertEquals(retangulosEsperados, canvas.getCapacidadeRetangulos());
    }

    @Test
    public void deveInserirUmQuadradoSeAQuantidadeForMenorQueACapacidade6() {
        int quantidadeQuadradosEsperada = 1;
        Canvas canvas = new Canvas(6, 8);
        canvas.adicionarQuadrado(new Quadrado(12));
        assertEquals(quantidadeQuadradosEsperada, canvas.getQuantidadeQuadrados());
    }

    @Test
    public void deveInserirUmRetanguloSeAQuantidadeForMenorQueACapacidade8() {
        int quantidadeRetangulosEsperada = 1;
        Canvas canvas = new Canvas(6, 8);
        canvas.adicionarRetangulo(new Retangulo(15, 20));
        assertEquals(quantidadeRetangulosEsperada, canvas.getQuantidadeRerangulos());
    }

    @Test
    public void quadradosDeArea36ComQuantidade12DevemTer432DeSoma() {
        int somaAreaQuadrados = 432;
        Canvas canvas = new Canvas(12, 8);
        for (int i = 0; i < canvas.getCapacidadeQuadrados(); i++) {
            canvas.adicionarQuadrado(new Quadrado(6));
        }
        assertEquals(somaAreaQuadrados, canvas.getSomaAreaQuadrados());
    }

    @Test
    public void retangulosDeArea40ComQuantidade15DevemTer600DeSoma() {
        int somaAreaRetangulos = 600;
        Canvas canvas = new Canvas(12, 15);
        for (int i = 0; i < canvas.getCapacidadeRetangulos(); i++) {
            canvas.adicionarRetangulo(new Retangulo(8, 5));
        }
        assertEquals(somaAreaRetangulos, canvas.getSomaAreaRetangulos());
    }

    @Test
    public void quadradoDePerimetro24ComQuantidade12DevemTer288DeSoma() {
        int somaPerimetroQuadrados = 288;
        Canvas canvas = new Canvas(12, 8);
        for (int i = 0; i < canvas.getCapacidadeQuadrados(); i++) {
            canvas.adicionarQuadrado(new Quadrado(6));
        }
        assertEquals(somaPerimetroQuadrados, canvas.getSomaPerimetroQuadrados());
    }

    @Test
    public void retangulosDePerimetro26ComQuantidade15DevemTer390DeSoma() {
        int somaPerimetroRetangulos = 390;
        Canvas canvas = new Canvas(12, 15);
        for (int i = 0; i < canvas.getCapacidadeRetangulos(); i++) {
            canvas.adicionarRetangulo(new Retangulo(8, 5));
        }
        assertEquals(somaPerimetroRetangulos, canvas.getSomaPerimetroRetangulos());
    }

    @Test
    public void deveLancarUmaExcecaoQuandoAQuantidadeDeQuadradosForIgualACapacidade() {
        Canvas canvas = new Canvas(6, 8);
        for (int i = 0; i < canvas.getCapacidadeQuadrados(); i++) {
            canvas.adicionarQuadrado(new Quadrado(12));
        }
        RuntimeException exception = assertThrowsExactly(RuntimeException.class, () -> {
            canvas.adicionarQuadrado(new Quadrado(22));
        });
        assertEquals("array de quadrados esta cheio", exception.getMessage());
    }

    @Test
    public void deveLancarUmaExcecaoQuandoAQuantidadeDeRetangulosForIgualACapacidade() {
        Canvas canvas = new Canvas(6, 8);
        for (int i = 0; i < canvas.getCapacidadeRetangulos(); i++) {
            canvas.adicionarRetangulo(new Retangulo(15, 12));
        }
        RuntimeException exception = assertThrowsExactly(RuntimeException.class, () -> {
            canvas.adicionarRetangulo(new Retangulo(25, 20));
        });
        assertEquals("array de retangulos esta cheio", exception.getMessage());
    }

}
