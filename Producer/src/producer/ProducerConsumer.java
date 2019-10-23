/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faysal
 */
public class ProducerConsumer {

    public static ProducerConsumer procon = null;

    public static ProducerConsumer getIntanceof() {
        if (procon == null) {
            procon = new ProducerConsumer();
        }
        return procon;
    }

    public int i = 0;
    public int e = 0;

    Scanner input = new Scanner(System.in);
    Queue<Integer> queue = new PriorityQueue();

    public void entry() {
        while (true) {
            System.out.println("Entry the quantity..");
            int entry = input.nextInt();
            input.nextLine();

            synchronized (this) {
                if (i == 10) {
                    System.out.println("List full... addition pending");
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                    }
                }
                queue.add(entry);
                i++;
                try {
                    notify();
                } catch (Exception e) {
                }
                System.out.println(i + "th item entered");
            }
        }
    }

    public synchronized void out() {
        while (true) {
            System.out.println("product out");
            if (i == 0) {
                System.out.println("List empty... subtruction pending");
                try {
                    wait();
                } catch (InterruptedException ex) {
                }
            }
            queue.peek();
            try {
                notify();
            } catch (Exception e) {
            }
            System.out.println(i + "th item out");
            i--;

        }
    }

}
