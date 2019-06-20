package promotions;

import java.util.Optional;

public class PromotionFactory {

  private PromotionFactory() {
  }


  public static Optional<Promotion> createPromo(
      String promoType) { // Agregue que devuelva un optional aca tambien, por si no encuentra la key.

    return promoType.equals("FAMILY_PROMO") ? Optional.of(new FamilyPromotion()) : Optional.empty();

  }

}
