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


public class KeyStruct {
	
	private char[] masterKey;
	private String service;
	
	public KeyStruct (String service, char[] masterKey){
		this.setService(service);
		this.setMasterKey(masterKey);
	}

	/*Getters and Setters for Mk e S*/
	public char[] getMasterKey() {
		return masterKey;
	}

	public void setMasterKey(char[] masterKey) {
		this.masterKey = masterKey;
	}


	public String getService() {
		return service;
	}


	public void setService(String service) {
		this.service = service;
	}
	
	
}
