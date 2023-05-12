public class Singleton {
    private static Singleton instance;

    // Construtor privado para evitar a criação direta de instâncias
    private Singleton() {
    }

    // Método estático para obter a instância única do Singleton
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Método de exemplo
    public void doSomething() {
        System.out.println("Método doSomething() chamado no Singleton");
    }

    // Método principal
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
    }
}
