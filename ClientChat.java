package SocketDemo;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientChat {

	public static void main(String[] args) throws Exception {
		Socket s3= new Socket("localhost",5555);
		Scanner sc = new Scanner(System.in);
		
		OutputStreamWriter os = new OutputStreamWriter(s3.getOutputStream());
		PrintWriter out = new PrintWriter(os);
		BufferedReader br = new BufferedReader(new InputStreamReader(s3.getInputStream()));
		String msg;
		String str = "";
	   do {
		   msg=sc.next();
		   out.println(msg);
		   out.flush();
		 
		   str=br.readLine();
		   System.out.println("Server message: "+str);
	   }
	   while(!msg.equals("end")) ;
	   sc.close();
		s3.close();
	   
	}

}
