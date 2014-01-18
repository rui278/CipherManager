package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class FileManager {
	
	BufferedReader br;
	File file;

	public FileManager(){
		
		String OS = System.getProperty("os.name");
		String path = "";
		
		if(OS.equals("Linux")){
			path = System.getProperty("user.home") + "/cipher/";
			
		} else if(OS.equals("Windows 8")){
			path = System.getProperty("user.home") + "\\cipher\\";
		} else if (OS.equals("OSX")){
			//TODO check os.name output is OSX
			//TODO check where to put file
		} else if (OS.equals("Android")){
			//TODO check os.name output is Android
			//TODO check where to put file
		}
		
		System.out.print(path);
		file = new File(path + "password.cpm");
		
		//Tries to open the password.cpm file, if catches FileNotFoundException it creates the file
		
		try {
			this.br = new BufferedReader(new FileReader(file));
		
		 } catch (FileNotFoundException e) {
			 
			 if(!file.getParentFile().exists())
	          {
	              file.getParentFile().mkdirs();
	          }
	          if(!file.exists())
	          {
	             
				 try {
					file.createNewFile();
					this.br = new BufferedReader(new FileReader(file));
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public PassStruct encrypt(KeyStruct key, String password) {
		
		PassStruct pass = new PassStruct();
		
		MessageDigest md;
		
		String masterKey = "";
		
		for(int i = 0; i < key.getMasterKey().length; i++){
			masterKey = masterKey + key.getMasterKey()[i]; 
		}
		
		
		try {
			md = MessageDigest.getInstance("SHA-256");
			System.out.print("MasterKey: " + masterKey + "\n");
			md.update(masterKey.getBytes());

	        byte byteData[] = md.digest();
	        
	        System.out.print("ByteData: "+ byteData.toString() + "masterkey: " + masterKey);
	        
	        try {
				Cipher cipher = Cipher.getInstance("AES");
				SecretKeySpec k = new SecretKeySpec(byteData, "AES");
				
				try {
					cipher.init(Cipher.ENCRYPT_MODE, k);
					
					try {
					
						byte[] encryptedData = cipher.doFinal(password.getBytes());

						byte[] encryptedData2 = cipher.doFinal(key.getService().getBytes());
						
												
						System.out.print(encryptedData);
						System.out.print("\n");
						
						pass.setAfterPass(encryptedData.toString());
						pass.setAfterService(encryptedData2.toString());
						
						return pass;
					} catch (IllegalBlockSizeException e) {
						e.printStackTrace();
					} catch (BadPaddingException e) {
						e.printStackTrace();
					}
				} catch (InvalidKeyException e) {
					e.printStackTrace();
				}
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}		
        
		return null;
	}
}
