package promotions;

import java.util.List;
import rents.Rent;

public interface Criteria {

  Boolean comply(List<Rent> rent);

}
