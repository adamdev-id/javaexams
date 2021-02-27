
public class Generator_No_Account
{
	public static void main(String[] args)
	{
		for (int i = 1; i < 151; i++)
		{
			if (i < 10)
			{
				System.out.println("C000" + i);
			}
			else if (i < 100)
			{
				System.out.println("C00" + i);
			}
			else if (i < 151)
			{
				System.out.println("C0" + i);
			}
		}
	}
}
