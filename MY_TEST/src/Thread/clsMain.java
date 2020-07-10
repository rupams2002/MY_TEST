package Thread;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clsMain {
    
    public static void main(String[] args) {
        clsSender sendTask = new clsSender();
        clsReceiver receiveTask = new clsReceiver();
        
        Thread t1 = new Thread(sendTask);
        Thread t2 = new Thread(receiveTask);
        
        ExecutorService execService = Executors.newCachedThreadPool();
        //CompletionService<TaskResult<String, Integer>> tasks = new ExecutorCompletionService<TaskResult<String, Integer>>(execService);
        
        
        

        System.out.println("START");
//        ExecutorService service = Executors.newFixedThreadPool(1);
//        service.execute(sendTask);
//        service.execute(receiveTask);
//        service.shutdown();       
        

        t1.start();
        t2.start();
        
        System.out.println("Value from sendTask = " + sendTask.getValue());
        System.out.println("Value from receiveTask = " + receiveTask.getValue());
        
        
        System.out.println("END");
        
    }
    
}
