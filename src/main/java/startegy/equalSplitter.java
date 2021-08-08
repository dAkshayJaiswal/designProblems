package startegy;

import enums.SplitMethod;
import models.Bill;
import models.Pay;
import models.User;
import utils.util;

import java.util.List;

public class equalSplitter implements split {
    @Override
    public void fillPayList(List<Pay> payList, List<User> userList, Bill bill) {

        User paidBy = bill.getPaidBy() ;

        if( bill.getSplitMethod() == SplitMethod.EQUALLY )
        {

            Double amount = bill.getExpense() / userList.size() ;

            for( int i  = 0 ; i < userList.size() ; i++ )
            {
                User sender = userList.get(i) ;
                if( sender.getUuid() != paidBy.getUuid() )
                {

                    Pay pay = util.getPayFromList(payList,sender.getUuid(),paidBy.getUuid()) ;
                    if( pay != null )
                        pay.setAmount(pay.getAmount()+amount);
                    else
                        pay = new Pay(sender,paidBy,amount) ;
                    payList.add(pay) ;

                }
            }
        }
        }
    }

