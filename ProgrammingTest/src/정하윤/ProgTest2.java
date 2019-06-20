package ¡§«œ¿±;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ProgTest2 {
	Map<String,MemberData> mapList = new Hashtable<>();
	
	void mapListAdd(String memberID,String name,String tel,String gender){
		MemberData md = new MemberData(memberID, name, tel, gender);
		mapList.put(memberID,md);
	}
	
	void mapListRemove(String memberID) {
		mapList.remove(memberID);
	}

	ArrayList<MemberData> getMapList() {
		ArrayList<MemberData> arraymd = new ArrayList<>();
		Set<String> mlset = mapList.keySet();
		Iterator<String> mliterator = mlset.iterator();
		while(mliterator.hasNext()) {
			String k = mliterator.next();
			MemberData v = mapList.get(k);
			arraymd.add(v);
			
		}
		return arraymd;
	}
}
