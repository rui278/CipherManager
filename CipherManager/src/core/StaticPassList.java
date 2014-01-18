package core;

import java.util.LinkedList;

public class StaticPassList {
	
	static LinkedList<PassStruct> list;
	
	StaticPassList(){
		list = new LinkedList<PassStruct>();
	}


	protected PassStruct getPassStruct(String Service){
		
		for(int i = 0; i < list.size(); i++){
		
			if(list.get(i).getAfterService() == Service){
				return list.get(i); 
			}
			
		}
		
		return null; 
	}
	
	protected void addPassStruct(PassStruct passStruct){
		list.add(passStruct);
	}
	
}




