package exceptions;

public class NotExistingPromotionException extends RuntimeException {

  public NotExistingPromotionException() {
    super(ErrorMessage.NOT_SYSTEM_PROMOTION);
  }

}
