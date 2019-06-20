package rents;

import entities.Bike;
import exceptions.NotExistingPromotionException;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import promotions.Promotion;
import promotions.PromotionFactory;

/**
 * Class to represent a complex Rent, we can set multiples singles rents and apply promotions.
 */
public class ComplexRent extends Rent {

  private static final String TOTAL = "Total: ";

  private List<Rent> rentableList;
  private Promotion promotion;


  ComplexRent(List<Rent> rentableList) {
    this.rentableList = rentableList;
    logger = Logger.getLogger(ComplexRent.class);
    setPromotion();
  }

  private void setPromotion() { // Contemplate not existing promos.
    Optional<Promotion> promo = PromotionFactory.createPromo("FAMILY_PROMO");
    if (promo.isPresent()) {
      this.promotion = promo.get();
    } else {
      throw new NotExistingPromotionException();
    }
  }

  @Override
  public Double rent(List<Bike> bikes) {
    if (!bikes.isEmpty()) {
      Double total = 0.0;
      for (Rent singleRent : rentableList) {
        total += singleRent.rent(bikes);
      }
      return getTotal(total);
    } else {
      return null; // null used to define that all bikes was rented.
    }
  }

  private Double getTotal(Double total) {
    if (promotion.comply(rentableList)) {
      logger.info(promotion.getMessage() + " " + TOTAL + total * promotion.getDiscount());
      return total * promotion.getDiscount();
    } else {
      logger.info(TOTAL + total);
      return total;
    }
  }

}
