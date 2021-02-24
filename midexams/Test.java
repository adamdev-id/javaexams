
import java.io.IOException;
import java.util.Scanner;


public class Test
{
	
	public static void main(String[] args) throws IOException
	{
		
		Scanner scanner = new Scanner(System.in);
		//Transaction transaction = new Transaction("", 0, 0);
		//Input_Output IO = new Input_Output();
		//Products product = new Products();
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
		
		String username = "";
		String password = "";
		
		String[][] daftarData = {
			{ "admin", "admin123" }
		};
		
		while (true)
		{
			System.out.println("- Login Authentication -");
			System.out.println("Username :");
			System.out.print("> ");
			username = scanner.nextLine();
			System.out.println("Password :");
			System.out.print("> ");
			password = scanner.nextLine();
			
			String userDB = daftarData[0][0];
			String passDB = daftarData[0][1];
			
			if (username.contains(userDB))
			{
				if (password.contains(passDB))
				{
					System.out.println("Berhasil Masuk!");
				}
				
			}
			
			pilihan = Integer.parseInt(scanner.nextLine());
			System.out.println(" \n");
			switch (pilihan)
			{
			case 1:
				continue;
			case 2:
				System.out.println(space);
				continue;
			case 3:
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
					//					if (oldName.toLowerCase().contains(transaction.getName().toLowerCase()))
					//					{
					//						//transaction = new Transaction(newName, amount, price);
					//						System.out.println("Nama Berhasil Dirubah.");
					//						System.out.println("Dari : [" + oldName + "] menjadi [" + newName + "] ");
					//					}
					//					else
					//					{
					//						System.out.println("Nama Lama : [" + oldName + "] Tidak ditemukan.");
					//					}
					System.out.println(space);
					continue;
				case 2:
					System.out.println("= - Ubah Jumlah - =");
					System.out.print("Masukkan Jumlah Lama : ");
					oldAmount = Integer.parseInt(scanner.nextLine());
					System.out.print("Masukkan Jumlah Baru : ");
					newAmount = Integer.parseInt(scanner.nextLine());
					//					if (oldAmount == transaction.getAmount())
					//					{
					//						//transaction = new Transaction(name, newAmount, price);
					//						System.out.println("Jumlah Berhasil Dirubah.");
					//						System.out.println("Dari : [" + oldAmount + "] menjadi [" + newAmount + "] ");
					//					}
					//					else
					//					{
					//						System.out.println("Jumlah Lama : [" + oldAmount + "] Tidak ditemukan.");
					//					}
					System.out.println(space);
					continue;
				
				default:
					continue;
				}
			}
			System.exit(0);
			break;
		}
	}
}
