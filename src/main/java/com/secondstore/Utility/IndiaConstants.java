package com.secondstore.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndiaConstants {

	public final static String india = "india";

	// 29 states
	public final static Map<String, String> mapOfindiaStates = new HashMap<String, String>() {
		{
			put("AP", "Andhra Pradesh");
			put("AR", "Arunachal Pradesh");
			put("AS", "Assam");
			put("BR", "Bihar");
			put("CG", "Chhattisgarh");
			put("GA", "Goa");
			put("GJ", "Gujarat");
			put("HR", "Haryana");
			put("HP", "Himachal Pradesh");
			put("JH", "Jharkhand");
			put("KA", "Karnataka");
			put("KL", "Kerala");
			put("MP", "Madhya Pradesh");
			put("MH", "Maharashtra");
			put("MN", "Manipur");
			put("ML", "Meghalaya");
			put("MZ", "Mizoram");
			put("NL", "Nagaland");
			put("OD", "Odisha");
			put("PB", "Punjab");
			put("RJ", "Rajasthan");
			put("SK", "Sikkim");
			put("TN", "Tamil Nadu");
			put("TS", "Telangana");
			put("TR", "Tripura");
			put("UP", "Uttar Pradesh");
			put("UK", "Uttarakhand");
			put("WB", "West Bengal");
			put("AN", "Andaman and Nicobar Islands");
			put("CH", "Chandigarh");
			put("DD", "Daman and Diu");
			put("DN", "Dadara and Nagar Haveli");
			put("DL", "Delhi");
			put("JK", "Jammu and Kashmir");
			put("LA", "Ladakh");
			put("LD", "Lakshadweep");
			put("PY", "Puducherry");
			
		}
	};
	public final static List<String> listOfindiaStatesCode = new ArrayList<>(mapOfindiaStates.keySet());
	public final static List<String> listOfindiaStatesName = new ArrayList<>(mapOfindiaStates.values());
}
