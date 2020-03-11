package com.avajLauncher;

public class JetPlane extends Aircraft implements Flyable
{
	private WeatherTower weatherTower = null;

	JetPlane(String name, Coordinates coordinates)
		{
			super(name, coordinates);
		}

	public void updateConditions()
		{
			String weather = weatherTower.getWeather(this.coordinates);

			System.out.print("JetPlane#" + this.name + "(" + this.id + "): ");
			if (weather.equals("SUN"))
			{
				System.out.println("I'm hot af");
				this.coordinates.changeLatitude(10);
				this.coordinates.changeHeight(2);
			}
			else if (weather.equals("RAIN"))
			{
				System.out.println("Make it RAIIIIN, Make it RAINNN DOWN LOW");
				this.coordinates.changeLatitude(5);
			}
			else if (weather.equals("FOG"))
			{
				System.out.println("Nothing sinister ovah hea");
				this.coordinates.changeLatitude(1);
			}
			else if (weather.equals("SNOW"))
			{
				System.out.println("I thought winter was long over :/");
				this.coordinates.changeHeight(-7);
			}
			if (this.coordinates.getHeight() <= 0)
			{
				System.out.println("JetPlane#" + this.name + "(" + this.id + ") " + "landing.");
				System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
				this.weatherTower.unregister(this);
			}
		}

	public void registerTower(WeatherTower Tower)
		{
			this.weatherTower = Tower;
			Tower.register(this);
			System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower");
		}
}