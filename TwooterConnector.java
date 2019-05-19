import twooter.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class TwooterConnector {
	
	private String name = "zero098";
	private String token;
	private TwooterClient client;
	
	private String fileName = "token.txt";
	
	public TwooterConnector() {
		// TODO Auto-generated constructor stub
		
		 try {
			 
			 client = new TwooterClient();
			 token = client.registerName(name);
			 
			 //System.out.println(c.isUp());
	         System.out.println(token);
	         if(token != null){
	        	 File file = new File(fileName);
	        	 
	        	 FileWriter fw = new FileWriter(file);
	        	 fw.write(token);
	        	 fw.flush();
	        	 
	        	 fw.close();
	        	 
	         }
	         while(token == null){
	         	//name=name+"1";
	            //token = client.registerName(name);
	        	 File file = new File(fileName);
	        	 
	        	 FileReader fileReader = new FileReader(file);
	        	 
	        	 BufferedReader bufReader = new BufferedReader(fileReader);
	        	 
	        	 String line = "";
	        	 while((line = bufReader.readLine()) != null){
	        		 token = line;
	        	 }
	        	 
	        	 bufReader.close();
	         }
	         if(token != null){
	        	 if(!client.refreshName(fileName, token)){
	        		 return;
	        	 }
	        	 else {
	        		 System.out.println("login!"+token);
	        	 }
	         } 
	         else {
	        	 return;
	         }
	         
	         System.out.println(token);
	         
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public Object[][] getTwooterMessage(){
		
		Object[][] obj = null;
		
		try {
			
			Message[] msgs = client.getMessages();
			obj = new Object[msgs.length][3];
	          
			for(int i = 0; i < msgs.length; i++){

				Message m = msgs[i];
	          	System.out.println(m);
	          	obj[i][0] = m.message;
	          	obj[i][1] = "@" + m.name;
	          	//obj[i][2] = m.id;
	          	obj[i][2] = "";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public Object[][] getTwooterMessage(String name){
		
		Object[][] obj = null;
		
		try {
			
			Message[] msgs = client.getMessages(name);
			obj = new Object[msgs.length][3];
	          
			for(int i = 0; i < msgs.length; i++){

				Message m = msgs[i];
	          	System.out.println(m);
	          	obj[i][0] = m.message;
	          	obj[i][1] = "@" + m.name;
	          	//obj[i][2] = m.id;
	          	obj[i][2] = "";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public Object[][] getTwooterTagMessage(String[] id){
		
		Object[][] obj = new Object[id.length][3];
		
		try {
			
			
			Message[] tagMsgs = new Message[id.length];
	          
			for(int i = 0; i < id.length; i++){

				obj[i][0] = client.getMessage(id[i]).message;
				obj[i][1] = "@" + client.getMessage(id[i]).name;
				//obj[i][2] = client.getMessage(id[i]).id;
				obj[i][2] = "";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public TwooterClient getClient() {
		return client;
	}

	public void setClient(TwooterClient client) {
		this.client = client;
	}
	
}
