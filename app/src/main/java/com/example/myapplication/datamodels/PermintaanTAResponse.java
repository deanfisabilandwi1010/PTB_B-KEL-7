package com.example.myapplication.datamodels;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PermintaanTAResponse{

	@SerializedName("thesis")
	private List<ThesisItem> thesis;

	@SerializedName("count")
	private int count;

	@SerializedName("status")
	private String status;

	public List<ThesisItem> getThesis(){
		return thesis;
	}

	public int getCount(){
		return count;
	}

	public String getStatus(){
		return status;
	}
}