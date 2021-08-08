package service;

import enums.SplitMethod;
import models.Bill;
import models.Group;
import models.Pay;
import models.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SplittwiseService {

    List<Group> groupList = new ArrayList<>() ;


    public void createGroup(List<User> usersList)
    {
        Group group = new Group() ;
        group.setUsersList(usersList);
        groupList.add(group) ;
    }

    public void addBill(Bill bill,Group group)
    {

        try {

            int i;
            Group g = null;

            for (i = 0; i < groupList.size(); i++) {

                if (groupList.get(i).getGroupId() == group.getGroupId()) {
                    g = groupList.get(i);
                    break;

                }

            }

            if (g != null) {
                g.getBillList().add(bill);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<Pay> getPayMapGroupWise(Group group)
    {
        List<User> userList = group.getUsersList() ;

        int i ;
        for( i = 0 ; i < group.getBillList().size() ; i++ )
        {
            Bill bill = group.getBillList().get(i) ;

            fillPayList(group.getPayList(),userList,bill) ;

        }

        return group.getPayList() ;

    }

//    private void fillPayList(List<Pay> payList, List<User> userList, Bill bill) {
//
//        User paidBy = bill.getPaidBy() ;
//
//        if( bill.getSplitMethod() == SplitMethod.EQUALLY )
//        {
//
//            Double amount = bill.getExpense() / userList.size() ;
//
//            for( int i  = 0 ; i < userList.size() ; i++ )
//            {
//                User sender = userList.get(i) ;
//                if( sender.getUuid() != paidBy.getUuid() )
//                {
//
//                    Pay pay = getPayFromList(payList,sender.getUuid(),paidBy.getUuid()) ;
//                    if( pay != null )
//                        pay.setAmount(pay.getAmount()+amount);
//                    else
//                        pay = new Pay(sender,paidBy,amount) ;
//                    payList.add(pay) ;
//
//                }
//            }
//        }
//        else if( bill.getSplitMethod() == SplitMethod.FIXED_VALUE )
//        {
//
//
//            for( int i  = 0 ; i < userList.size() ; i++ )
//            {
//                User sender = userList.get(i) ;
//                if( bill.getSplitMap().containsKey(sender.getUuid()) && sender.getUuid() != paidBy.getUuid() )
//                {
//
//                    Double ratio = bill.getSplitMap().get(sender.getUuid()) ;
//
//
//                    Pay pay = getPayFromList(payList,sender.getUuid(),paidBy.getUuid()) ;
//                    if( pay != null )
//                        pay.setAmount(pay.getAmount()+bill.getExpense()*ratio / 10 );
//                    else
//                        pay = new Pay(sender,paidBy,bill.getExpense()*ratio / 10 );
//
//                    payList.add(pay) ;
//
//                }
//            }
//
//        }
//        else if( bill.getSplitMethod() == SplitMethod.PERCENTAGE )
//        {
//
//
//            for( int i  = 0 ; i < userList.size() ; i++ )
//            {
//                User sender = userList.get(i) ;
//                if( bill.getSplitMap().containsKey(sender.getUuid()) && sender.getUuid() != paidBy.getUuid() )
//                {
//
//                    Double percentage = bill.getSplitMap().get(sender.getUuid()) ;
//                    Pay pay = getPayFromList(payList,sender.getUuid(),paidBy.getUuid()) ;
//                    if( pay != null )
//                        pay.setAmount(pay.getAmount()+bill.getExpense()*percentage / 100 );
//                    else
//                        pay = new Pay(sender,paidBy,bill.getExpense()*percentage / 100 );
//
//                    payList.add(pay) ;
//
//                }
//            }
//
//        }
//
//    }










    public Set<Pay> getPayMapOverall(User user)
    {
        String uuid = user.getUuid() ;
        Set<Pay> resSet = new HashSet<Pay>() ;

        int i ;
        for( i = 0 ; i < groupList.size() ; i++ )
        {
            if( groupList.get(i).getUsersList().contains(user) )
            {
                List<Pay> pays = groupList.get(i).getPayList() ;
               for( int j = 0 ; j < pays.size() ; j++ )
               {

                   Pay p = pays.get(j) ;
                   if( p.getSender().getUuid() == user.getUuid() || p.getReceiver().getUuid() == user.getUuid() )

                   {
                       updatePaySet(p,resSet) ;

                   }

               }
            }

        }

        return resSet ;



    }

    private void updatePaySet(Pay p, Set<Pay> resSet) {


    }

    public List<Bill>   getTransactionStatement(User user, Group group) {
        if( group.getBillList() != null )
            return group.getBillList() ;

        return null;
    }


}
