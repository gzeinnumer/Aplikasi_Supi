package com.example.aplikasisupi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseGetData{

	@SerializedName("read_sensor")
	private List<ReadSensorItem> readSensor;

	@SerializedName("kode")
	private int kode;

	public void setReadSensor(List<ReadSensorItem> readSensor){
		this.readSensor = readSensor;
	}

	public List<ReadSensorItem> getReadSensor(){
		return readSensor;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}
}