package rents;

import entities.Bike;
import java.util.List;
import java.util.Objects;
import org.apache.log4j.Logger;
import utils.Utils;

public abstract class Rent {

  private static final String RATES_FILE = Utils.RESOURCES_PATH + "config";

  protected static Logger logger = null;

  protected Double byHour = Double.valueOf(
      Objects.requireNonNull(Utils.getValueFromPropertiesFile(RATES_FILE, "RATE_BY_HOUR")));
  protected Double byDay = Double
      .valueOf(Objects.requireNonNull(Utils.getValueFromPropertiesFile(RATES_FILE, "RATE_BY_DAY")));
  protected Double byWeek = Double
      .valueOf(
          Objects.requireNonNull(Utils.getValueFromPropertiesFile(RATES_FILE, "RATE_BY_WEEK")));

  public Rent() {
  }

  public abstract Double rent(List<Bike> bikes);

}
