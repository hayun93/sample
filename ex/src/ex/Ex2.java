package ex;

import java.util.ArrayList;

public class Ex2 {
	ArrayList<PhoneValue> list = new ArrayList<>();
	
	void insertPhoneNumber(String name,String phoneNumber){
		PhoneValue pv = new PhoneValue(name,phoneNumber);
		list.add(pv);
	}
	
	public ArrayList<PhoneValue> getPhoneNumberList(){
		return list;
	}
}
