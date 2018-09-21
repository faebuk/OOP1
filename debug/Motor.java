
package motor;

public class Motor {
	public static String NAME;
	private String model;
	public final double power;
	int speed;
	
	public Motor(String m, double p)
	{ model = m; power = p;	}
	public void start(int s)
	{ speed = s; }
	public void stop()
	{ speed = 0;}

	public double getPower() {
		return power;
	}
	public String getName()
	{
		return Motor.NAME + power;
	}
	public String getModel()
	{
		return model;
	}
}

