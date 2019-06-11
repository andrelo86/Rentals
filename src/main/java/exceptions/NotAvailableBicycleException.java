package exceptions;

public class NotAvailableBicycleException extends Exception {

  public NotAvailableBicycleException(String message, NullPointerException e) {
    super(message, e);
  }

}
