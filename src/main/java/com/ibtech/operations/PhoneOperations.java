package com.ibtech.operations;

import java.util.List;

import com.ibtech.model.Phone;

public class PhoneOperations {

	public void add(List<Phone> phoneList, Phone phone) {
		
		phoneList.add(phone);
	}
	
	public void update(List<Phone> phoneList, Phone phone, int index) {
		
		phoneList.set(index, phone);
	}
	
	public void delete(List<Phone> phoneList, int index) {
		
		phoneList.remove(index);
	}
}
