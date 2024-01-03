package com.loganpeach.WeatherApplication;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WeatherApplicationFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LocatorInterfaceV2 locatorInterface = new LocatorInterfaceV2();
	private CurrentWeatherInterface currentWeatherInterface;
	
	private JPanel previousScreen;
	
	public WeatherApplicationFrame() {
		setTitle("Weather");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(900, 700));
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		add(locatorInterface);
		locatorInterface.selectButton.addActionListener(this);
	}
	
	public void openCurrentWeatherInterface(JPanel currentScreen) {
		previousScreen = currentScreen;
		currentScreen.setVisible(false);
		remove(currentScreen);
		currentWeatherInterface = new CurrentWeatherInterface(getLat(), getLon());
		currentWeatherInterface.setVisible(true);
		add(currentWeatherInterface);
		currentWeatherInterface.backButton.addActionListener(this);
	}
	
	
	
	
	
	public void returnToLocatorInterface(JPanel currentScreen) {
		previousScreen = currentScreen;
		currentScreen.setVisible(false);
		remove(currentScreen);
		locatorInterface.setVisible(true);
		add(locatorInterface);
	}
	
	public String getLat() {
		return locatorInterface.latGetter();
	}
	public String getLon() {
		return locatorInterface.lonGetter();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object selected = e.getSource();
		if((selected.equals(locatorInterface.selectButton) && locatorInterface.typeSelector.getSelectedItem().equals("Current")) && locatorInterface.locationDropDown.getSelectedItem() != null) {
			openCurrentWeatherInterface(locatorInterface);
		}
		if(selected.equals(currentWeatherInterface.backButton)) {
			returnToLocatorInterface(currentWeatherInterface);
		}
		
	}
}

