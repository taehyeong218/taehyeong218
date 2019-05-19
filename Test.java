//package twooter;
import twooter.*;

public class Test{
	
    public static void main(String[] args){  
    	
    	TwooterConnector tc = new TwooterConnector();
    	TwooterFrame tf = new TwooterFrame(tc);
    	tf.setVisible(true);
    	
    	TwooterRefresh tr = new TwooterRefresh(tc, tf);
		tr.run();

    }
}