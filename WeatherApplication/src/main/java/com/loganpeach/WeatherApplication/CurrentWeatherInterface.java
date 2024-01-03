package com.loganpeach.WeatherApplication;

import javax.swing.JPanel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Canvas;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CurrentWeatherInterface extends JPanel {
	private JLabel weatherLbl;
	private String clat, clon;
	private CurrentWeather currentWeather;
	public JButton backButton;
	/**
	 * Create the panel.
	 */
	public CurrentWeatherInterface(String lat, String lon) {
		//
		setLayout(null);
		Image background = new ImageIcon(this.getClass().getResource("/skybackground.png")).getImage();
		clat = lat;
		clon = lon;
		currentWeather = new CurrentWeather(clat, clon);
		weatherLbl = new JLabel();
		weatherLbl.setText(currentWeather.getWeatherInfo());
		weatherLbl.setBounds(313, 542, 508, 39);

		
		//Weather Icons
		Image sun = new ImageIcon(this.getClass().getResource("/sun.png")).getImage();
		Image cloudysun = new ImageIcon(this.getClass().getResource("/cloudysun.png")).getImage();
		Image cloud = new ImageIcon(this.getClass().getResource("/cloud.png")).getImage();
		Image moon = new ImageIcon(this.getClass().getResource("/moon.png")).getImage();
		Image cloudymoon = new ImageIcon(this.getClass().getResource("/cloudymoon.png")).getImage();
		Image lightning = new ImageIcon(this.getClass().getResource("/lightning.png")).getImage();
		Image heavyrain = new ImageIcon(this.getClass().getResource("/heavyrain.png")).getImage();
		Image lightrain = new ImageIcon(this.getClass().getResource("/lightrain.png")).getImage();
		Image rain = new ImageIcon(this.getClass().getResource("/rain.png")).getImage();
		Image hail = new ImageIcon(this.getClass().getResource("/hail.png")).getImage();
		Image heavysnow = new ImageIcon(this.getClass().getResource("/heavysnow.png")).getImage();
		Image lightsnow = new ImageIcon(this.getClass().getResource("/lightsnow.png")).getImage();
		Image snow = new ImageIcon(this.getClass().getResource("/snow.png")).getImage();
		JLabel weatherIcon = new JLabel();
		weatherIcon.setText("icon");
		if(currentWeather.getIcon().equals("1")) {
			weatherIcon.setText("No Image Available");
		}
		if(currentWeather.getIconNum().equals("2")) {
			weatherIcon.setIcon(new ImageIcon(sun));
		}
		if(currentWeather.getIconNum().equals("3") || currentWeather.getIconNum().equals("4")) {
			weatherIcon.setIcon(new ImageIcon(cloudysun));
		}
		if(currentWeather.getIconNum().equals("5") || currentWeather.getIconNum().equals("6") || currentWeather.getIconNum().equals("7") || currentWeather.getIconNum().equals("8")) {
			weatherIcon.setIcon(new ImageIcon(cloud));
		}
		if(currentWeather.getIconNum().equals("9")) {
			weatherIcon.setText("fog");
		}
		if(currentWeather.getIconNum().equals("10")) {
			weatherIcon.setIcon(new ImageIcon(lightrain));
		}
		if(currentWeather.getIconNum().equals("11") || currentWeather.getIconNum().equals("12")) {
			weatherIcon.setIcon(new ImageIcon(rain));
		}
		if(currentWeather.getIconNum().equals("13") || currentWeather.getIconNum().equals("32")) {
			weatherIcon.setIcon(new ImageIcon(heavyrain));
		}
		if(currentWeather.getIconNum().equals("14") || currentWeather.getIconNum().equals("15") || currentWeather.getIconNum().equals("33")) {
			weatherIcon.setIcon(new ImageIcon(lightning));
		}
		if(currentWeather.getIconNum().equals("16")) {
			weatherIcon.setIcon(new ImageIcon(lightsnow));
		}
		if(currentWeather.getIconNum().equals("17") || currentWeather.getIconNum().equals("18")) {
			weatherIcon.setIcon(new ImageIcon(snow));
		}
		if(currentWeather.getIconNum().equals("19") || currentWeather.getIconNum().equals("34")) {
			weatherIcon.setIcon(new ImageIcon(heavysnow));
		}
		if(currentWeather.getIconNum().equals("20") || currentWeather.getIconNum().equals("21") || currentWeather.getIconNum().equals("22") || currentWeather.getIconNum().equals("23") || currentWeather.getIconNum().equals("24") || currentWeather.getIconNum().equals("25") || currentWeather.getIconNum().equals("35") || currentWeather.getIconNum().equals("36")) {
			weatherIcon.setIcon(new ImageIcon(hail));
		}
		if(currentWeather.getIconNum().equals("26")) {
			weatherIcon.setIcon(new ImageIcon(moon));
		}
		if(currentWeather.getIconNum().equals("27") || currentWeather.getIconNum().equals("28")) {
			weatherIcon.setIcon(new ImageIcon(cloudymoon));
		}
		if(currentWeather.getIconNum().equals("29") || currentWeather.getIconNum().equals("30") || currentWeather.getIconNum().equals("31")) {
			weatherIcon.setIcon(new ImageIcon(cloud));
		}
		weatherIcon.setBounds(40, 150, 50, 50);
		add(weatherIcon);
		
		backButton = new JButton("Back");
		backButton.setBounds(0, 0, 89, 23);
		add(backButton);
		
		JLabel tempLabel = new JLabel("Temperature: " + currentWeather.getTemp());
		tempLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 25));
		tempLabel.setBounds(236, 120, 216, 37);
		add(tempLabel);
		
		JLabel summaryLabel = new JLabel(currentWeather.getSummary());
		summaryLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		summaryLabel.setBounds(40, 200, 150, 37);
		add(summaryLabel);
		
		JLabel feelsLikeLabel = new JLabel("Feels like: " + currentWeather.getFeelsLike());
		feelsLikeLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 25));
		feelsLikeLabel.setBounds(236, 168, 216, 37);
		add(feelsLikeLabel);
		
		JLabel windChillLabel = new JLabel("Wind chill: " + currentWeather.getWindChill());
		windChillLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 25));
		windChillLabel.setBounds(236, 216, 216, 37);
		add(windChillLabel);
		
		JLabel windSpeedLabel = new JLabel("Wind speed: " + currentWeather.getWindSpeed());
		windSpeedLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 25));
		windSpeedLabel.setBounds(497, 120, 216, 37);
		add(windSpeedLabel);
		
		JLabel windGustsLabel = new JLabel("Wind gusts: " + currentWeather.getWindGusts());
		windGustsLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 25));
		windGustsLabel.setBounds(497, 168, 216, 37);
		add(windGustsLabel);
		
		JLabel windAngleLabel = new JLabel("Wind angle: " + currentWeather.getWindAngle());
		windAngleLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 25));
		windAngleLabel.setBounds(497, 216, 216, 37);
		add(windAngleLabel);
		
		JLabel windDirectionLabel = new JLabel("Wind direction: " + currentWeather.getWindDirection());
		windDirectionLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 25));
		windDirectionLabel.setBounds(497, 264, 403, 37);
		add(windDirectionLabel);
		
		JLabel precipitationTypeLabel = new JLabel("Precipitation type: " + currentWeather.getPrecipitationType());
		precipitationTypeLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 25));
		precipitationTypeLabel.setBounds(109, 392, 343, 37);
		add(precipitationTypeLabel);
		
		JLabel precipitationTotalLabel = new JLabel("Precipitation total: " + currentWeather.getPrecipitationTotal());
		precipitationTotalLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 25));
		precipitationTotalLabel.setBounds(109, 440, 343, 37);
		add(precipitationTotalLabel);
		
		JLabel uvIndexLabel = new JLabel("UV Index: " + currentWeather.getUvIndex());
		uvIndexLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 25));
		uvIndexLabel.setBounds(497, 392, 216, 37);
		add(uvIndexLabel);
		
		JLabel cloudCoverLabel = new JLabel("Cloud cover: " + currentWeather.getCloudCover());
		cloudCoverLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 25));
		cloudCoverLabel.setBounds(497, 440, 216, 37);
		add(cloudCoverLabel);
		//Background
		JLabel backgroundLbl = new JLabel("New label");
		backgroundLbl.setIcon(new ImageIcon(background));
		backgroundLbl.setBounds(0, 0, 900, 700);
		add(backgroundLbl);
		
	}
}
