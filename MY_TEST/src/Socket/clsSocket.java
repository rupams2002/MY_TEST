package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class clsSocket {
    
    public static void main(String[] args) throws IOException {
        String hostName = "www.google.com";
        int portNumber = 80;
        
        Socket echoSocket = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader( new InputStreamReader(echoSocket.getInputStream()));
        BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in));
    }
    
}
