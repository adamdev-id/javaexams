package progress;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Input_output extends Mahasiswa
{
	private String nama, alamat, telp, nim, prodi;
	private int angkatan, beban_sks, bayarbop;
	
	public Input_output(String nama, String alamat, String telp)
	{
		super(nama, alamat, telp);
	}
	
	Civitas_Undika cU = new Civitas_Undika("", "", "");
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Mahasiswa mahasiswa = new Mahasiswa("", "", "", "", "", 0, 0);
	
	public void inputData() throws IOException
	{
		System.out.println("= - User Input - =");
		System.out.println("Ketik NIM Mahasiswa       : ");
		System.out.print("> ");
		nim = br.readLine();
		//mahasiswa = new Mahasiswa(nim);
		System.out.println("Ketik Nama Mahasiswa      : ");
		System.out.print("> ");
		super.nama = br.readLine();
		//mahasiswa = new Mahasiswa(nama);
		System.out.println("Ketik Alamat Mahasiswa    : ");
		System.out.print("> ");
		super.alamat = br.readLine();
		//mahasiswa = new Mahasiswa(alamat);
		System.out.println("Ketik Telp Mahasiswa      : ");
		System.out.print("> ");
		super.telp = br.readLine();
		//mahasiswa = new Mahasiswa(telp);
		System.out.println("Ketik Prodi Mahasiswa     : ");
		System.out.print("> ");
		prodi = br.readLine();
		//mahasiswa = new Mahasiswa(prodi);
		System.out.println("Ketik Angkatan Mahasiswa  : ");
		System.out.print("> ");
		angkatan = Integer.parseInt(br.readLine());
		//mahasiswa = new Mahasiswa(angkatan);
		System.out.println("Ketik Beban SKS Mahasiswa : ");
		System.out.print("> ");
		beban_sks = Integer.parseInt(br.readLine());
		//mahasiswa = new Mahasiswa(beban_sks);
		System.out.println(" ");
		mahasiswa = new Mahasiswa(nim, nama, alamat, telp, prodi, angkatan, beban_sks);
	}
	
	public void ubahAngkatan() throws IOException
	{
		int oldAmount, newAmount;
		System.out.println("= - Ubah Angkatan - =");
		System.out.print("Masukkan Angkatan Lama : ");
		oldAmount = Integer.parseInt(br.readLine());
		System.out.print("Masukkan Angkatan Baru : ");
		newAmount = Integer.parseInt(br.readLine());
		//		super(nama, alamat, telp);
		//		this.nim = nim;
		//		this.angkatan = angkatan;
		//		this.prodi = prodi;
		//		this.beban_sks = beban_sks;
		if (oldAmount == mahasiswa.getAngkatan())
		{
			mahasiswa = new Mahasiswa(nim, nama, alamat, telp, prodi, newAmount, beban_sks);
			System.out.println("Jumlah Berhasil Dirubah.");
			System.out.println("Dari : [" + oldAmount + "] menjadi [" + newAmount + "] ");
		}
		else
		{
			System.out.println("Jumlah Lama : [" + oldAmount + "] Tidak ditemukan.");
		}
		System.out.println(" ");
	}
	
	public void showMenu_Main()
	{
		System.out.println("- = DATA MAHASISWA UNIVERSITAS DINAMIKA = -");
		System.out.println(" 1. Input Data          ");
		System.out.println(" 2. Cetak Data          ");
		System.out.println(" 3. Ubah Data           ");
		System.out.println(" 4. Keluar              ");
		System.out.println("Masukkan Pilihan :      ");
	}
	
	public void showMenu_Output()
	{
		System.out.println("NIM Mahasiswa       : " + mahasiswa.getNim());
		//mahasiswa = new Mahasiswa(nim);
		System.out.println("Nama Mahasiswa      : " + super.getNama());
		//mahasiswa = new Mahasiswa(nama);
		System.out.println("Alamat Mahasiswa    : " + super.getAlamat());
		//mahasiswa = new Mahasiswa(alamat);
		System.out.println("Telp Mahasiswa      : " + super.getTelp());
		//mahasiswa = new Mahasiswa(telp);
		System.out.println("Prodi Mahasiswa     : " + mahasiswa.getProdi());
		//mahasiswa = new Mahasiswa(prodi);
		System.out.println("Angkatan Mahasiswa  : " + mahasiswa.getAngkatan());
		//mahasiswa = new Mahasiswa(angkatan);
		System.out.println("Beban SKS Mahasiswa : " + mahasiswa.getBeban_SKS());
	}
	
	public void showMenu_Edit()
	{
		System.out.println("= - Ubah Pilihan - =      ");
		System.out.println("Masukkan Pilihan :       ");
	}
}
