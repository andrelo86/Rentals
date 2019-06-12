package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class Utils {

  private static Logger logger = Logger.getLogger(Utils.class);

  public static final String RESOURCES_PATH = "src" + File.separator
      + "main" + File.separator
      + "resources" + File.separator;

  private Utils() {
  }

  public static String getValueFromPropertiesFile(String file, String key) {
    try (InputStream input = new FileInputStream(file)) {

      Properties prop = new Properties();

      prop.load(input);

      return prop.getProperty(key);

    } catch (IOException ex) {
      logger.info("Cannot read from file: " + ex);
      return null;
    }
  }

}
