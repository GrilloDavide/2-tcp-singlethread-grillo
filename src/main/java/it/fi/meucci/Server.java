package it.fi.meucci;

import java.io.*;
import java.net.*;


public class Server 
{
    public static void main( String[] args ) throws IOException
    {
        ServerObj myServer = new ServerObj(new ServerSocket(6789));
        

        for(;;){
            myServer.serverBind();
            myServer.startComm();
        }
        //myServer.closeServer();
    }
}




