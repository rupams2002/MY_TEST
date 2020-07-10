package Map;

import ArrayList.clsArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class clsMap {

    public void getMinMaxValueWithKeyMAP1(){
       Map<Integer, String> map = new HashMap<Integer, String>();

       map.put(1, "2017-01-01");
       map.put(589, "2017-02-02");
       map.put(22, "2017-03-03");
       map.put(102, "2017-04-04");
       map.put(1, "2017-05-05");
       map.put(589, "2017-06-06");
       map.put(100, "2017-07-07");

       int minValueInMap=(Collections.min(map.keySet()));
       String minDate = Collections.min(map.entrySet(), Map.Entry.comparingByKey()).getValue() ;
       int maxValueInMap=(Collections.max(map.keySet()));
       String maxDate = Collections.max(map.entrySet(), Map.Entry.comparingByKey()).getValue() ;
    }
    
    public void getMinMaxValueWithKeyMAP2(){
       Map<Double, String> map = new HashMap<Double, String>();

       map.put(1.0, "2017-01-01");
       map.put(589.06, "2017-02-02");
       map.put(22.50, "2017-03-03");
       map.put(102.50, "2017-04-04");
       map.put(1.20, "2017-05-05");
       map.put(589.10, "2017-06-06");
       map.put(100.99, "2017-07-07");

       double minValueInMap=(Collections.min(map.keySet()));
       String minDate = Collections.min(map.entrySet(), Map.Entry.comparingByKey()).getValue() ;
       double maxValueInMap=(Collections.max(map.keySet()));
       String maxDate = Collections.max(map.entrySet(), Map.Entry.comparingByKey()).getValue() ;
    }
    
    public static void main(String[] args){
        clsMap map = new clsMap();
        map.getMinMaxValueWithKeyMAP1();
        map.getMinMaxValueWithKeyMAP2();
    }    

}
