package SocketDemo;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServerChat {

	public static void main(String[] args) throws IOException {
	
		ServerSocket s1= new ServerSocket(5555);
		System.out.println("Server Started");
		Socket s2 = s1.accept();	
		System.out.println("Client Connected");
		Scanner sc1 = new Scanner(System.in);
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(s2.getInputStream()));
		 OutputStreamWriter os = new OutputStreamWriter(s2.getOutputStream());
			PrintWriter out = new PrintWriter(os);
		 String str = "";
		 String msg;
		do { 
		 str=br.readLine();
		 System.out.println("Client message: "+str);
	
			msg=sc1.nextLine();
			out.println(msg);
			out.flush();
		}
		while(!msg.equals("end"));
		
		sc1.close();
		 s2.close();
		
	}

}
