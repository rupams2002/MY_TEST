package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class clsArrayList {
    
    public void getMapMinMaxArrayList1(){
       ArrayList listMinMax = new ArrayList();
       
       listMinMax.add(122);
       listMinMax.add(102);
       listMinMax.add(22);
       listMinMax.add(202);
       listMinMax.add(1);
       listMinMax.add(100);

       String min = Collections.min(listMinMax).toString();
       String max = Collections.max(listMinMax).toString();
       
    }
    
    public void getMapMinMaxArrayList2(){
       ArrayList<Integer> listMinMax = new ArrayList<Integer>();
       
       listMinMax.add(122);
       listMinMax.add(102);
       listMinMax.add(22);
       listMinMax.add(202);
       listMinMax.add(1);
       listMinMax.add(100);
       
       String min = Collections.min(listMinMax).toString();
       String max = Collections.max(listMinMax).toString();
    }
    
    public static void main(String[] args){
        clsArrayList aList = new clsArrayList();
        aList.getMapMinMaxArrayList1();
        aList.getMapMinMaxArrayList2();
    }    
    
    
}
