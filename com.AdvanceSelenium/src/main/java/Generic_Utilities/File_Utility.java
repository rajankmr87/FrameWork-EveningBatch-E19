package Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility {

	/**
	 * this method is used to read data from propertied file (External resource)
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Rajan
	 */
	public String getKeyAndValuePair(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/DDT.properties");

		// step2:-create an object to properties class to load all the keys
		Properties pro = new Properties();
		pro.load(fis);

		// step3:-read the value using getProperty()
		String Value = pro.getProperty(key);
		
		return Value;
		
	}

}
