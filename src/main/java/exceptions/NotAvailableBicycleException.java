package exceptions;

public class NotAvailableBicycleException extends RuntimeException {

  public NotAvailableBicycleException() {
    super(ErrorMessage.NOT_AVAILABLE_BICYCLES);
  }

}
