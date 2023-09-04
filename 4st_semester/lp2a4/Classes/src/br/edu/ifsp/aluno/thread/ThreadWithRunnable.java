package br.edu.ifsp.aluno.thread;

public class ThreadWithRunnable {

    public static void main(String[] args) {
        Thread r1 = new Thread(new MyRunnable("runnable1", 100));
        r1.start();
        Thread r2 = new Thread(new MyRunnable("          runnable2", 100));
        r2.start();
        System.out.println("Encerrando o metodo main().");
    }
}
