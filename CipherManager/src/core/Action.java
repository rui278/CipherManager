package core;

import java.security.SecureRandom;
import gui.mainClass;

public class Action implements Runnable {
	
	private KeyStruct key;
	private int actionID;
	private int size = 15;
	
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
		
		String password = this.generatePassword();

		PassStruct pass = new PassStruct(mainClass.file.encrypt(key, password),key.getService(), password);
				
		
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
	
	private String generatePassword() {
		int A = 'A';
		int Z = 'Z';
		int a = 'a';
		int z = 'z';
		int char0 = '0';
		int char9 = '9';
		int excalamtion = '!';
		int fslash = '/';
		int doublepoint = ':';
		int at = '@';
		int rightBrackOpen = '[';
		int underscore = '_';
		int curlyOpen = '{';
		int curlyClose = '}';

		String genPass = "";
		
		SecureRandom random = new SecureRandom();


		for(int i = 0; i < size; i++){
			
			int j = 1 + (int)(random.nextFloat() * ((4 - 1) + 1));
			int offset = 0;
			
			switch(j){
				case 1:
					offset = A + (int)(random.nextFloat() * ((Z - A) + 1));
					break;
				case 2:
					offset = a + (int)(random.nextFloat() * ((z - a) + 1));
					break;
				case 3:
					offset = char0 + (int)(random.nextFloat() * ((char9 - char0) +1));
					break;
				case 4:
					int k = 1 + (int)(random.nextFloat() * ((4 - 1) + 1));
					switch(k){
						case 1:
							offset = excalamtion + (int)(random.nextFloat() * ((fslash - excalamtion) + 1));
							break;
						case 2:
							offset = doublepoint+ (int)(random.nextFloat() * ((at - doublepoint) + 1));
							break;
						case 3:
							offset = rightBrackOpen + (int)(random.nextFloat() * ((underscore - rightBrackOpen) + 1));
							break;
						case 4:
							offset = curlyOpen + (int)(random.nextFloat() * ((curlyClose - curlyOpen) + 1));
							break;
						default: break;
					}
				default: break;
			}
			char add = (char)offset;
			
			genPass = genPass + add;
		}
		
		return genPass;
	}

}	

