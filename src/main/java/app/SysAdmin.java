package app;

import static java.lang.String.format;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.log4j.Logger;
import utils.Utils;

/**
 * Singleton class used as bicycle store.
 */
public class SysAdmin {

  private static final String CONFIG_FILE = Utils.RESOURCES_PATH + "config";

  private static Logger logger = Logger.getLogger(SysAdmin.class);

  private static SysAdmin ourInstance = new SysAdmin();

  private List<Bike> bikes;

  private SysAdmin() {
    String bikesQty = Utils.getValueFromPropertieFile(CONFIG_FILE, "STOCK");
    loadStock(Integer.parseInt(
        Objects.requireNonNull(bikesQty)));
  }

  private void loadStock(int availableBikes) {
    bikes = new ArrayList<>();
    IntStream.range(0, availableBikes).forEach(bike -> bikes.add(new Bike()));
  }

  public static SysAdmin getInstance() {
    if (null == ourInstance) {
      ourInstance = new SysAdmin();
    }
    return ourInstance;
  }

  public List<Bike> getAvailableBikes() {
    return bikes.stream()
        .filter(Bike::getAvailability)
        .collect(Collectors.toList());
  }

  public void publishReturnDate() {
    List<Bike> rentedBikes = bikes.stream()
        .filter(bike -> !bike.getAvailability())
        .collect(Collectors.toList());
    for (Bike bike : rentedBikes) {
      Date asDate = Date.from(bike.getReturnDate().atZone(ZoneId.systemDefault()).toInstant());
      logger.info(format("This bike will be returned in: %s", asDate.toString()));
    }
  }

}
