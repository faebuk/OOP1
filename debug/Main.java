package motor;

public class Main {

	public static void main(String[] args) {
		Motor m1 = new Motor("RX-400", 35.5);
		Motor.NAME="PowDrill";
		m1.start(200);
		Motor m2 = new Motor("TU-200", 350);
		m2.stop();
		System.out.println(Motor.NAME + m2.power);
	}
}

