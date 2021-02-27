import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class NameFaker
{
	private List<String> names;
	
	public NameFaker(String path) throws IOException
	{
		names = Files.readAllLines(Paths.get(path));
	}
	
	public String generateName()
	{
		int index = (int) (names.size() * Math.random());
		return names.get(index);
	}
}
