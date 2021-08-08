package utils;

import models.Pay;

import java.util.List;

public class util {


    public static Pay getPayFromList(List<Pay> payList, String sender, String paidBy)
    {
        int i ;
        for( i = 0 ; i < payList.size() ; i++ )
        {
            Pay p = payList.get(i) ;
            if( p.getSender().getUuid() == sender && p.getReceiver().getUuid() == paidBy )
                return p;


        }

        return null;

    }
}
