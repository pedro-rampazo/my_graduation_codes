package aula_03.exercicios;

public class Ex_01 {
    private double raio;
    private double PI = 3.14;

    public Ex_01(double raio) {
        setRaio(raio);
    }

    public double calcularDiametro() {
        return raio * 2;
    }

    public double calcularPerimetro() {
        return 2 * PI * raio;
    }

    public double calcularArea() {
        return PI * (raio * raio);
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double novo_raio) {
        if (novo_raio <= 0) {
            throw new IllegalArgumentException("O Raio deve ser maior que zero");
        }
        this.raio = novo_raio;
    }

}
