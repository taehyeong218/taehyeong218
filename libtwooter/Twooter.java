import twooter.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

class Message extends java.lang.Object{
    public java.lang.String id;
    public java.lang.String name;
    public java.lang.String message;
    public long published;
    public long expires;

    public Message(String i, String n, String m, long p, long e ){
        i = id;
        n = name;
        m = message;
        p = published;
        e = expires; 
    }

    public java.lang.String toString(){
        System.out.println(super.toString());
        return message;
    }
}

class TwooterClient extends java.lang.Object{
    public String name; 
    public String token;
    public boolean refresh;
    public boolean isactive;
    public Message message;
    public String clientmessage;
    public String identifier;
    public String id;
    public boolean elivefeed;

    public TwooterClient(){
        //System.out.println(token);
    }

    public java.lang.String registerName(String n){
        n = name;
        return token;
    }

    public boolean refreshName(java.lang.String n, java.lang.String t) throws java.io.IOException{
        n = name;
        t = token;
        return refresh;
    }

    public boolean isActiveName(java.lang.String n) throws java.io.IOException{
        n = name;
        return isactive;
    }

    /*public Message[] getMessages(){
        return Message.message;
    }*/

    public Message getMessage(java.lang.String id){
        return message;
    }

    public void addUpdateListner(UpdateListner m){

    }

    public boolean enableLiveFeed(){
        return true;
    }
    public java.lang.String postMessage(java.lang.String t, java.lang.String n, java.lang.String m){
        t = token;
        n = name;
        m = clientmessage;

        return identifier;
    }
   
}

class TwooterEvent extends java.lang.Object implements UpdateListner{
    public int CONNECT;
    public int DISCONNECT;
    public int MESSAGE;
    public java.lang.String payload;
    public int TAG;
    public long time;
    public int type;
    public int USER;

    public TwooterEvent(int t, java.lang.String p){
        t = type;
        p = payload;
    }
    public void handleUpdate(TwooterEvent update){
        System.out.println(update);
    }
    public void update(int MESSAGE, int USER){
        return;
    }
}

interface UpdateListner{
    public void handleUpdate(TwooterEvent update);
}

public class Twooter{
    public static void main(String[] args){
        //TwooterEvent e = new TwooterEvent(2, payload);
        //Message message = new Message(ab,cd,ef,12,34);
        /*JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        
        frame.setVisible(true);
        frame.setContentPane(panel); 
        frame.setSize(640, 640);
        frame.setTitle("Twooter"); 

        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
          
        TwooterClient c = new TwooterClient();
        TwooterEvent e = new TwooterEvent(1, "aaaa");
        Message m = new Message("ab", c.name, "cccc", 3, 4);
        c.name = "abcd";
        c.token = c.registerName(c.name);
        System.out.println(c.token);
        c.id = "zzz";
        c.clientmessage = "xxxx";
        //c.addUpdateListner(e.update);
        c.enableLiveFeed();
        //c.refreshName(c.name, c.token);
        //c.isActiveName(c.name);
        c.getMessage(c.id);
        c.postMessage(c.token, c.name, c.clientmessage);

        m.name = c.name;
        m.id = "ab";
        m.message = "efg";
        m.toString();
        
        
         
    }
}
