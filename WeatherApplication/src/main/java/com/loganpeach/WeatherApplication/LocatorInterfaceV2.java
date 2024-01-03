package com.loganpeach.WeatherApplication;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import kong.unirest.UnirestException;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;

public class LocatorInterfaceV2 extends JPanel {
	private Locator locator = new Locator();
	private JTextField locationField;
	protected JComboBox<String> locationDropDown = new JComboBox<String>();
	protected JComboBox<String> typeSelector = new JComboBox<String>();
	protected JButton selectButton = new JButton("Select");
	/**
	 * Create the panel.
	 */
	public LocatorInterfaceV2() {
		setLayout(null);
		Image background = new ImageIcon(this.getClass().getResource("/skybackground.png")).getImage();
		JButton okButton = new JButton("OK");
		okButton.setBounds(400, 206, 89, 23);
		add(okButton);
		
		JLabel enterLocationLabel = new JLabel("Enter Location");
		enterLocationLabel.setFont(new Font("Tahoma", Font.PLAIN, 31));
		enterLocationLabel.setBounds(350, 80, 194, 67);
		add(enterLocationLabel);
		
		locationField = new JTextField();
		locationField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		locationField.setBounds(251, 143, 389, 52);
		add(locationField);
		locationField.setColumns(10);
		
		//JComboBox locationDropDown = new JComboBox();
		locationDropDown.setBounds(150, 300, 600, 60);
		add(locationDropDown);
		
		//JButton selectButton = new JButton("Select");
		
		selectButton.setBounds(400, 426, 89, 23);
		add(selectButton);
		
		//JComboBox typeSelector = new JComboBox();
		typeSelector.setBounds(400, 371, 89, 44);
		add(typeSelector);
		JLabel backgroundLbl = new JLabel("New label");
		backgroundLbl.setIcon(new ImageIcon(background));
		backgroundLbl.setBounds(0, 0, 900, 700);
		add(backgroundLbl);
		typeSelector.addItem("Current");
		typeSelector.addItem("Minutely");
		typeSelector.addItem("Hourly");
		typeSelector.addItem("Daily");
		
		//Action Listeners
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locationDropDown.removeAllItems();
				try {
					if(locator.locate(locationField.getText()).length() <= 3) {
						locationField.setText("Please enter a valid location");			
					}
					else {
						try {
							ArrayList<String> locationsList = new ArrayList<String>();
							locationsList = locator.locationSplitter();
							for(int i = 0; i < locationsList.size(); i++) {
								locationDropDown.addItem(locationsList.get(i));
							}
						} catch (UnirestException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						}
					}
				} catch (UnirestException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//
	}
	public String latGetter() {
		String lat = (String) locationDropDown.getSelectedItem();
		lat = lat.replaceAll(".*lat : ", "");
		lat = lat.replaceAll(" ,.*W", "");
		lat = lat.replaceAll(" ,.*E", "");
		lat = lat.replaceAll(" ", "");
		return lat;
		
	}
	public String lonGetter() {
		String lon = (String) locationDropDown.getSelectedItem();
		lon = lon.replaceAll(".*lon : ", "");
		lon = lon.replaceAll(" ", "");
		return lon;
		
	}
}
