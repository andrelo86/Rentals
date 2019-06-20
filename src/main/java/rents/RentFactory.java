package rents;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class RentFactory {

  private RentFactory() {
  }

  public static SingleRent createSingleRent(Integer time, ChronoUnit timeType) {
    return new SingleRent(time, timeType);
  }

  public static ComplexRent createComplexRental(List<Rent> singleRents) {
    return new ComplexRent(singleRents);
  }

}
