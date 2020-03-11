package com.avajLauncher;

import java.io.*;

public class AircraftFactory
{
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception
		{
			Coordinates coordinates = new Coordinates(longitude, latitude, height);
			type = type.toLowerCase();

			if (type.equals("helicopter"))
				return new Helicopter(name, coordinates);
			else if (type.equals("jetplane"))
				return new JetPlane(name, coordinates);
			else if (type.equals("baloon"))
				return new Baloon(name, coordinates);
			else
				throw new CustomException("parameter has to be Helicopter, JetPlane or Baloon");
		}
}