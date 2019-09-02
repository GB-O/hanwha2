package lab1;

public class SamsungTV implements TV{
	
	public void powerOn() {
		System.out.println(this.getClass().getSimpleName() + "전원을 켠다.");
	}
	
	public void powerOff() {
		System.out.println(this.getClass().getSimpleName() + "전원을 끈다.");
	}
	
}
