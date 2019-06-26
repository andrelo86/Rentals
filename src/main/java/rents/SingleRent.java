package rents;

import entities.Bike;
import exceptions.NotAvailableBicycleException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.apache.log4j.Logger;

/**
 * Class to represent a single rent (1 bike) by hour day or week.
 */
public class SingleRent extends Rent {

  private Integer time;
  private ChronoUnit timeType;
  private Double rate;


  public SingleRent(Integer time, ChronoUnit timeType) {
    super();
    logger = Logger.getLogger(SingleRent.class);
    this.time = time;
    this.timeType = timeType;
    setRate(timeType);
  }


  /**
   * If this grows we should look for a design to avoid switch.
   */
  private void setRate(ChronoUnit timeType) {
    switch (timeType) {
      case HOURS:
        rate = this.byHour;
        break;
      case DAYS:
        rate = this.byDay;
        break;
      case WEEKS:
        rate = this.byWeek;
      default:
    }
  }

  @Override
  public Double rent(List<Bike> bikes) {
    try {
      LocalDateTime localDateTime = LocalDateTime.now();
      localDateTime = localDateTime.plus(time, timeType);
      Optional<Bike> bike = getFirstAvailableBike(bikes);
      if (bike.isPresent()) {
        bike.get().setReturnDate(localDateTime);
        bike.get().setAvailability(Boolean.FALSE);
        return time * rate;
      } else {
        return null; // Null used to know is there are available bicycles
      }
    } catch (NullPointerException np) {
      throw new NotAvailableBicycleException(np);
    }
  }

  private Optional<Bike> getFirstAvailableBike(
      List<Bike> bikes) { // Aca le agregue que devuelva un optional por si no hay bicis disponibles
    return bikes.stream()
        .filter(Bike::getAvailability)
        .findFirst();
  }

}
