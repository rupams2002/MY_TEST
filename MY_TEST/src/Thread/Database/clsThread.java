package Thread.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class clsThread implements Runnable{
    private String strThreadName;
    private String strFieldName;
    private int intSleepTime;
    
    public clsThread(){
    }
    
    public clsThread(String strThreadName, String strFieldName, int intSleepTime){
        this.strThreadName = strThreadName;
        this.strFieldName = strFieldName;
        this.intSleepTime = intSleepTime;
    }

    @Override
    public void run() {
        //synchronized(this)
        {
            Statement stm       = null;
            ResultSet rs        = null;
            String strSQL       = "";
        
            try {
                TimeUnit.MILLISECONDS.sleep(this.intSleepTime);

                Thread.currentThread().setName(this.strThreadName);
                System.out.println("Current Thread :" + Thread.currentThread().getName());
                Connection conn = null;    

                for(int cc=0; cc<20; cc++){
                    clsDBConnection mysqlConnect = new clsDBConnection();
                    conn = mysqlConnect.MySQLConnection();
                }    

                if (conn != null){
                    int intCounter = 0;
                    for(int i=0; i<10; i++){
                        //intCounter++;
                        stm = conn.createStatement();
                        strSQL = "SELECT " + this.strFieldName +  " FROM tblconcurrencytest";
                        rs = stm.executeQuery(strSQL);
                        
                        if(rs.next()){
                            intCounter = rs.getInt(this.strFieldName);
                            intCounter++;
                          
                            strSQL = "UPDATE tblconcurrencytest SET " + this.strFieldName +  " = " + intCounter;
                            System.out.println("i = " + i + " " + Thread.currentThread().getName() + " : " + strSQL);
                            stm.execute(strSQL);                          
                        }
                        
                    }

                    //TimeUnit.SECONDS.sleep(5);
                    conn.close();
                }else{
                    System.out.println("Could not update this thread :" + Thread.currentThread().getName());
                }
                
            } catch (SQLException ex) {
                System.out.println("SQL Exception : " + ex.getMessage());
            } catch (InterruptedException ex) {
                System.out.println("Interrupted Exception : " + ex.getMessage());
            } finally{
                try {
                    if(stm != null){
                        stm.close();
                    }
                    if(rs != null){
                        rs.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("SQL Exception during CLOSE : " + ex.getMessage());
                }
            }
        }
    } 
}
