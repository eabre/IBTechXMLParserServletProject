package com.ibtech.command;

import java.lang.reflect.Method;
import java.util.List;

import com.ibtech.bag.Bag;
import com.ibtech.dao.CommandDao;
import com.ibtech.model.Command;

public class CommandExecuter {
	
	public static Bag executer(String commandName, Bag bag) throws Exception {
		try {
			CommandDao commandDao = new CommandDao();
			Command command = commandDao.getCommand(commandName);
			
			if(command.equals(null)) {
				
				System.out.println("command not found");
				return null;
			}
			
			//Reflection
			Class<?> c = Class.forName("com.ibtech.operations." + command.getClassName());
			Object obj = c.getDeclaredConstructor().newInstance();
			Method method;
			Bag bagResult;
			if(!bag.getMap().isEmpty()) {
				method = c.getDeclaredMethod(command.getMethodName(), Bag.class);
				bagResult = (Bag) method.invoke(obj, bag);
			}
			else {
				method = c.getDeclaredMethod(command.getMethodName());
				bagResult = (Bag) method.invoke(obj);
			}

			System.out.println("-> Executing works fine");
			return bagResult;

		} catch (Exception e) {
			System.out.println("-> Executing failed");
			e.printStackTrace();
			throw e;
		}		
	}

}
