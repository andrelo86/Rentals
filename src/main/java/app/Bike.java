package app;

import java.time.LocalDateTime;

public class Bike {

  private LocalDateTime returnDate;
  private Boolean availability = Boolean.TRUE;


  public LocalDateTime getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(LocalDateTime returnDate) {
    this.returnDate = returnDate;
  }

  public Boolean getAvailability() {
    return availability;
  }

  public void setAvailability(Boolean availability) {
    this.availability = availability;
  }

}
