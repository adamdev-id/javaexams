import java.util.Random;


public class Test
{
	public static void main(String[] args)
	{
		String merk;
		String mobil;
		String[] carBrands = { "Honda", "Suzuki", "Honda", "Honda", "Kawasaki", "Yamaha", "Honda2", "Honda3", "Honda4", "Honda5", "Yamaha2" };
		String[] carTypes = { "Supra", "Shogun", "Mio", "Vario", "Ninja", "NMax", "PCX", "Beat", "Revo", "Scoopy", "CBR250", "RX King" };
		String[] Plat = { "L", "AE", "AG", "M", "P" };
		String[] bPlat = { " ", "", "", "", "", };
		String[] ccKend = { "125", "125", "110", "125", "250", "150", "150", "110", "110", "110", "250", "175" };
		String[] warna = { "Merah", "Putih", "Hitam", "Abu-Abu", "Merah", "Putih" };
		Random r = new Random();
		
		Random rand = new Random();
		for (int i = 0; i < 100; i++)
		{
			//			System.out.print(" " + (char) (r.nextInt(8) + 'A'));
			//			System.out.println((char) (r.nextInt(8) + 'A') + "',");
			int nopol = randBetween(3000, 6999);
			merk = carBrands[rand.nextInt(carBrands.length)];
			//mobil = carTypes[rand.nextInt(carBrands.length)];
			if (carBrands[rand.nextInt(carBrands.length)].equals("Honda"))
			{
				System.out.println(Plat[rand.nextInt(Plat.length)]);
			}
			if (carBrands[rand.nextInt(carBrands.length)].equals("Honda2"))
			{
				System.out.println(warna[rand.nextInt(warna.length)]);
			}
			if (carBrands[rand.nextInt(carBrands.length)].equals("Honda3"))
			{
				System.out.println(warna[rand.nextInt(warna.length)]);
			}
			if (carBrands[rand.nextInt(carBrands.length)].equals("Honda4"))
			{
				System.out.println(warna[rand.nextInt(warna.length)]);
			}
			if (carBrands[rand.nextInt(carBrands.length)].equals("Honda5"))
			{
				System.out.println(warna[rand.nextInt(warna.length)]);
			}
			if (carBrands[rand.nextInt(carBrands.length)].equals("Yamaha2"))
			{
				System.out.println(warna[rand.nextInt(warna.length)]);
			}
			else if (carBrands[rand.nextInt(carBrands.length)].equals("Suzuki"))
			{
				System.out.println(warna[rand.nextInt(warna.length)]);
			}
			else if (carBrands[rand.nextInt(carBrands.length)].equals("Kawasaki"))
			{
				System.out.println(warna[rand.nextInt(warna.length)]);
			}
			else if (carBrands[rand.nextInt(carBrands.length)].equals("Yamaha"))
			{
				System.out.println(warna[rand.nextInt(warna.length)]);
			}
			
		}
		
	}
	
	public static int randBetween(int start, int end)
	{
		return start + (int) Math.round(Math.random() * (end - start));
	}
}
