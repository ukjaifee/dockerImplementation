package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyReader {

	public static String getProperties(String data) throws Exception {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/data.Properties");
		Properties pro = new Properties();

		pro.load(fis);

		return pro.getProperty(data);

	}

}
