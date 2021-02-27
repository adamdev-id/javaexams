package progress;

public class Civitas_Undika
{
	protected String nama, alamat, telp;
	
	public Civitas_Undika(String nama, String alamat, String telp)
	{
		this.nama = nama;
		this.alamat = alamat;
		this.telp = telp;
	}
	
	public String getNama()
	{
		return this.nama;
	}
	
	public String getAlamat()
	{
		return this.alamat;
	}
	
	public String getTelp()
	{
		return this.telp;
	}
}
