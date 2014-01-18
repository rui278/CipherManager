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