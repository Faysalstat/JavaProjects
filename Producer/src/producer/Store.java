/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer;

/**
 *
 * @author Faysal
 */
public class Store {
    
    
    public static void main(String[] args) {
       ProducerConsumer pro = ProducerConsumer.getIntanceof();
       
       
       new Thread(){
            public void run(){
                pro.entry();

            }
            
        }.start();
        
       
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }
       new Thread(){
            public void run(){
                pro.out();

            }
            
        }.start();
       
       
    }
    
}
