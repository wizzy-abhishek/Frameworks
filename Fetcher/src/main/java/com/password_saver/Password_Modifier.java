package com.password_saver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Password_Modifier extends HttpServlet{
	
public static HashMap<String , Cred> storage() throws IOException {
		
		
		try {
			FileInputStream fis = new FileInputStream("P:\\Servlets\\Fetcher\\src\\main\\java\\com\\password_saver\\Account_details");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Cred credobj = null ;
			
			int count = ois.readInt();
			for(int i = 0 ; i < count ; i++) {
				credobj = (Cred)ois.readObject();
				Cred_Store.hm.put(credobj.username , credobj); 
			}
			ois.close();
			fis.close();
			}catch(Exception e) {
			System.out.println(e);
			}
		
		
			FileOutputStream fos = new FileOutputStream("P:\\Servlets\\Fetcher\\src\\main\\java\\com\\password_saver\\Account_details");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeInt(Cred_Store.hm.size());
			for(Cred c : Cred_Store.hm.values()) {
				oos.writeObject(c);
			}
			oos.flush();
			oos.close();
			fos.close();
			
			return Cred_Store.hm ;
	}

	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException{
		
		String modifier_username = req.getParameter("Modifier_username");
		String modifier_domain = req.getParameter("Modifier_username");
		String new_Password = req.getParameter("new_password");
		
		
		
		for(Cred c : Cred_Store.hm.values()) {
			if( modifier_domain.equalsIgnoreCase(c.domain)) {
				Cred_Store.hm.remove(modifier_username);
				Cred_Store.storage(modifier_username , modifier_domain , new_Password);
			}
		}
		System.out.println(Cred_Store.hm);
	}
}
