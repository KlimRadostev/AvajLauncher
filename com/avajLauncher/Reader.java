package com.avajLauncher;

import java.io.*;

public class Reader
{
	public static void main(String [] args) throws Exception
		{
			try {
				PrintStream fileOut = new PrintStream("Simulations.txt");
				System.setOut(fileOut);
				
				File inFile = null;
				if (args.length == 1)
					inFile = new File(args[0]);
				else
					throw new CustomException("Invalid arguments count");
				
				BufferedReader br = null;
				String sCurrentLine;
				br = new BufferedReader(new FileReader(inFile));
				
				//////////////////// all non parse related
				int first = 1;
				int cycles = 0;
				AircraftFactory AircraftFactory = new AircraftFactory();
				WeatherTower WeatherTower = new WeatherTower();
				////////////////////
				
				while ((sCurrentLine = br.readLine()) != null)
				{
					String split[] = sCurrentLine.split(" ");
					if (first == 1)
					{
						if (split.length != 1)
							throw new CustomException("wrong number of parameters");
						cycles = Integer.parseInt(split[0]);
						first = 0;
					}
					else
					{
						if (split.length != 5)
							throw new CustomException("wrong number of parameters");
						AircraftFactory.newAircraft(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4])).registerTower(WeatherTower);
					}
				}
				for (int i = 0; i < cycles; i++)
					WeatherTower.changeWeather();
			}
			catch (Exception e) {
				System.err.println(e);
			}
		}
}