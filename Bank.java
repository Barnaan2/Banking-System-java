
/*
This is Demo System Of Banking System Written In Java 
   By :-  Bernabas Tekklign;
  Gitub User Name:-  ----- "Barnaan2"
  Email Address  ------ "BarnaanTekalign@gmail.com"
   " CopyRight--- You are free to use it for any purpose"
*/

import java.io.Serializable;
class Bank implements Serializable {
	static final long  serialVersionUID = 1L;
	public String Bank_name = " YA'I BANK S.C ";
	public String who_are_we = "YA'I SOFTWARE COMPANY";
	public String name;
	private int id;
	private int age;
	private String date_of_regstration;
	private String gender;
	private String branch;


	// these setter methods
	public void set_name(String name){
		this.name = name;
	}
	public void set_id(int id) {
		this.id = id;
	}
	public void set_age(int age){
		this.age = age;
	}
	public void set_gender(String gender){
		this.gender = gender;
	}
	public void set_date_of_regstration(String date_of_regstration){
		this.date_of_regstration = date_of_regstration;
	} 
	public void set_branch(String branch){
		this.branch = branch;
	}


	// getters for the the method
	int get_id(){
		return id; 
	}
	String get_name(){
		return name;  
	}
	int get_age(){
		return age;
	}
	String get_gender(){
		return gender;  
	}
	String get_date_of_regstration(){
		return date_of_regstration; 
	}
	String get_branch(){
		return branch;  
	}

}









