package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.domain.People;

public class Data {
	public static ArrayList<People> getPeopleDTO(){
		
		ArrayList<People> list=new ArrayList<People>();
		list.add(new People("정수열",24));
		list.add(new People("김현정",25));
		list.add(new People("에바",26));
		
		return list;
		
	}
	public static HashMap<String, String> getMapDatas(){
		HashMap<String, String> datas =new HashMap<String,String>();
		datas.put("m1", "영석");
		datas.put("m2", "진선");
		
		return datas;

	}
}
