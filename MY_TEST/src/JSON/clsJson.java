package JSON;

import Map.clsMap;
import com.google.gson.JsonArray;
import java.util.Iterator;
import org.json.JSONObject;

public class clsJson {
/*
    {
        "errorText":"Poll response not found for host=16 and account=240561",
        "errorCode":-1,
        "gpsPollId":6453
    }
*/  
    
    public static void main(String[] args){
        
        String strJson = "{ \"errorText\":\"Poll response not found for host=16 and account=240561\", \"errorCode\":-1, \"gpsPollId\":6453 }";
        System.out.println(strJson);

        JSONObject json = new JSONObject(strJson);
        
        Iterator<String> keys = json.keys();        
        while(keys.hasNext()) {
            String key = keys.next();
            
            if (key.equals("errorText")) {
                System.out.println(json.get("errorText"));
            }    
            if (key.equals("errorCode")) {
                System.out.println(json.get("errorCode"));
            }    
            if (key.equals("gpsPollId")) {
                System.out.println(json.get("gpsPollId"));
            }    
        }      
                
//        clsJson oJson = new clsJson();
//        JsonArray jArray = oJson.CreateJsonArray(json);
        
    }    
    
}
