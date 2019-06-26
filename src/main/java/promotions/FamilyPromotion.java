package promotions;

import java.util.List;
import java.util.Objects;
import rents.Rent;
import utils.Message;
import utils.Utils;

public class FamilyPromotion extends Promotion {

  private Integer minRents;
  private Integer maxRents;
  private Double familyDiscount;

  public FamilyPromotion() {
    this.promotionType = "FAMILY_PROMO";
    this.message = Message.FAMILY_PROMOTION_MSG;
    configurePromotion();
  }

  private void configurePromotion() {
    this.minRents = Integer.parseInt(
        Objects.requireNonNull(
            Utils.getValueFromPropertiesFile(Utils.RESOURCES_PATH + CONFIG_FILE, "MIN_RENTS")));
    this.maxRents = Integer.parseInt(
        Objects.requireNonNull(
            Utils.getValueFromPropertiesFile(Utils.RESOURCES_PATH + CONFIG_FILE, "MAX_RENTS")));
    this.familyDiscount = Double.valueOf(
        Objects.requireNonNull(
            Utils.getValueFromPropertiesFile(Utils.RESOURCES_PATH + CONFIG_FILE, "FAMILY_PROMO")));
  }

  @Override
  public Boolean comply(List<Rent> rent) {
    return rentsQuantity(rent) >= minRents && rentsQuantity(rent) <= maxRents;
  }

  private int rentsQuantity(List<Rent> rent) {
    return rent.size();
  }

  public Double getDiscount() {
    return familyDiscount;
  }

  public String getMessage() {
    return message;
  }

}
