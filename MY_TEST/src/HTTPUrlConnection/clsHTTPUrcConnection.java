package HTTPUrlConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;



public class clsHTTPUrcConnection {
    final private String strURL;
    final private String strKey;
    
    public clsHTTPUrcConnection(){
	this.strURL = "http://api.open-notify.org/iss-now.json";
        this.strKey = "";        
    }
    
    public JSONObject getJSONObject() throws IOException {
        StringBuilder strBuilder = new StringBuilder();

        JSONObject json = null;
        
        try {
		URL url = new URL(this.strURL);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		//conn.setRequestProperty("Authorization", "Basic " + this.strKey);

		if (conn.getResponseCode() != 200) {
		    throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String strLine;
		//System.out.println("Output from Server .... \n");
		while ((strLine = reader.readLine()) != null) {
                    strBuilder.append(strLine);
		}
                conn.disconnect();
                                
                json = new JSONObject(strBuilder.toString());                
                
	}catch (MalformedURLException e) {
	}         
        return json;
    }

    public Map getISSLocation(JSONObject jsonObject) throws IOException {
        Map<String, Float> map = new HashMap<>();

        Iterator<String> keys = jsonObject.keys();

        while(keys.hasNext()) {
            String key = keys.next();
            if (jsonObject.get(key) instanceof JSONObject) {
                JSONObject jsonObject2 = new JSONObject(jsonObject.get(key).toString());
                Iterator<String> innerkeys = jsonObject2.keys();

                while(innerkeys.hasNext()){
                    String key2 = innerkeys.next();
//                    System.out.println(key2);
//                    System.out.println(jsonObject2.get(key2));
                    map.put(key2, (float) jsonObject2.getFloat(key2));
                }                
            }else{
//                System.out.println(key);
//                System.out.println(jsonObject.get(key));
            }
        }                
        
        return map;
    }


    
    public static void main(String[] args) throws IOException {
        clsHTTPUrcConnection httpConn = new clsHTTPUrcConnection();

        JSONObject json = httpConn.getJSONObject();
        Map<String, Float> map = httpConn.getISSLocation(json);

        System.out.println(map.get("latitude"));
        System.out.println(map.get("longitude"));
    }    
    

}
