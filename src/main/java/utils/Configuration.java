package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	
	private Properties properties;
	private String defaultPath = "configuration/config.properties";
	
	public Configuration(String path) {
		if (path == null) {
			loadProperty(defaultPath);
		}else {
			loadProperty(path);
		}//or just loadProperty(defaultPath); same thing but cannot handle exception
	}
		
	private void loadProperty(String path) {
		properties = new Properties();
		try {
			InputStream iStream = new FileInputStream(path);
			properties.load(iStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getConfiguration(String key) {
		if (key != null) {
			return properties.getProperty(key);
		}else {
			return null;
		}//or just return properties.getProperty(key); same thing but can't handle exception
	}
}
