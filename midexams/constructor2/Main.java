package tugasFirdaus;


import java.io.IOException;
import java.util.Scanner;


public class Main
{
	
	public static void main(String[] args) throws IOException
	{
		
		Scanner scanner = new Scanner(System.in);
		Transaction transaction = new Transaction("", 0, 0);
		Menu menu = new Menu();
		Products product = new Products();
		String space = " ";
		String name = "null";
		String oldName = "null";
		String newName = "null";
		String idSearch = "";
		String nameSearch = "";
		int pilihan;
		int pilihan2;
		int pilihan3;
		int found = 0;
		int amount = 0;
		int price = 0;
		int oldAmount = 0;
		int newAmount = 0;
		
		String[][] daftarProduk = {
			{ " [1]", "Server Reguler     " },
			{ " [2]", "Server Bisnis      " },
			{ " [3]", "Server Eksekutif   " }
		};
		
		while (true)
		{
			
			menu.showMenu_Main();
			System.out.print("> ");
			pilihan = Integer.parseInt(scanner.nextLine());
			System.out.println(" \n");
			switch (pilihan)
			{
			case 1:
				System.out.println("= - Adam's Hosting - =");
				for (int i = 0; i < daftarProduk.length; i++) //cetak baris
					for (int j = 0; j < 1; j++) //cetak kolom
					{
						{
							System.out.print(daftarProduk[i][0] + " " + daftarProduk[i][1]); //Print Daftar Server
							
						}
						System.out.println(""); //enter baris
					}
				System.out.println("= - User Input - =");
				System.out.println("Ketik Nama Produk : ");
				System.out.print("> ");
				name = scanner.nextLine();
				System.out.println("Ketik Jumlah yang akan Dibeli : ");
				System.out.print("> ");
				amount = Integer.parseInt(scanner.nextLine());
				System.out.println("Ketik Harga Produk ( Satuan ) : ");
				System.out.print("> ");
				price = Integer.parseInt(scanner.nextLine());
				transaction = new Transaction(name, amount, price);
				System.out.println("");
				continue;
			case 2:
				transaction.showMenu_PrintProduct();
				System.out.println(space);
				continue;
			case 3:
				menu.showMenu_Edit();
				System.out.print("> ");
				pilihan2 = Integer.parseInt(scanner.nextLine());
				System.out.println(space);
				switch (pilihan2)
				{
				case 1:
					System.out.println("= - Ubah Nama - =");
					System.out.print("Masukkan Nama Lama : ");
					oldName = scanner.nextLine();
					System.out.print("Masukkan Nama Baru : ");
					newName = scanner.nextLine();
					if (oldName.toLowerCase().contains(transaction.getName().toLowerCase()))
					{
						transaction = new Transaction(newName, amount, price);
						System.out.println("Nama Berhasil Dirubah.");
						System.out.println("Dari : [" + oldName + "] menjadi [" + newName + "] ");
					}
					else
					{
						System.out.println("Nama Lama : [" + oldName + "] Tidak ditemukan.");
					}
					System.out.println(space);
					continue;
				case 2:
					System.out.println("= - Ubah Jumlah - =");
					System.out.print("Masukkan Jumlah Lama : ");
					oldAmount = Integer.parseInt(scanner.nextLine());
					System.out.print("Masukkan Jumlah Baru : ");
					newAmount = Integer.parseInt(scanner.nextLine());
					if (oldAmount == transaction.getAmount())
					{
						transaction = new Transaction(name, newAmount, price);
						System.out.println("Jumlah Berhasil Dirubah.");
						System.out.println("Dari : [" + oldAmount + "] menjadi [" + newAmount + "] ");
					}
					else
					{
						System.out.println("Jumlah Lama : [" + oldAmount + "] Tidak ditemukan.");
					}
					System.out.println(space);
					continue;
				
				default:
					continue;
				}
			case 4:
				menu.showMenu_EditAsAdmin();
				pilihan3 = Integer.parseInt(scanner.nextLine());
				//Transaction transaction = new Transaction("", 0, 0);
				//Menu menu = new Menu();
				switch (pilihan3)
				{
				case 1:
					//					System.out.println("= - [ADMIN PANEL] - =  ");
					//					System.out.println("[1] Ubah Nama Produk   ");
					//					System.out.println("[2] Ubah Harga Produk  ");
					//					System.out.println("[3] Keluar             ");
					//					System.out.println("Masukkan Pilihan :     ");
					System.out.println("= - Ubah Nama - =");
					for (int i = 0; i < daftarProduk.length; i++) //cetak baris
						for (int j = 0; j < 1; j++) //cetak kolom
						{
							{
								System.out.print(daftarProduk[i][0] + " " + daftarProduk[i][1]); //Print Daftar Server
								
							}
							System.out.println(""); //enter baris
						}
					System.out.println(" ");
					System.out.println("Masukkan Nama Produk : ");
					oldName = scanner.nextLine();
					for (int i = 0; i < 3; i++)
					{
						System.out.println(daftarProduk[i][1]);
						if (oldName.toLowerCase().contains(oldName.toLowerCase()))
						{
							System.out.println("Masukkan Nama Produk : ");
							newName = daftarProduk[i][1];
						}
					}
					System.out.println("Nama Produk [" + oldName + "] Tidak Ditemukan!");
					continue;
				case 2:
					continue;
				}
				
			}
			System.exit(0);
			break;
		}
	}
}
