package aula_04.exemplos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import aula_03.exemplos.Quadrado;

public class QuadradoTest {
    
    @Test
    public void criaUmQuadradoComLado10() {
        // AAA
        // Arrange
        double lado = 10.0;

        // Act
        Quadrado quadrado = new Quadrado(lado);

        // Assert
        assertEquals(lado, quadrado.getLado());
    }

    @Test
    public void quadradoComLado10DeveTerArea100() {
        // Arrange
        Quadrado quadrado = new Quadrado(10);

        // Act
        double area = quadrado.calcularArea();

        // Assert
        assertEquals(quadrado.calcularArea(), area);

    }

    @Test
    public void oQuadradoComLado10DeveTerAreaPerimetro40() {
        double perimetroEsperado = 40;
        Quadrado quadrado = new Quadrado(10);

        double perimetro = quadrado.calcularPerimetro();

        assertEquals(perimetroEsperado, perimetro);
    }

    @Test
    public void deveAlterarOValorDoLado() {
        Quadrado quadrado = new Quadrado(10);

        quadrado.setLado(5);

        assertEquals(5, quadrado.getLado());
    }

    // VALORES ESPERADOS (Expected Values)
    // VALORES LIMITES (Boundary Values)
    // VALORES ESTRANHOS (Strange Values)

    @Test
    public void deveLancarUmaExceptionQuandoOValorDeLadoForZero() {
        assertThrowsExactly(IllegalArgumentException.class, () -> {
                new Quadrado(0);
        });
    }

    @Test
    public void deveLancarUmaExceptionQuandoOValorDeLadoForNegativo() {
        assertThrowsExactly(IllegalArgumentException.class, () -> {
                new Quadrado(-10);
        });
    }

    @Test
    public void deveLancarUmaExceptionQuandoOValorDeLadoForZeroComAMsgCorreta() {
        IllegalArgumentException exception =  assertThrowsExactly(
            IllegalArgumentException.class, () -> {
                new Quadrado(0);
            });

        assertEquals("Lado deve ser maior que zero", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = {1, 1.0, 3.0, 5.5, 100.0})
    public void testaVariosValoresParaoLado(double lado) {
        Quadrado quadrado = new Quadrado(lado);

        assertEquals(lado, quadrado.getLado());
    }

}
