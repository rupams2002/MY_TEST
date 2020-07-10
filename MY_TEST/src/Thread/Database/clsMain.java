package Thread.Database;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class clsMain {

  public static void main(String args[]) throws Exception {

        //TimeUnit.SECONDS.sleep(5);
      
        //Stablishing connection by doing ExecutorService
        ExecutorService service = Executors.newFixedThreadPool(3);

        System.out.println("Starting DB Connection 1");
        service.submit(new clsThread("Update-1", "intCounter1", 0));
        
        System.out.println("Starting DB Connection 2");
        service.submit(new clsThread("Update-2", "intCounter1", 0));

        System.out.println("Starting DB Connection 3");
        service.submit(new clsThread("Update-3", "intCounter1", 0));
        
        service.shutdown();


  }    
}
