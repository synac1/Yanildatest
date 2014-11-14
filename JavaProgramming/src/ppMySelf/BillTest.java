package ppMySelf;

public class BillTest {
	
	public static void main(String[] args)
	{
		Bill myBill= new Bill("","",0,0.0);
		myBill.setNumber("3499b");
		myBill.setDescription("Sheet Metal Screws #10x1-1/2in");
		myBill.setQuantity(10);
		myBill.setPrice(3.0);
		
		String a=myBill.getNumber();
		String b=myBill.getDescription();
		int c=myBill.getQuantity();
		double d=myBill.getPrice();
		double e=myBill.getBillAmount();
		System.out.println("Yanilda's Hardware Store\nPhone:718-888-7765\n");
		System.out.printf("Item: %s\nNumber: %s\nQuantity: %d\nPrice: $%.2f" +
				"\nTotal: $%.2f\n", b,a,c,d,e);
		System.out.println("\nThanks for shopping!");
		

	}

}
