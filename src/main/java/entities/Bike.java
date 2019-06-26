package entities;

import java.time.LocalDateTime;

/**
 * Mutable Bike object to modify state to reserved or free.
 */
public class Bike {

  private LocalDateTime returnDate = null;
  private Boolean availability = Boolean.TRUE;

  public Bike() {
  }


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
