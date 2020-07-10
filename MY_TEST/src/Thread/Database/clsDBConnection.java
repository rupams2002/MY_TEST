package Thread.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class clsDBConnection {
    private final String DATABASE_DRIVER;
    private final String DATABASE_URL;
    private final String DB_USERNAME;
    private final String DB_PASSWORD;
    private final String MAX_POOL;
    
    // init connection object
    private Connection dbConnection;
    // init properties object
    private Properties properties;

    public clsDBConnection(){
        Properties prop           = clsPropertyReader.getProperties();
        String strDatabase_Driver = prop.getProperty("DATABASE_DRIVER", "");
        String strDatabaseURL     = prop.getProperty("DATABASE_URL", "");
        String strDBUserName      = prop.getProperty("DB_USERNAME", "");
        String strDBPassword      = prop.getProperty("DB_PASSWORD", "");
        String strMaxPoolSize     = prop.getProperty("MAX_POOL", "");

        this.DATABASE_DRIVER      = strDatabase_Driver;
        this.DATABASE_URL         = strDatabaseURL;
        this.DB_USERNAME          = strDBUserName;
        this.DB_PASSWORD          = strDBPassword;
        this.MAX_POOL             = strMaxPoolSize;
    }
    
    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", this.DB_USERNAME);
            properties.setProperty("password", this.DB_PASSWORD);
            properties.setProperty("MaxPooledStatements", this.MAX_POOL);
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");
        }
        return properties;
    }

    //*****************************
    // Create Database Connection
    //*****************************
    public Connection MySQLConnection(){
            if (dbConnection == null) {
                try {
                        /*
                            SQL :  To check how many connections are openned from MySQL Query
                            show status like '%onn%';
                            Variable_name : 'Threads_connected'
                        */    
                        synchronized(this){                        
                            Class.forName(this.DATABASE_DRIVER);
                            dbConnection = DriverManager.getConnection(this.DATABASE_URL, getProperties());
                        }
                } catch (SQLException e) {
                    System.out.println("SQL Exception : " + e.getMessage());
                } catch (ClassNotFoundException ex) {
                    System.out.println("ClassNotFound Exception : " + ex.getMessage());
                }
            }
        
        return dbConnection;
    }

    //*****************************
    // Disconnect Database
    //*****************************
    public void disconnect() {
        if (this.dbConnection != null) {
            try {
                this.dbConnection.close();
                this.dbConnection = null;
            } catch (SQLException e) {
                System.out.println("SQL Exception : " + e.getMessage());
            }
        }
    }    

}
