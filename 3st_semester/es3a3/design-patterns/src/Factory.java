// Product (Produto)
interface Product {
    void operation();
}

// Concrete Product 1 (Produto Concreto 1)
class ConcreteProduct1 implements Product {
    public void operation() {
        System.out.println("Operação do ConcreteProduct1");
    }
}

// Concrete Product 2 (Produto Concreto 2)
class ConcreteProduct2 implements Product {
    public void operation() {
        System.out.println("Operação do ConcreteProduct2");
    }
}

// Creator (Criador)
abstract class Creator {
    public void someOperation() {
        // Código comum a todos os produtos
        Product product = createProduct();
        product.operation();
    }

    protected abstract Product createProduct();
}

// Concrete Creator 1 (Criador Concreto 1)
class ConcreteCreator1 extends Creator {
    protected Product createProduct() {
        return new ConcreteProduct1();
    }
}

// Concrete Creator 2 (Criador Concreto 2)
class ConcreteCreator2 extends Creator {
    protected Product createProduct() {
        return new ConcreteProduct2();
    }
}

// Exemplo de uso
public class Factory {
    public static void main(String[] args) {
        Creator creator1 = new ConcreteCreator1();
        creator1.someOperation(); // Cria e usa um ConcreteProduct1

        Creator creator2 = new ConcreteCreator2();
        creator2.someOperation(); // Cria e usa um ConcreteProduct2
    }
}
