import app.Bike;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import rents.Rent;
import rents.RentFactory;

public class RentalsTest {

  private static final Logger LOGGER = Logger.getLogger(RentalsTest.class.getName());

  private static final int BIKES_QTY = 10;

  private List<Bike> bikes;


  @BeforeSuite
  public void setUp() {
    LOGGER.info("Loading test data..");
    this.bikes = new ArrayList<>();
    IntStream.range(0, BIKES_QTY).
        forEach(bike -> bikes.add(new Bike()));
    LOGGER.info("Test data loaded successfully..");
  }


  @Test
  public void rentByHourCalculatorTest() {
    Rent singleRent = RentFactory.createSingleRent(5, ChronoUnit.HOURS);

    Double expectedTotalRent = 25.0;
    Double calculatedTotalRent = singleRent.rent(bikes);

    Assert.assertEquals(expectedTotalRent, calculatedTotalRent,
        "Something went wrong by calculate a Single Rent by Hour.");
  }

  @Test
  public void rentByDayCalculatorTest() {
    Rent singleRent = RentFactory.createSingleRent(2, ChronoUnit.DAYS);

    Double expectedTotalRent = 40.0;
    Double calculatedTotalRent = singleRent.rent(bikes);

    Assert.assertEquals(expectedTotalRent, calculatedTotalRent,
        "Something went wrong by calculate a Single Rent by Day.");
  }

  @Test
  public void rentByWeekCalculatorTest() {
    Rent singleRent = RentFactory.createSingleRent(3, ChronoUnit.WEEKS);

    Double expectedTotalRent = 180.0;
    Double calculatedTotalRent = singleRent.rent(bikes);

    Assert.assertEquals(expectedTotalRent, calculatedTotalRent,
        "Something went wrong by calculate a Single Rent by Week.");
  }

  @Test
  public void rentComplexCalculatorTest() {
    Rent rentByDays = RentFactory.createSingleRent(2, ChronoUnit.DAYS);
    Rent rentByWeek = RentFactory.createSingleRent(3, ChronoUnit.WEEKS);

    List<Rent> rents = new ArrayList<>();
    rents.add(rentByDays);
    rents.add(rentByWeek);

    Rent complexRent = RentFactory.createComplexRental(rents);

    Double expectedTotalRent = 220.0;
    Double calculatedTotalRent = complexRent.rent(bikes);

    Assert.assertEquals(expectedTotalRent, calculatedTotalRent,
        "Something went wrong by calculate a Complex Rent.");
  }

  @Test
  public void complexRentWithDiscountCalculatorTest() {
    Rent rentByHour = RentFactory.createSingleRent(4, ChronoUnit.HOURS);
    Rent rentByDays = RentFactory.createSingleRent(2, ChronoUnit.DAYS);
    Rent rentByWeek = RentFactory.createSingleRent(3, ChronoUnit.WEEKS);

    List<Rent> rents = new ArrayList<>();
    rents.add(rentByHour);
    rents.add(rentByDays);
    rents.add(rentByWeek);

    Rent complexRent = RentFactory.createComplexRental(rents);

    Double promotionDiscount = 0.3;
    Double expectedTotalRent = 240.0 * promotionDiscount;
    Double calculatedTotalRent = complexRent.rent(bikes);

    Assert.assertEquals(expectedTotalRent, calculatedTotalRent,
        "Something went wrong by calculate a Complex Rent with a Family Promotion Discount.");
  }

  @Test(expectedExceptions = NullPointerException.class)
  public void bikeUnavailableTest() {
    Rent singleRent = RentFactory.createSingleRent(5, ChronoUnit.HOURS);

    Double expectedTotalRent = 25.0;
    Double calculatedTotalRent = singleRent.rent(null);
  }

}
