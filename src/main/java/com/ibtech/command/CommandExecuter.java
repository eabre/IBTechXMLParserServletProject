package com.ibtech.command;

import java.lang.reflect.Method;
import java.util.List;

import com.ibtech.dao.CommandDao;
import com.ibtech.model.Command;
import com.ibtech.model.Customer;
import com.ibtech.operations.CustomerOperations;

public class CommandExecuter {
	
	public static Method executer(String commandName) throws Exception {
		try {
			CommandDao commandDao = new CommandDao();
			Command command = commandDao.getCommand(commandName);
			
			
			Class<?> c = Class.forName("com.ibtech.operations." + command.getClassName());
			Object obj = c.newInstance();
			Method method;
			
			//Task2 de sadece customer için yaptım
			method = c.getDeclaredMethod(command.getMethodName(), List.class, Customer.class);
			
			//method.invoke(obj);
			System.out.println("-> Executing works fine");
			return method;

		} catch (Exception e) {
			System.out.println("-> Executing failed");
			e.printStackTrace();
			throw e;
		}		
	}

}
