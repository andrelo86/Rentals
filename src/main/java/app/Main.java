package app;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.log4j.Logger;
import rents.ComplexRent;
import rents.Rent;
import rents.RentFactory;
import utils.Utils;

public class Main {
  private static final String CONFIG_FILE = Utils.RESOURCES_PATH + "config";

  private static SysAdmin sysAdmin = SysAdmin.getInstance(Integer.parseInt(
      Objects.requireNonNull(Utils.getValueFromPropertiesFile(CONFIG_FILE, "STOCK"))));
  private static Logger logger = Logger.getLogger(Main.class);

  public static void main(String[] args) {
    // Create Rents
    Rent rent4Hours = RentFactory.createSingleRent(4, ChronoUnit.HOURS);
    Rent rentAWeek = RentFactory.createSingleRent(1, ChronoUnit.WEEKS);
    Rent rent2Hour = RentFactory.createSingleRent(2, ChronoUnit.HOURS);

    List<Rent> rents = new ArrayList<>();
    rents.add(rent4Hours);
    rents.add(rentAWeek);
    rents.add(rent2Hour);

    ComplexRent complexRent = RentFactory.createComplexRental(rents);

    //Execute rents
    logger
        .info("You rent a bike for a total of: " + rent4Hours.rent(sysAdmin.getAvailableBikes()));
    sysAdmin.publishReturnDate();

    complexRent.rent(sysAdmin.getAvailableBikes());
    sysAdmin.publishReturnDate();

  }

}
