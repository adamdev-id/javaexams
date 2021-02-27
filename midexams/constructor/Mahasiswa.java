package progress;

public class Mahasiswa extends Civitas_Undika
{
	private String nim, prodi;
	private int angkatan, beban_sks, bayarbop;
	
	public Mahasiswa(String nama, String alamat, String telp)
	{
		super(nama, alamat, telp);
	}
	
	public Mahasiswa(String nama, String alamat, String telp, String nim, String prodi, int angkatan, int beban_sks)
	{
		
		super(nama, alamat, telp);
		this.nim = nim;
		this.angkatan = angkatan;
		this.prodi = prodi;
		this.beban_sks = beban_sks;
	}
	
	public String getNim()
	{
		return this.nim;
	}
	
	//	public String getNama()
	//	{
	//		return this.nama;
	//	}
	
	public int getAngkatan()
	{
		return this.angkatan;
	}
	
	public String getProdi()
	{
		return this.prodi;
	}
	
	public int getBebanSKS()
	{
		return this.beban_sks;
	}
	
	public int getBeban_SKS()
	{
		return this.beban_sks;
	}
	
	public int hitungBOP()
	{
		if (this.angkatan > 2017)
		{
			if (getBeban_SKS() == 8)
			{
				bayarbop = 15000000;
			}
		}
		else if (this.angkatan < 2017)
		{
			bayarbop = 11000000;
		}
		
		return bayarbop;
	}
}
