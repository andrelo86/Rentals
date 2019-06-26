package exceptions;

public class NotAvailableBicycleException extends RuntimeException {

  public NotAvailableBicycleException(Throwable t) {
    super(ErrorMessage.NOT_AVAILABLE_BICYCLES, t);
  }

}
