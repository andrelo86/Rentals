package promotions;

import java.util.List;
import java.util.Objects;
import rents.Rent;
import utils.Message;
import utils.Utils;

public class FamilyPromotion implements Criteria {

  private static final String CONFIG_FILE = "config";
  private static final String FAMILY_PROMO = "FAMILY_PROMO";
  private static final String MESSAGE = Message.FAMILY_PROMOTION_MSG;

  private int minRents = Integer.parseInt(
      Objects.requireNonNull(
          Utils.getValueFromPropertiesFile(Utils.RESOURCES_PATH + CONFIG_FILE, "MIN_RENTS")));
  private int maxRents = Integer.parseInt(
      Objects.requireNonNull(
          Utils.getValueFromPropertiesFile(Utils.RESOURCES_PATH + CONFIG_FILE, "MAX_RENTS")));

  private Double familyDiscount = Double.valueOf(
      Objects.requireNonNull(
          Utils.getValueFromPropertiesFile(Utils.RESOURCES_PATH + CONFIG_FILE, FAMILY_PROMO)));


  @Override
  public Boolean comply(List<Rent> rent) {
    return rent.size() >= minRents && rent.size() <= maxRents;
  }

  public Double getDiscount() {
    return familyDiscount;
  }

  public String getMessage() {
    return MESSAGE;
  }

}
