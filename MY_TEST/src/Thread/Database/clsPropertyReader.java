package Thread.Database;

import java.io.FileNotFoundException; 
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class clsPropertyReader {
	
	public static final String FILE_NAME = "Settings.properties";
	
	private static final clsPropertyReader _SELF = new clsPropertyReader();
	private static Properties properties;
	
	private clsPropertyReader(){
		super();			
	}
	
	public static Properties getProperties(){
		properties = new Properties();	
		InputStream inputStream = _SELF.getClass().getClassLoader().getResourceAsStream(FILE_NAME);		
		if (inputStream == null){
			try {
			    throw new FileNotFoundException("Property file '" + FILE_NAME + "' not found in classpath");
			} catch (FileNotFoundException e) {
			    e.printStackTrace();
			}
		}
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return properties;
	}
}
