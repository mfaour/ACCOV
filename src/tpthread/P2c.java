/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpthread;

/**
 *
 * @author mfaour
 */
public class P2c extends Thread {

    private int tick = 0;

    public void run() {
        while (tick < 40000000) {
            tick++; // tick est un entier initialisé à 0 
            // tick représente le nombre de millisecondes écoulées depuis 
            // le début de l'exécution du CoureurEgoiste 
            if ((tick % 5000) == 0) {
                // System.out.println("Thread #" + Thread.currentThread().getName()+
                //   " tick = " + tick); 
            }
        }

       System.out.println("Nom du thread: " + Thread.currentThread().getName()
                + ", Group: " + Thread.currentThread().getThreadGroup()
                + ", Priorite': " + Thread.currentThread().getPriority()
                + ", Isdémon : " + Thread.currentThread().isDaemon());
    }

    public static void main(String args[]) {
        P2c thr1 = new P2c();
        P2c thr2 = new P2c();
        P2c thr3 = new P2c();

        thr1.setName("T1");
        thr2.setName("T2");
        thr3.setName("T3");
        //thr1.setDaemon(true);
        thr2.setPriority(Thread.MAX_PRIORITY);
        thr3.setPriority(Thread.MIN_PRIORITY);

        thr1.start();
        thr2.start();
        thr3.start();
        System.out.println("Numbre des threads: " + java.lang.Thread.activeCount());
        try {
            thr1.join();
            thr2.join();
            thr3.join();
            System.out.println("Fin de P2c");
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
/*
    - Numbre des threads: 4
        Nom du thread: T1, Group: java.lang.ThreadGroup[name=main,maxpri=10], Priorite': 5, Isdémon : false
        Nom du thread: T2, Group: java.lang.ThreadGroup[name=main,maxpri=10], Priorite': 10, Isdémon : false
        Nom du thread: T3, Group: java.lang.ThreadGroup[name=main,maxpri=10], Priorite': 1, Isdémon : false

*/