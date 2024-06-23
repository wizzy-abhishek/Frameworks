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
public class Cred_Out extends HttpServlet{
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException {
		

		HashMap<String , Cred > hm = new HashMap<String, Cred>();
		
		try {
			FileInputStream fis = new FileInputStream("P:\\Servlets\\Fetcher\\src\\main\\java\\com\\password_saver\\Account_details");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Cred credobj = null ;
			
			int count = ois.readInt();
			for(int i = 0 ; i < count ; i++) {
				credobj = (Cred)ois.readObject();
				hm.put(credobj.username , credobj); 
			}
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
			
			
			String username = req.getParameter("fetching-data");
			String domain = req.getParameter("fetching-domain");
			
			for(Cred c : hm.values()) {
				if (username.equals(c.username) && domain.equalsIgnoreCase(c.domain)) {
					res.getWriter().print(c);
				}
			}
		
	}

}
