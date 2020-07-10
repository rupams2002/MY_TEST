package Thread;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clsReceiver implements Runnable{
    private boolean done = false;
    private int intVal;
    
    public clsReceiver(){
    }

    @Override
    public void run() {
        try {  
            TimeUnit.SECONDS.sleep(6);
            this.intVal = 20;
            this.done = true;
 
            synchronized(this){
                this.notifyAll();
            }
            
//        for(int i=0; i<10; i++){
//           System.out.println(Thread.currentThread().getName() + "  " + i);
//        } 
        } catch (InterruptedException ex) {
            Logger.getLogger(clsSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getValue(){
        if(!this.done){
            synchronized(this){
                try {
                    System.out.println("WAITING for result on [" + Thread.currentThread().getName() + "]");
                    this.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(clsSender.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return this.intVal;
    }
    
}
