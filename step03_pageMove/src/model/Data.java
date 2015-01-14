package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.domain.People;

public class Data {
	public static ArrayList<People> getPeopleDTO(){
		
		ArrayList<People> list=new ArrayList<People>();
		list.add(new People("������",24));
		list.add(new People("������",25));
		list.add(new People("����",26));
		
		return list;
		
	}
	public static HashMap<String, String> getMapDatas(){
		HashMap<String, String> datas =new HashMap<String,String>();
		datas.put("m1", "����");
		datas.put("m2", "����");
		
		return datas;

	}
}
