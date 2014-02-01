/** CipherManager is a simple password management tool. Uses AES and SHA256 encryption technologies.
 *  Copyright (C) 2014  Rui Albuquerque
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>
 *    
 *  To contact me please do so at rui.278@outlook.com
 */
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




