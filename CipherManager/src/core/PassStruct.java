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
