package com.password_saver;


import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
class Cred implements Serializable{
	
	String username ;
	String domain ;
	private String password ;
	
	public Cred() {
		
	}
	
	public Cred (String username , String domain , String password) {
		
		this.username = username ;
		this.domain = domain ;
		this.password = password ;
		
	}
	
	@Override
	public String toString() {
		return "The password for " + username + " is " + password + "\n which is of " + domain + " domain" ;
	}
	
}

@SuppressWarnings("serial")
public class Cred_Store extends HttpServlet{
	
	static HashMap<String , Cred > hm = new HashMap<String, Cred>();
	
	
	public static HashMap<String , Cred> storage(String username , String domain , String password ) throws IOException {
		
		Cred data = new Cred(username , domain , password);
		
		
		
		try {
			FileInputStream fis = new FileInputStream("P:\\Servlets\\Fetcher\\src\\main\\java\\com\\password_saver\\Account_details");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Cred credobj = null ;
			
			int count = ois.readInt();
			for(int i = 0 ; i < count ; i++) {
				credobj = (Cred)ois.readObject();
				hm.put(credobj.username , credobj); 
			}
			hm.put(data.username, data);
			ois.close();
			fis.close();
			}catch(Exception e) {
			System.out.println(e);
			}
		
		
			FileOutputStream fos = new FileOutputStream("P:\\Servlets\\Fetcher\\src\\main\\java\\com\\password_saver\\Account_details");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeInt(hm.size());
			for(Cred c : hm.values()) {
				oos.writeObject(c);
			}
			oos.flush();
			oos.close();
			fos.close();
			
			return hm ;
	}
	
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException {
		
		String username = req.getParameter("username") ;
		String domain = req.getParameter("credential-type");
		String password = req.getParameter("password");
		
		hm = storage(username , domain , password);
		
		for(Cred c : hm.values()) {
			System.out.println(c);
		}
		
		res.getWriter().print("Password saved successfully ");
		
		
	}

}
