package br.edu.ifsp.aluno.thread;

public class MyThread extends Thread {
    String name;
    int times;

    public MyThread(String n, int k) {
        this.name = n;
        this.times = k;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println("i:"+i+"=============> SimpleThread:"+name);
        }
        System.out.println("--------------> Encerrando "+name+".");
    }

}
