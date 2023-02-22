package com.ibtech.operations;

import java.util.List;

import com.ibtech.model.Address;

public class AddresOperations {

	public void add(List<Address> addressList, Address address) {
		
		addressList.add(address);
	}
	
	public void update(List<Address> addressList, Address address, int index) {
		
		addressList.set(index, address);
	}
	
	public void delete(List<Address> addressList, int index) {
		
		addressList.remove(index);
	}
}
