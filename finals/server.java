package backup;

public class server
{
	private String type_Server, location_Server, spec_Server, price_Server;
	
	public server(String type, String location, String spec, String price)
	{
		this.type_Server = type;
		this.location_Server = location;
		this.spec_Server = spec;
		this.price_Server = price;
	}
	
	public String getType()
	{
		return type_Server;
	}
	
	public void setType(String type)
	{
		this.type_Server = type;
	}
	
	public String getLocation()
	{
		return location_Server;
	}
	
	public void setLocation(String location)
	{
		this.location_Server = location;
	}
	
	public String getSpec()
	{
		return spec_Server;
	}
	
	public void setSpec(String spec)
	{
		this.spec_Server = spec;
	}
	
	public String getPrice()
	{
		return price_Server;
	}
	
	public void setPrice(String price)
	{
		this.price_Server = price;
	}
	
}
