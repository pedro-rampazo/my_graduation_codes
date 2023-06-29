package aula_04.exercicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

public class CirculoTest {
    
    @Test
    public void criaUmCirculoDeRaio6() {
        double raio = 6;
        Circulo circulo = new Circulo(6);
        assertEquals(raio, circulo.getRaio());
    }

    @Test
    public void circuloDeRaio6DeveTerDiametroDe12() {
        double diametroEsperada = 12.0;
        Circulo circulo = new Circulo(6);
        assertEquals(diametroEsperada, circulo.calcularDiametro());
    }

    @Test
    public void circuloDeRaio6DeveTerPerimetro37() {
        double perimetroEsperado = 37.68;
        Circulo circulo = new Circulo(6);
        assertEquals(perimetroEsperado, circulo.calcularPerimetro());
    }

    @Test
    public void circuloDeRaio6DeveTerArea113() {
        double areaEsperada = 113.04;
        Circulo circulo = new Circulo(6);
        assertEquals(areaEsperada, circulo.calcularArea());
    }

    @Test
    public void deveAlterarOValorDoRaio() {
        Circulo circulo = new Circulo(6);
        circulo.setRaio(15);
        assertEquals(15, circulo.getRaio());
    }

    @Test
    public void deveLancarUmaExceptionQuandoOValorDoRaioForZero() {
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Circulo(0);
        });
    }

    @Test
    public void deveLancarUmaExceptionQuandoOValorDoRaioForNegativo() {
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Circulo(-6);
        });
    }

}
