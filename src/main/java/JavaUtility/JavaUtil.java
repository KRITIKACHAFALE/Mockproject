package JavaUtility;

import java.util.Random;

public class JavaUtil {

	public static int generateRandomNumber(int limit)
	{
		Random r = new Random();
		return r.nextInt(limit);
	}
}