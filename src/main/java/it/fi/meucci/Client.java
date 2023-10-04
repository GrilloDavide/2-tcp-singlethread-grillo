package it.fi.meucci;


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main( String[] args ) throws IOException {
        
        Socket mioSocket = new Socket( InetAddress.getLocalHost() , 6789);
        DataOutputStream outServer = new DataOutputStream(mioSocket.getOutputStream());
        Scanner inServer = new Scanner (new InputStreamReader(mioSocket.getInputStream()));
        System.out.println( " Connessione effettuata \n" );

        Scanner inputTastiera = new Scanner(System.in);
        String outputString = " ";
        
        System.out.println("[SISTEMA] Mandare una stringa in input");
        System.out.println("[SISTEMA] Mandare 'BYE' per terminare la comunicazione \n");

        while(!outputString.equals("BYE")){
            
            System.out.print("[TU] ");outputString = inputTastiera.nextLine(); 
            outServer.writeBytes(outputString + "\n");
            System.out.println("[SERVER] "+inServer.nextLine());
        }

        mioSocket.close();
        inputTastiera.close();
    }

}