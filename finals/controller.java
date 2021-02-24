package backup;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class controller
{
	
	private ArrayList<server> serverData = new ArrayList<>();
	server server = new server("", "", "", "");
	//	public ArrayList type = new ArrayList();
	//	public ArrayList location = new ArrayList();
	//	public ArrayList spec = new ArrayList();
	//	public ArrayList price = new ArrayList();
	
	public controller()
	{
	}
	
	public controller(ArrayList<server> serverData)
	{
		this.serverData = serverData;
	}
	
	public ArrayList<server> getServerData()
	{
		return serverData;
	}
	
	public void setServerData(ArrayList<server> serverData)
	{
		this.serverData = serverData;
	}
	
	//  Parameter di sesuaikan dengan constructor model
	public void insertData(String type, String location, String model, String price)
	{
		server servers = new server(type, location, model, price);
		serverData.add(servers);
		//  Optional (tampil di terminal)
		JOptionPane.showMessageDialog(null, "Added " + server.getType() + " to Cart!");
	}
	
	public void hapusData(int index)
	{
		serverData.remove(index);
	}
	
	public int getArrayListSize()
	{
		return serverData.size();
	}
}
