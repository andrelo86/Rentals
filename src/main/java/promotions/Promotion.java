package promotions;

public abstract class Promotion implements Criteria {

  protected static final String CONFIG_FILE = "config";
  protected String promotionType;
  protected String message;


  public abstract Double getDiscount();

  public abstract String getMessage();

}
