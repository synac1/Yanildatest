package tutorials;

public class Toyota extends Car
{

	public Toyota()
	{
		double mpg=mpg(60.3, 1.9);
		
	}

	@Override
	public void setupComputer() {
		// TODO Auto-generated method stub
		System.out.print("Computer set up");
		
	}

	@Override
	public void tireSize(int year, String model) {
		// TODO Auto-generated method stub
		System.out.print("For the model"+model+"you willneed a small tire");
		
	}
}
