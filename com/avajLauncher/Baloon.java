package com.avajLauncher;

public class Baloon extends Aircraft implements Flyable
{
	private WeatherTower weatherTower = null;

	Baloon(String name, Coordinates coordinates)
		{
			super(name, coordinates);
		}

	public void updateConditions()
		{
			String weather = weatherTower.getWeather(this.coordinates);

			System.out.print("Baloon#" + this.name + "(" + this.id + "): ");
			if (weather.equals("SUN"))
			{
 				System.out.println("Let's go to the beach, lets go get away");
				this.coordinates.changeLongitude(2);
				this.coordinates.changeHeight(4);
			}
			else if (weather.equals("RAIN"))
			{
				System.out.println("Umbrella ella ellla ee ee eee");
				this.coordinates.changeHeight(-5);
			}
			else if (weather.equals("FOG"))
			{
				System.out.println("...............");
				this.coordinates.changeHeight(-3);
			}
			else if (weather.equals("SNOW"))
			{
				System.out.println("hot air baloon in the snow... who had this brilliant idea?");
				this.coordinates.changeHeight(-15);
			}
			if (this.coordinates.getHeight() <= 0)
			{
				System.out.println("Baloon#" + this.name + "(" + this.id + ") " + "landing.");
				System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
				this.weatherTower.unregister(this);
			}
		}

	public void registerTower(WeatherTower Tower)
		{
			this.weatherTower = Tower;
			Tower.register(this);
			System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower");
		}
}