package progress;


import java.io.IOException;
import java.util.Scanner;


public class Main
{
	
	public static void main(String[] args) throws IOException
	{
		Input_output IO = new Input_output("", "", "");
		Scanner scanner = new Scanner(System.in);
		int pilihan;
		int oldAmount = 0;
		int newAmount = 0;
		
		while (true)
		{
			IO.showMenu_Main();
			System.out.print("> ");
			pilihan = Integer.parseInt(scanner.nextLine());
			System.out.println(" \n");
			switch (pilihan)
			{
			case 1:
				IO.inputData();
				continue;
			case 2:
				IO.showMenu_Output();
				System.out.println(" ");
				continue;
			case 3:
				IO.ubahAngkatan();
				continue;
			}
			System.exit(0);
			break;
		}
	}
}
