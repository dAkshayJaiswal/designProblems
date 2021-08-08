package startegy;

import models.Bill;
import models.Pay;
import models.User;

import java.util.List;

public interface split {

    void fillPayList(List<Pay> payList, List<User> userList, Bill bill) ;


}
