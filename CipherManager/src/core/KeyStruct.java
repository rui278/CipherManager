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
