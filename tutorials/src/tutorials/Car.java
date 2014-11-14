package tutorials;

public abstract class Car
{
	public Car()
	{
		System.out.print("print");
	}
	public double mpg(double miles, double galloons)
	{
		return(miles/galloons);
	}
	public abstract void setupComputer();
	
	public abstract void tireSize(int year, String model);
}
