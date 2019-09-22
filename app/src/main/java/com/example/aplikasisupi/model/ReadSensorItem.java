package com.example.aplikasisupi.model;

import com.google.gson.annotations.SerializedName;

public class ReadSensorItem{

	@SerializedName("kondisi")
	private String kondisi;

	@SerializedName("waktu")
	private String waktu;

	@SerializedName("suhu")
	private String suhu;

	@SerializedName("id")
	private String id;

	@SerializedName("tanggal")
	private String tanggal;

	public void setKondisi(String kondisi){
		this.kondisi = kondisi;
	}

	public String getKondisi(){
		return kondisi;
	}

	public void setWaktu(String waktu){
		this.waktu = waktu;
	}

	public String getWaktu(){
		return waktu;
	}

	public void setSuhu(String suhu){
		this.suhu = suhu;
	}

	public String getSuhu(){
		return suhu;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}
}