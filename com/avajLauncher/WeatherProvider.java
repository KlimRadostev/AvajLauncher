package com.avajLauncher;

public class WeatherProvider
{
	private static WeatherProvider WeatherProvider = null;
	private static final String Weather[] = {"SUN", "RAIN", "FOG", "SNOW"};

	private WeatherProvider() {}

	static public WeatherProvider getProvider()
		{
			if (WeatherProvider == null) {
				WeatherProvider = new WeatherProvider();
			}
			return WeatherProvider;
		}

	public String getCurrentWeather(Coordinates coordinates)
		{
			int	rand = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
			return Weather[rand];
		}
}
