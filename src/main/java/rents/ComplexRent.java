package rents;

import app.Bike;
import java.util.List;
import org.apache.log4j.Logger;
import promotions.FamilyPromotion;

/**
 * Class to represent a complex Rent, we can set multiples singles rents and apply promotions.
 */
public class ComplexRent extends Rent {

  private static final String TOTAL = "Total: ";

  private List<Rent> rentableList;
  private FamilyPromotion promotion = new FamilyPromotion();


  ComplexRent(List<Rent> rentableList) {
    this.rentableList = rentableList;
    logger = Logger.getLogger(ComplexRent.class);
  }

  @Override
  public Double rent(List<Bike> bikes) {
    Double total = 0.0;
    for (Rent singleRent : rentableList) {
      total += singleRent.rent(bikes);
    }
    if (promotion.comply(rentableList)) {
      logger.info(promotion.getMessage() + " " + TOTAL + total * promotion.getDiscount());
      return total * promotion.getDiscount();
    } else {
      logger.info(TOTAL + total);
      return total;
    }
  }
}
