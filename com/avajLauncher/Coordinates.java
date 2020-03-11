package com.avajLauncher;

import java.io.*;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	public Coordinates(int longitude, int latitude, int height) throws Exception
		{
			if (longitude < 0)
				throw new CustomException("can't have a negative longitude");
			if (latitude < 0)
				throw new CustomException("can't have a negative latitude");
			if (height > 100)
				height = 100;
			this.longitude = longitude;
			this.latitude = latitude;
			this.height = height;
		}

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}

	public void changeHeight(int h) {
		this.height = this.height + h;
		if (this.height > 100)
			this.height = 100;
	}

	public void changeLongitude(int lon) {
		this.longitude = this.longitude + lon;
		if (this.longitude < 0)
			this.longitude = 0;
	}

	public void changeLatitude(int lat) {
		this.latitude = this.latitude + lat;
		if (this.latitude < 0)
			this.latitude = 0;
	}
}