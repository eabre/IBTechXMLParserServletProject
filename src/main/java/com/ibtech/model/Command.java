package com.ibtech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Command {
	
	@Id
	@Column(name = "command_name")
	private String commandName;
	
	@Column(name = "class_name")
	private String className;
	
	@Column(name = "method_name")
	private String methodName;

	public Command() {
		super();
	}

	public Command(String commandName, String className, String methodName) {
		super();
		this.commandName = commandName;
		this.className = className;
		this.methodName = methodName;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	

}
