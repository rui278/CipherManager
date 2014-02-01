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
package gui;

import javax.swing.JFrame;

import core.FileManager;

public class mainClass {

	public static FileManager file;
	
	public static void main(String[] args) {
		
		// TODO GUI - Show All button, import CSV
		// TODO Core
		
		file = new FileManager();
		
		JFrame frame = new GuiMain("Cipher Password Manager");

		frame.setSize(225,150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// TODO create file class, call check&create Method
	}

}