//package twooter;
import twooter.*;
import java.io.IOException;

public class TwooterRefresh extends Thread {

	private TwooterConnector tc;
	private TwooterFrame tf;
	
	public TwooterRefresh(TwooterConnector tc, TwooterFrame tf) {
		// TODO Auto-generated constructor stub
		this.tc = tc;
		this.tf = tf;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			try {
				tf.makejTable(tc.getTwooterMessage());
				tf.repaint();
				
				tc.getClient().refreshName(tc.getName(), tc.getToken());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} finally {
				try {
					sleep(20000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
