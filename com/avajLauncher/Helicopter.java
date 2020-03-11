package com.avajLauncher;

public class Helicopter extends Aircraft implements Flyable
{
	private WeatherTower weatherTower = null;

	Helicopter(String name, Coordinates coordinates)
		{
			super(name, coordinates);
		}

	public void updateConditions()
		{
			String weather = weatherTower.getWeather(this.coordinates);

			System.out.print("Helicopter#" + this.name + "(" + this.id + "): ");
			if (weather.equals("SUN"))
			{
				System.out.println("thank god I have good ventilation :)");
				this.coordinates.changeLongitude(10);
				this.coordinates.changeHeight(2);
			}
			else if (weather.equals("RAIN"))
			{
				System.out.println("the rain doesnt affect me...");
				this.coordinates.changeLongitude(5);
			}
			else if (weather.equals("FOG"))
			{
				System.out.println("Houston we got a problem here");
				this.coordinates.changeLongitude(1);
			}
			else if (weather.equals("SNOW"))
			{
				System.out.println("Snow is not the most optimal condition to be fair");
				this.coordinates.changeHeight(-12);
			}
			if (this.coordinates.getHeight() <= 0)
			{
				System.out.println("Helicopter#" + this.name + "(" + this.id + ") " + "landing.");
				System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");
				this.weatherTower.unregister(this);
			}
		}

	public void registerTower(WeatherTower Tower)
		{
			this.weatherTower = Tower;
			Tower.register(this);
			System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower");
		}
}