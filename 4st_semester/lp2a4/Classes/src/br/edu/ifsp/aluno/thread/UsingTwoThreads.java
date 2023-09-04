package br.edu.ifsp.aluno.thread;

public class UsingTwoThreads {

    public static void main(String[] args) {
        Thread t1 = new MyThread("thread1", 100);
        t1.start();
        Thread t2 = new MyThread("         thread2", 100);
        t2.start();
        System.out.println("Encerrando o metodo main().");
    }

}
