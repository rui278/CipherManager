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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import core.KeyStruct;


public class GuiMain extends JFrame implements ActionListener{
	
	
	BorderLayout bl = new BorderLayout();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GuiMain(String title){
		super(title);
		
		// Set Layout and position
		setLayout(bl);
		setLocationRelativeTo(null);
		
		// Create Swing Components
		final JTextField serviceField = new JTextField(10);
		final JPasswordField keyField = new JPasswordField(10);
		JLabel serviceLabel = new JLabel("Service: ");
		JLabel keyLabel = new JLabel("Key: ");
		JButton goBtn = new JButton("Next"); 
		
		getRootPane().setDefaultButton(goBtn);
		
		// Create Swing Panel to house Components
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridBagLayout());
		
		// Add Swing Components to pane
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		//First Column - First Row
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
	
		panel.add(serviceLabel, gc);
		
		//First Column - Second Row
		gc.gridx = 0;
		gc.gridy = 1;
		
		panel.add(keyLabel, gc);
		
		
		//Second Column - First Row
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		
		panel.add(serviceField, gc);
		
		//Second Column - Second Row
		gc.gridx = 1;
		gc.gridy = 1;
		
		panel.add(keyField, gc);
		
		
		//Third Row (Second Column)
		gc.weighty = 10;
		gc.weightx = 1;
		
		gc.gridx=1;
		gc.gridy=2;
		gc.anchor = GridBagConstraints.NORTH;

		panel.add(goBtn, gc);


		//Add Panel to JFrame
		add(panel, BorderLayout.WEST);

		
		goBtn.addActionListener(new ActionListener() {
			
			private String service;
			private char[] key; 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				service = serviceField.getText();
				key = keyField.getPassword();
				
				if((key.length == 0) || service.length() == 0){
					return;
				}
								
				KeyStruct masterKey = new KeyStruct(service, key);
				// TODO fazer isto funcionar multiplas vezes e fazendo update das coisas!
				setSize(450,400);
				
				JPanel optionsPanel = new JPanel();
				
				GuiMain.this.addOptionsPanel(optionsPanel,masterKey);
				
				return;
			}
		});
		
	}

	protected void addOptionsPanel(JPanel optionsPanel, KeyStruct masterKey) {
		
		//Creates all the button for the possible actions
		GuiButton getPswd = new GuiButton("Get Password", masterKey, 1);
		GuiButton createPswd = new GuiButton("Create Password", masterKey, 2);		
		GuiButton showPswd = new GuiButton("Show Password", masterKey, 3);
		GuiButton cAndgPswd = new GuiButton("Create & Get Password", masterKey, 4);
		GuiButton cAndsPswd = new GuiButton("Create & Show Password", masterKey, 5);
		GuiButton gAndsPswd = new GuiButton("Get & Show Password", masterKey, 6);
		GuiButton exportCsv = new GuiButton("Export to .csv file", masterKey, 7);
		GuiButton CustonAdd = new GuiButton("Add custom Password", masterKey, 8);
		
		//Sets new window size and optionsPanel layout
		optionsPanel.setPreferredSize(new Dimension (225,400));
		optionsPanel.setBorder(BorderFactory.createTitledBorder("Choose Option"));
		
		optionsPanel.setLayout(new GridBagLayout());		
		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx=1;
		gc.weighty=1;
		
		//Add getPassword Button
		gc.gridx = 0;
		gc.gridy = 0;
		
		optionsPanel.add(getPswd, gc);
		
		//Add createPassword Button
		gc.gridy = 1; 
		
		optionsPanel.add(createPswd, gc);
		
		//Add showPassword Button
		gc.gridy = 2;
		
		optionsPanel.add(showPswd, gc);
		
		//Add Create and Get Password Button
		gc.gridy = 3;
		
		optionsPanel.add(cAndgPswd, gc);

		//Add Create and Show Password Button
		gc.gridy = 4;
		
		optionsPanel.add(cAndsPswd, gc);
		
		//Add Get and Show Password Button
		gc.gridy = 5;
		
		optionsPanel.add(gAndsPswd, gc);
		
		//Add export csv button
		gc.gridy = 6;
		
		optionsPanel.add(exportCsv, gc);
		
		//Add custom Password Button
		gc.gridy = 7;
		
		//adds new buttons no optionsPanel
		optionsPanel.add(CustonAdd, gc);
		
		
		//Add OptionsPanel to Frame		
		this.add(optionsPanel,BorderLayout.EAST);
		
		return;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}	
	
