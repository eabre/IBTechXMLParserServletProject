package com.ibtech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ibtech.model.Command;
import com.ibtech.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class CommandDao {

	public Command getCommand(String commandName) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			
			List<Command> commands = session.createCriteria(Command.class).list();;
			
			//non-transactional
			//transaction.commit();
			
			for (Command commandItem : commands) {
				if (commandItem.getCommandName().equals(commandName)) {
					return commandItem;
				}
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}
}
