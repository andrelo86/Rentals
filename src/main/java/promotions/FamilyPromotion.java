package promotions;

import java.util.List;
import java.util.Objects;
import rents.Rent;
import utils.Utils;

public class FamilyPromotion implements Criteria {

  private Double familyDiscount = Double.valueOf(
      Objects.requireNonNull(
          Utils.getValueFromPropertieFile(Utils.RESOURCES_PATH + "config", "FAMILY_PROMO")));
  private static final String MESSAGE = "You have a family promotion applied to your rental!";

  @Override
  public Boolean comply(List<Rent> rent) {
    return rent.size() >= 3 && rent.size() <= 5;
  }

  public Double getDiscount() {
    return familyDiscount;
  }

  public String getMessage() {
    return MESSAGE;
  }

}
