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

import java.security.SecureRandom;
import gui.mainClass;

public class Action implements Runnable {
	
	private KeyStruct key;
	private int actionID;
	private int size = 20;
	
	@Override
	public void run() {
		System.out.print("Button: " + actionID + "\n");
		
		switch(actionID){
			case 1:
				this.getPswd(key);
				break;
			case 2:
				this.createPswd(key);
				break;
			case 3:
				this.showPswd(key);
				break;
			case 4:
				this.cAndgPswd(key);
				break;
			case 5:
				this.cAndsPswd(key);
				break;
			case 6:
				this.gAndsPswd(key);
				break;
			case 7:
				this.csvPswds(key);
				break;
			case 8:
				this.customPswd(key);
				break;
			default: break;
		}
	}
	
	
	public Action(KeyStruct newKey, int i){
	
		this.key = newKey;
		this.actionID = i;
	}
	
	//Button Action Methods//
	
	//Get Password Method//
	private void getPswd(KeyStruct key){
		System.out.print("I'm Getting the password!\n");
		
		
		return;
	}
	
	//Create Password Method
	private void createPswd(KeyStruct key){
		
		char[] password = this.generatePassword();
		
		System.out.print(password);
		
		PassStruct genPass = new PassStruct(mainClass.file.encrypt(key, password), key.getService(), null);
		
		mainClass.file.writeToFile();

	//	PassStruct pass = new PassStruct(mainClass.file.encrypt(key, password),key.getService(), password);
				
		
		return;
	}

	//Show Password Method//
	private void showPswd(KeyStruct key){
		System.out.print("I'm Showing the password!\n");
		return;
	}
	
	//Create & Get Password Method//
	private void cAndgPswd(KeyStruct key){
		
	}
	
	//Create & Show Password Method//
	private void cAndsPswd(KeyStruct key){
		
	}
	
	//Get and Show Password Method//	
	private void gAndsPswd(KeyStruct key){
		
	}
	
	//Export to csv Method//
	private void csvPswds(KeyStruct key){
		
	}
	
	//Add Custom Password Method//
	private void customPswd(KeyStruct key){
		
	}
	
	//Generates Passwords//
	
	private char[] generatePassword() {


		char[] genPass = new char[20];
		
				SecureRandom random = new SecureRandom();

				for (int fi = -10; fi < 10; fi++){
					int out = fi % 5;
					System.out.print(out+"\n");
				}
		for(int i = 0; i < size; i++){
			
			
			int chooserInt = random.nextInt();
			
			if (chooserInt < 0) chooserInt *=-1;
			
			chooserInt %= 92;
			chooserInt += 33;
			
			
			genPass[i] = (char) chooserInt;
		}
		
		return genPass;
	}

}	

