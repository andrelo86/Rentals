package app;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.log4j.Logger;
import utils.Message;

/**
 * Singleton class used as bicycle store.
 */
public class SysAdmin {

  private static Logger logger = Logger.getLogger(SysAdmin.class);

  private static SysAdmin ourInstance;

  private List<Bike> bikes;

  private SysAdmin(int totalBikes) {
    loadStock(totalBikes);
  }

  private void loadStock(int availableBikes) {
    bikes = new ArrayList<>();
    IntStream.range(0, availableBikes).forEach(bike -> bikes.add(new Bike()));
  }

  public static SysAdmin getInstance(int totalBikes) {
    if (null == ourInstance) {
      ourInstance = new SysAdmin(totalBikes);
    }
    return ourInstance;
  }

  public List<Bike> getAvailableBikes() {
    return bikes.stream()
        .filter(Bike::getAvailability)
        .collect(Collectors.toList());
  }

  public void publishReturnDate() {
    List<Bike> rentedBikes = getRentedBikes();
    if (!rentedBikes.isEmpty()) {
      for (Bike bike : rentedBikes) {
        Date asDate = Date.from(bike.getReturnDate().atZone(ZoneId.systemDefault()).toInstant());
        logger.info(String.format("%s%s", Message.RETURN_INFO_MSG, asDate.toString()));
      }
    }
  }

  private List<Bike> getRentedBikes() {
    return bikes.stream()
          .filter(bike -> !bike.getAvailability())
          .collect(Collectors.toList());
  }

  public List<Bike> getBikes(){
    return this.bikes;
  }

  public static void reset() {
    ourInstance = null;
  }

}
