package br.edu.ifsp.aluno.thread;

public class MyRunnable implements Runnable {
    String name;
    int times;

    public MyRunnable(String n, int k) {
        this.name = n;
        this.times = k;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println("i:"+i+"===========> SimpleThread:"+name);
        }
        System.out.println("------------> Encerrando "+name+".");
    }
}
