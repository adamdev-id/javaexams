import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;


public class main
{
	
	public static void main(String[] args) throws IOException
	{
		SimpleDateFormat sd = new SimpleDateFormat("YYYY/dd/MM");
		GregorianCalendar gc = new GregorianCalendar();
		//		for (int i = 0; i < 20; i++)
		//		{
		//		}
		//System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
		Random r = new Random();
		for (int i = 1; i < 101; i++)
		{
			//Random r = new Random();
			String merk;
			String mobil;
			String[] carBrands = { "Honda", "Toyota", "Suzuki", "Mazda", "Renault" };
			String[] carTypes = { "Supra", "Alphard", "Baleno", "RX-8", "Cleo" };
			String[] nama = { "Dian Herman Iskandar", "Hendri Sudirman Gunardi", "Luna Yingjie", "Tedja Bo", "Joey Sahuleka", "Issachar Sinuraya", "Ethan Sinurat", "Lazarus Sihole", "Susilo", "Purnama", "Mawar Ida Sudirman", "Anggawarsito Chenguang", "Bunda Yanmei", "Marilène Aratuaman", "Joy Nasution", "Drusilla Gurupatih", "Ariel Ompusunggu", "Lestari", "Laksmini", "Joses Pusuk", "Gershon Jampang", "Darma Hartono Johan", "Harta Bambang Kurniawan", "Linus Dingxiang",
				"Utama Peng", "Pieter-Jan Retraubun", "Zachariah Nahulae", "Ezekiel Sitepu", "Zechariah Gorat", "Kuwat", "Budi", "Hengki Guntur Tedja", "Sugondo Liang", "Yapardi Delun", "Jorin Faraknimela", "James Daransi", "Isaiah Sipahutar", "Matthias Sidauruk", "Suratman", "Susilo", "Putri Sri Sugiarto", "Sucianty Melati Sutedja", "Lumenta Ning", "Setiawan Yunru", "Nellie Veenstra", "Rebecca Lambe", "Jemimah Hulu", "Mary Bahorok", "Dwi", "Tuminindyah", "Widya Mega Lie",
				"Sucianty Utari Susanto", "Yaputra Lihwa", "Sulistio Jiaying", "Hetty van Houten", "Bilhah Tarihoran", "Hope Siampapaga", "Zipporah Solia", "Eko", "Utari", "Teguh Sudomo Dharmawijaya", "Doddy Iskandar Kusuma", "Widiatmo Chanming", "Linanto Dong", "Carle Hungan", "Mishael Hutagaol", "Matthew Barus", "Gideon Matanari", "Suripto", "Susilo", "Farida Devi Kusumo", "Dian Cahya Kartawijaya", "Wiranata Yüzhen", "Alim Shihong", "Myrte Johanes", "Rebecca Sambo",
				"Myra Sibagariang", "Drusilla Pelawi", "Surtinem", "Ratu", "Sugiarto Hadi Hadiman", "Hamdani Sugiarto Tahyadi", "Onggo Donghai", "Wongso Duyi", "Roland Pormes", "Zacchaeus Manik", "Jesse Jurung", "Matthias Pasaribu", "Budi", "Sukarno", "Doddy Suharto Tanuwidjaja", "Wahyu Dwi Pranoto", "Nyoto Weisheng", "Rusli Yongrui", "Ivo Louhenapessy", "Ethan Nainggolan", "James Ajartambun", "Paul Ramu", "Dwi", "Tirto" };
			
			//mobil = carTypes[rand.nextInt(carBrands.length)];
			//			if (carBrands[r.nextInt(carBrands.length)].equals("Honda"))
			//			{
			//				System.out.println("Mobil : " + carBrands[0] + ", " + carTypes[0]);
			//			}
			//			else if (carBrands[r.nextInt(carBrands.length)].equals("Toyota"))
			//			{
			//				System.out.println("Mobil : " + carBrands[1] + ", " + carTypes[1]);
			//			}
			//			else if (carBrands[r.nextInt(carBrands.length)].equals("Suzuki"))
			//			{
			//				System.out.println("Mobil : " + carBrands[2] + ", " + carTypes[2]);
			//			}
			//			else if (carBrands[r.nextInt(carBrands.length)].equals("Mazda"))
			//			{
			//				System.out.println("Mobil : " + carBrands[3] + ", " + carTypes[3]);
			//			}
			//			else if (carBrands[r.nextInt(carBrands.length)].equals("Renault"))
			//			{
			//				System.out.println("Mobil : " + carBrands[4] + ", " + carTypes[4]);
			//			}
			
			String fileName = "D://Development//Eclipse-Workspace//DatabaseGenerator//lahir.txt";
			String fileKota = "D://Development//Eclipse-Workspace//DatabaseGenerator//kota.txt";
			ArrayList<String> allNames = new ArrayList<String>();
			ArrayList<String> allKota = new ArrayList<String>();
			Random d = new Random();
			Random b = new Random();
			
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			while (in.ready())
			{
				allNames.add(in.readLine());
			}
			
			BufferedReader kn = new BufferedReader(new FileReader(fileKota));
			while (kn.ready())
			{
				allKota.add(kn.readLine());
			}
			
			in.close();
			kn.close();
			
			String randomYear = allNames.get(d.nextInt(allNames.size()));
			String randomKota = allKota.get(b.nextInt(allKota.size()));
			
			//			Faker faker = new Faker();
			//			
			//			String name = faker.name().fullName(); // Miss Samanta Schmidt
			//			String firstName = faker.name().firstName(); // Emory
			//			String lastName = faker.name().lastName(); // Barton
			//			
			//			String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
			
			//System.out.println("Fullname : " + name);;
			int tahun = randBetween(2017, 2020);
			
			gc.set(gc.YEAR, tahun);
			
			int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
			
			gc.set(gc.DAY_OF_YEAR, dayOfYear);
			
			//if (gc.get(gc.MONTH) < 9 && gc.get(gc.DAY_OF_MONTH) < 10)
			//{
			//System.out.print(nama[i]);
			//System.out.print(nama[i]);
			int ss = randBetween(100, 2000);
			if (ss < 10)
			{
				System.out.print("355220000" + ss);
			}
			else if (ss < 1000)
			{
				System.out.print("35522000" + ss);
			}
			else if (ss > 1000)
			{
				System.out.print("3552200" + ss);
			}
			//System.out.print(", 'L' , ");
			//System.out.print(";' 350" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + " '");
			//System.out.print(", '" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + "' ");
			//System.out.print(", 'DriverIMG00" + i + "'");
			//System.out.print(", ");
			//int year = randBetween(2017, 2020);
			//gc.set(gc.YEAR, year);
			//System.out.print(gc.get(gc.DAY_OF_MONTH) + "-" + randomYear + "-" + gc.get(gc.YEAR));
			System.out.println("");
			//}
			//			else if (gc.get(gc.MONTH) == 10 && gc.get(gc.DAY_OF_MONTH) < 10)
			//			{
			//				System.out.print(nama[i]);
			//				//				System.out.print(", '" + randomName + "' , 2 TO_DATE('" + gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-0" + gc.get(gc.DAY_OF_MONTH) + "','YYYY-MM-DD) , '" + randomKota + "' , ");
			//				//				System.out.print("'082" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + "'");
			//				//				System.out.print(", 'L' , ");
			//				//				System.out.print(";' 350" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + " '");
			//				//				System.out.print(", '" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + "' ");
			//				//				System.out.print(", 'DriverIMG00" + i + "'");
			//				//				System.out.print(", ");
			//				int year = randBetween(2015, 2020);
			//				gc.set(gc.YEAR, year);
			//				//System.out.print("TO_DATE('" + gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH) + "','YYYY-MM-DD')),");
			//				System.out.println("");
			//			}
			//			else if (gc.get(gc.MONTH) > 9 && gc.get(gc.DAY_OF_MONTH) < 10)
			//			{
			//				System.out.print(nama[i]);
			//				//				System.out.print(", '" + randomName + "' , 2 TO_DATE('" + gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-0" + gc.get(gc.DAY_OF_MONTH) + "','YYYY-MM-DD) , '" + randomKota + "' , ");
			//				//				System.out.print("'082" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + "'");
			//				//				System.out.print(", 'L' , ");
			//				//				System.out.print(";' 350" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + " '");
			//				//				System.out.print(", '" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + "' ");
			//				//				System.out.print(", 'DriverIMG00" + i + "'");
			//				//				System.out.print(", ");
			//				int year = randBetween(2015, 2020);
			//				gc.set(gc.YEAR, year);
			//				//System.out.print("TO_DATE('" + gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH) + "','YYYY-MM-DD')),");
			//				System.out.println("");
			//			}
			//			else if (gc.get(gc.MONTH) < 9 && gc.get(gc.DAY_OF_MONTH) > 9)
			//			{
			//				System.out.print(nama[i]);
			//				//				System.out.print(", '" + randomName + "' , 2 TO_DATE('" + gc.get(gc.YEAR) + "-0" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH) + "','YYYY-MM-DD) , '" + randomKota + "' , ");
			//				//				System.out.print("'082" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + "'");
			//				//				System.out.print(", 'L' , ");
			//				//				System.out.print(";' 350" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + " '");
			//				//				System.out.print(", '" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + "' ");
			//				//				System.out.print(", 'DriverIMG00" + i + "'");
			//				//				System.out.print(", ");
			//				int year = randBetween(2015, 2020);
			//				gc.set(gc.YEAR, year);
			//				//System.out.print("TO_DATE('" + gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH) + "','YYYY-MM-DD')),");
			//				System.out.println("");
			//			}
			//			else if (gc.get(gc.MONTH) > 9 && gc.get(gc.DAY_OF_MONTH) > 9)
			//			{
			//				System.out.print(nama[i]);
			//				//				System.out.print(", '" + randomName + "' , 2 TO_DATE('" + gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH) + "','YYYY-MM-DD) , '" + randomKota + "' , ");
			//				//				System.out.print("'082" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + "'");
			//				//				System.out.print(", 'L' , ");
			//				//				System.out.print(";' 350" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + " '");
			//				//				System.out.print(", '" + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + "' ");
			//				//				System.out.print(", 'DriverIMG00" + i + "'");
			//				//				System.out.print(", ");
			//				int year = randBetween(2015, 2020);
			//				gc.set(gc.YEAR, year);
			//				//System.out.print("TO_DATE('" + gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH) + "','YYYY-MM-DD')),");
			//				System.out.println("");
			//			}
		}
		
	}
	
	public static int randBetween(int start, int end)
	{
		return start + (int) Math.round(Math.random() * (end - start));
	}
	
	//	public static void main(String[] args)
	//	{
	//		
	//	}
}
