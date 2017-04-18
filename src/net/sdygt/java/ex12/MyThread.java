package net.sdygt.java.ex12;

class MyThread implements Runnable {
    private final String name;

    MyThread(String name) {
        this.name = name;
        Thread t = new Thread(this, name);
        System.out.println(this.name + " Starting");
        t.start();
    }

    @Override
    public void run() {
        synchronized (MyThread.class) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(this.name + " " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println(this.name + " Interrupted");
            }

            System.out.println(name + " Exiting");
        }
    }


}
