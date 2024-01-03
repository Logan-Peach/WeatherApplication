package com.loganpeach.WeatherApplication;

import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
public class Locator {
	private String lastResponse;
	private String[] locationsSetup;
	
	public String locate(String location) throws UnirestException, UnsupportedEncodingException {
		location = location.replaceAll(" ", "%20");
		HttpResponse<String> response = Unirest.get("https://ai-weather-by-meteosource.p.rapidapi.com/find_places?text="+location.toString()+"&language=en")
				.header("X-RapidAPI-Key", "0318f3171fmsh7058cd15338a03fp19ab59jsna124e5342cab")
				.header("X-RapidAPI-Host", "ai-weather-by-meteosource.p.rapidapi.com")
				.asString();
		lastResponse = response.getBody();
		return response.getBody();	
	}
	public int locationCount() {
		int count = 0;
		for (int i = 0; i < lastResponse.length(); i++) {
			if(lastResponse.charAt(i) == '}') {
				count++;
			}
		}
		return count;
	}
	public ArrayList<String> locationSplitter(){
		locationsSetup = lastResponse.split("}");
		ArrayList<String> locations = new ArrayList<String>(Arrays.asList(locationsSetup));
		locations.set(0, locations.get(0).replace("[", ""));
		for(int i = 0; i < locations.size(); i++) {
			if(i != 0) {
				locations.set(i, locations.get(i).replaceFirst(",", " "));
			}
			locations.set(i, locations.get(i).replace("{\"name\":", " "));
			locations.set(i, locations.get(i).replaceAll("\"place_id\".*\"adm_area1\":", " "));
			locations.set(i, locations.get(i).replaceAll("\"adm_area2\".*\"country\":", " "));
			locations.set(i, locations.get(i).replaceAll(",\"timezone\".*\"", " "));
			locations.set(i, locations.get(i).replaceAll("\"", " "));
			System.out.println(locations.get(i));
		}
		locations.remove(locations.size()-1);
		return locations;
		
	}
}
