package aula_03.exemplos;

public class Retangulo {
    private final double base;
    private final double altura;

    public Retangulo(double base, double altura) {
        if (base <= 0) {
            throw new IllegalArgumentException("Base deve ser maior que zero");
        }

        if (altura <= 0) {
            throw new IllegalArgumentException("Altura deve ser maior que zero");
        }

        this.base = base;
        this.altura = altura;
    }

    // Modificador de acesso + tipo de retorno + nome + parâmetros

    public double calcularArea() {
        return base * altura;
    }

    public double calcularPerimetro() {
        return (base + altura) * 2;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

}
