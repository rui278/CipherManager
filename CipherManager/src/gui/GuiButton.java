package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import core.Action;
import core.KeyStruct;

public class GuiButton extends JButton implements ActionListener {

	private int buttonID;
	private KeyStruct key;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GuiButton(String title, KeyStruct struct, int action){
		super(title);
		
		this.setPreferredSize(new Dimension(213, 35));
		
		this.buttonID = action;
		this.key = struct;
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GuiButton.this.actionPerformed(e);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		System.out.print("Hello World\n");

		Action action; 
				
		switch(buttonID){
			case 1: action = new Action(key, 1);
					break;
			case 2: action = new Action(key, 2);
					break;
			case 3: action = new Action(key, 3);
					break;
			case 4: action = new Action(key, 4);
					break;
			case 5: action = new Action(key, 5);
					break;
			case 6: action = new Action(key, 6);
					break;
			case 7: action = new Action(key, 7);
					break;
			case 8:	action = new Action(key, 8);
					break;
			default: action = new Action(key, 0); 
		}
		
		Thread actionThread = new Thread(action);
		
		actionThread.start();
		
		return;
		
	}

}
