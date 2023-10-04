package it.fi.meucci;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.*;

public class ServerObj {
    Socket client;
    ServerSocket server;
    DataOutputStream outClient;
    BufferedReader inClient;

    public ServerObj(){
        client = null;
        server = null;
        outClient = null;
        inClient = null;
    }

    public ServerObj(ServerSocket server){
        client = null;
        this.server = server;
        outClient = null;
        inClient = null;
    }



    public void serverBind() throws IOException{
        System.out.println( " Server in attesa di un client " );
            
        client = server.accept();
        outClient = new DataOutputStream(client.getOutputStream());
        inClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println("Il client "+client.getLocalAddress()+" si è collegato");

    }

    public void startComm() throws IOException{
        
        String inputString;

        for(;;){
            inputString = inClient.readLine();
            System.out.println("[CLIENT] "+inputString);
            if(inputString.equals("BYE")){
                break;
            }else{
                outClient.writeBytes("Ricevuto, ritrasmetto la stringa.. "+inputString.toUpperCase()+"\n");
            }
                
        }
        outClient.writeBytes("Termine della connessione "+"\n");
        System.out.println("Termine connessione con "+client.getLocalAddress());
        client.close();
    }

    public void serverClose() throws IOException{
        server.close();
        client.close();
    }
}
