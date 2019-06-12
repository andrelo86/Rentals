package rents;

import app.Bike;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.apache.log4j.Logger;
import utils.Message;

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
   *
   * @param timeType
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
      LocalDateTime localDateTime = LocalDateTime.now();
      localDateTime = localDateTime.plus(time, timeType);
      try {
        Bike bike = Objects.requireNonNull(getFirstAvailableBike(bikes));
        bike.setReturnDate(localDateTime);
        bike.setAvailability(Boolean.FALSE);
        return time * rate;
      } catch (NullPointerException nullPointerException) {
        throw new NullPointerException(Message.NO_BICYCE_AVAILABLE_MSG + nullPointerException);
      }
  }

  private Bike getFirstAvailableBike(List<Bike> bikes) {
    Optional<Bike> bike = bikes.stream()
        .filter(Bike::getAvailability)
        .findFirst();
        return bike.orElse(null);
  }

}
