package tugasFirdaus;

public class Transaction
{
	private String name;
	private int amount;
	private int price;
	
	public Transaction(String productName, int Amount, int Price)
	{
		this.name = productName;
		this.amount = Amount;
		this.price = Price;
	}
	
	public Transaction(String productName)
	{
		this.name = productName;
	}
	
	public Transaction(int amount)
	{
		this.amount = amount;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getAmount()
	{
		return this.amount;
	}
	
	public int getPrice()
	{
		return this.price;
	}
	
	public int getTotal()
	{
		return getAmount() * getPrice();
	}
	
	public void showMenu_PrintProduct()
	{
		System.out.println("= - Result - =");
		System.out.println("Product Name : " + getName());
		System.out.println("Buy Amount   : " + getAmount());
		System.out.println("Server Price : " + getPrice());
		System.out.println("Total        : " + getTotal());
	}
}
