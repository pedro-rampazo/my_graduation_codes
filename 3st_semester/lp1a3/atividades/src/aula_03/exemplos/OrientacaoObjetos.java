package aula_03.exemplos;

public class OrientacaoObjetos {
    
    // Orientação a Objetos
    // Analise -> Projeto -> Implementação -> Testes -> Implantação

    // Classe
    // Estrutura que abstrai um conceito que precisa ser representado no software

    // Objeto
    // Instância de uma classe
    // A partir de uma classe posso criar n objetos

    // Classe = Atributos + Métodos
    // Atributos definem estado de um Objeto
    // Métodos definem comportamento de um Objeto

    // Crie um programa que calcula a área e perímetro de dois quadrado

    public static void main(String[] args) {
        
        double lado1 = 10;
        double lado2 = 5;

        double area1 = calcularArea(lado1);
        double area2 = calcularArea(lado2);

        double perimetro1 =  calcularPerimetro(lado1);
        double perimetro2 = calcularPerimetro(lado2);

        System.out.println(area1);
        System.out.println(perimetro1);
        System.out.println(area2);
        System.out.println(perimetro2);

        Quadrado q1 = new Quadrado(10);
        // q1.lado = 10;

        Quadrado q2 = new Quadrado(5);
        // q2.lado = 5;

        System.out.println(q1.getLado());

        System.out.println(q1.calcularArea());
        System.out.println(q1.calcularPerimetro());
        System.out.println(q2.calcularArea());
        System.out.println(q2.calcularPerimetro());

        Retangulo r1 = new Retangulo(10, 5);
        // r1.base = 10;
        // r1.altura = 5;

        System.out.println(r1.calcularArea());
        System.out.println(r1.calcularPerimetro());


        // Relacionamento entre classes
        // Dependência, associação (agregação e composição)

        // Dependência -> Classe recebe no parâmetro de um método outra classe
        // ou quando acessa um objeto estático de outra classe

        // Associação (Agregação)
        // Todo-Parte - Diário - Professor - Parte existe sem um todo

        // Associação (Composição)
        // Todo-Parte - Diário - Aulas - Parte não existe sem um todo
        // Ciclo de vida está atrelado

        // Endereco e1 = new Endereco("00202020", 16, "Casa 2");
        // Cliente c1 = new Cliente(1, "Maria", "maria@email.com", e1);
        Cliente c1 = new Cliente(1, "Maria", "maria@email.com", "02020202", 16, "Casa 2");

    }

    public static double calcularArea(double lado) {
        return lado * lado;
    }

    public static double calcularPerimetro(double lado) {
        return 4 * lado;
    }

}