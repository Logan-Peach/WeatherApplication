package com.loganpeach.WeatherApplication;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class CurrentWeather {
	private String weatherInfo, icon, iconNum, summary, temperature, feelsLike, windChill, dewPoint, windSpeed, windGusts, windAngle, windDirection, precipitationTotal, precipitationType,
	cloudCover, ozone, pressure, uvIndex, humidity, visibility;
	
	public CurrentWeather(String lat, String lon) {
		HttpResponse<String> response = Unirest.get("https://ai-weather-by-meteosource.p.rapidapi.com/current?lat="+lat+"&lon="+lon+"&timezone=auto&language=en&units=ca")
				.header("X-RapidAPI-Key", "0318f3171fmsh7058cd15338a03fp19ab59jsna124e5342cab")
				.header("X-RapidAPI-Host", "ai-weather-by-meteosource.p.rapidapi.com")
				.asString();
		weatherInfo = response.getBody();
		System.out.println(response.getBody());
		
	}
	public String getWeatherInfo() {
		return weatherInfo;
	}
	public String getIcon() {
		icon = weatherInfo.replaceAll(".*icon\":\"", "");
		icon = icon.replaceAll("\".*", "");
		return icon;
	}
	public String getIconNum() {
		iconNum = weatherInfo.replaceAll(".*icon_num\":", "");
		iconNum = iconNum.replaceAll(",.*", "");
		//iconNum = iconNum.replaceAll(" ", "");
		return iconNum;
	}
	public String getSummary() {
		summary = weatherInfo.replaceAll(".*summary\":\"", "");
		summary = summary.replaceAll("\".*", "");
		return summary;
	}
	public String getTemp() {
		temperature = weatherInfo.replaceAll(".*temperature\":", "");
		temperature = temperature.replaceAll(",.*", "");
		return temperature;
	}
	public String getFeelsLike() {
		feelsLike = weatherInfo.replaceAll(".*feels_like\":", "");
		feelsLike = feelsLike.replaceAll(",.*", "");
		return feelsLike;
	}
	public String getWindChill() {
		windChill = weatherInfo.replaceAll(".*wind_chill\":", "");
		windChill = windChill.replaceAll(",.*", "");
		return windChill;
	}
	public String getDewPoint() {
		dewPoint = weatherInfo.replaceAll(".*dew_point\":", "");
		dewPoint = dewPoint.replaceAll(",.*", "");
		return dewPoint;
	}
	public String getWindSpeed() {
		windSpeed = weatherInfo.replaceAll(".*speed\":", "");
		windSpeed = windSpeed.replaceAll(",.*", "");
		return windSpeed;
	}
	public String getWindGusts() {
		windGusts = weatherInfo.replaceAll(".*gusts\":", "");
		windGusts = windGusts.replaceAll(",.*", "");
		return windGusts;
	}
	public String getWindAngle() {
		windAngle = weatherInfo.replaceAll(".*angle\":", "");
		windAngle = windAngle.replaceAll(",.*", "");
		return windAngle;
	}
	public String getWindDirection() {
		windDirection = weatherInfo.replaceAll(".*dir\":\"", "");
		windDirection = windDirection.replaceAll("\".*", "");
		return windDirection;
	}
	public String getPrecipitationTotal() {
		precipitationTotal = weatherInfo.replaceAll(".*total\":", "");
		precipitationTotal = precipitationTotal.replaceAll(",.*", "");
		return precipitationTotal;
	}
	public String getPrecipitationType() {
		precipitationType = weatherInfo.replaceAll(".*type\":\"", "");
		precipitationType = precipitationType.replaceAll("\".*", "");
		return precipitationType;
	}
	public String getCloudCover() {
		cloudCover = weatherInfo.replaceAll(".*cloud_cover\":", "");
		cloudCover = cloudCover.replaceAll(",.*", "");
		return cloudCover;
	}
	public String getOzone() {
		ozone = weatherInfo.replaceAll(".*ozone\";", "");
		ozone = ozone.replaceAll(",.*", "");
		return ozone;
	}
	public String getPressure() {
		pressure = weatherInfo.replaceAll(".*pressure\":", "");
		pressure = pressure.replaceAll(",.*", "");
		return pressure;
	}
	public String getUvIndex() {
		uvIndex = weatherInfo.replaceAll(".*uv_index\":", "");
		uvIndex = uvIndex.replaceAll(",.*", "");
		return uvIndex;
	}
	public String getHumidity() {
		humidity = weatherInfo.replaceAll(".*humidity\":", "");
		humidity = humidity.replaceAll(",.*", "");
		return humidity;
	}
	public String getVisibility() {
		visibility = weatherInfo.replaceAll(".*visibility\":", "");
		visibility = visibility.replaceAll("}.*", "");
		return visibility;
	}
	
	
}
