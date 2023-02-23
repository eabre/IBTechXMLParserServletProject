package com.ibtech;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ibtech.bag.Bag;
import com.ibtech.bag.BagKey;
import com.ibtech.command.CommandExecuter;
import com.ibtech.dao.AccountDao;
import com.ibtech.dao.AddressDao;
import com.ibtech.dao.CustomerDao;
import com.ibtech.dao.PhoneDao;
import com.ibtech.model.Account;
import com.ibtech.model.Address;
import com.ibtech.model.Command;
import com.ibtech.model.Customer;
import com.ibtech.model.Phone;
import com.ibtech.operations.AccountOperations;
import com.ibtech.operations.CustomerOperations;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	Bag customerBag = new Bag();
    	customerBag.put(BagKey.ID, (int) 16);
    	customerBag.put(BagKey.NAME, "Kemal");
    	customerBag.put(BagKey.SURNAME, "Süzer");
    	customerBag.put(BagKey.TCKN, "TR453453");
    	
    	CommandExecuter.executer("update_customer_info", customerBag);
    }
    
}
