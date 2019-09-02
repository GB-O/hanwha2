package lab1;

public class TVUser {
	public static void main(String[] args) {
		
		TV tv = TVFactory.makeTV("sam");
		tv.powerOn();
		tv.powerOff();
		
		tv = TVFactory.makeTV("lg");
		tv.powerOn();
		tv.powerOff();
		
	}
}
