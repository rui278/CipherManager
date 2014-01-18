package core;

public class PassStruct {
	
	private String beforePass;
	private String afterPass;
	private String beforeService;
	private String afterService;
	
	PassStruct(){
	}
	
	PassStruct(PassStruct pass, String service, String password){
		this.afterPass = pass.getAfterPass();
		this.afterService = pass.getAfterService();
		this.beforePass = password;
		this.beforeService = service;
	}
	
	/***** beforePass Getter & Setter *******/

	protected String getBeforePass() {
		return beforePass;
	}

	protected void setBeforePass(String beforePass) {
		this.beforePass = beforePass;
	}

	/***** afterPass Getter & Setter ********/
	
	protected String getAfterPass() {
		return afterPass;
	}
	
	protected void setAfterPass(String afterPass) {
		this.afterPass = afterPass;
	}

	/***** beforeService Getter & Setter *****/
		
	protected String getBeforeService() {
		return beforeService;
	}

	protected void setBeforeService(String beforeService) {
		this.beforeService = beforeService;
	}
	
	/***** afterService Getter & Setter *****/	

	protected String getAfterService() {
		return afterService;
	}

	public void setAfterService(String afterService) {
		this.afterService = afterService;
	}
	
}
