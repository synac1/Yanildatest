package ppMySelf;

public class Bill {
	String partNumber,  partDescription;
	int itemQuantity;
	double itemPrice;
	
	public Bill(String pN, String pD, int iQ, double iP)
	{
		partNumber=pN;
		partDescription=pD;
		itemQuantity=iQ;
		itemPrice=iP;
	}
	public void setNumber(String number)
	{
		partNumber=number;
	}
	public String getNumber()
	{
		return partNumber;
	}
	public void setDescription(String description)
	{
		partDescription=description;
	}
	public String getDescription()
	{
		return partDescription;
	}
	public void setQuantity(int quantity)
	{
		itemQuantity=quantity;
	}
	public int getQuantity()
	{
		return itemQuantity;
	}
	public void setPrice(double price)
	{
		itemPrice=price;
	}
	public double getPrice()
	{
		return itemPrice;
	}
	
	double getBillAmount()
	{
		return itemPrice*itemQuantity;
	}
}
