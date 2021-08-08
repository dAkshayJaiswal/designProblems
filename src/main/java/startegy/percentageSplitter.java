package startegy;

import enums.SplitMethod;
import models.Bill;
import models.Pay;
import models.User;
import utils.util;

import java.util.List;

public class percentageSplitter implements split {
    @Override
    public void fillPayList(List<Pay> payList, List<User> userList, Bill bill) {

        User paidBy = bill.getPaidBy() ;


        if( bill.getSplitMethod() == SplitMethod.PERCENTAGE )
        {


            for( int i  = 0 ; i < userList.size() ; i++ )
            {
                User sender = userList.get(i) ;
                if( bill.getSplitMap().containsKey(sender.getUuid()) && sender.getUuid() != paidBy.getUuid() )
                {

                    Double percentage = bill.getSplitMap().get(sender.getUuid()) ;
                    Pay pay = util.getPayFromList(payList,sender.getUuid(),paidBy.getUuid()) ;
                    if( pay != null )
                        pay.setAmount(pay.getAmount()+bill.getExpense()*percentage / 100 );
                    else
                        pay = new Pay(sender,paidBy,bill.getExpense()*percentage / 100 );

                    payList.add(pay) ;

                }
            }

        }

    }
}
