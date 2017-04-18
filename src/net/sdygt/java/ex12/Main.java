package net.sdygt.java.ex12;

public class Main {
    public static void main(String[] args) {
        new MyThread("Melchiorl");
        new MyThread("Balthasar");
        new MyThread("Casper");
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            System.out.println("Master Interrupted");
        }
        System.out.println("Master exiting");
    }
}
