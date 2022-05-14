

import java.io.Serializable;
/*
This is Demo System Of Banking System Written In Java 
   By :-  Bernabas Tekklign;
  Gitub User Name:-  ----- "Barnaan2"
  Email Address  ------ "BarnaanTekalign@gmail.com"
   " CopyRight--- feel free to use it for any purpose"

*/
public class Banker extends Bank implements Serializable {
	static final long  serialVersionUID = 3L;
	private String position;
	private String qualification;
	private double salary; 
	private double balance = 0.0;
	private String password;

	// setter methods 
	public void set_position(String position) {
		this.position=position;
	} 

	public void set_qualification(String qual) {
		this.qualification = qual;
	}

	public void set_salary(double sal) {
		this.salary = sal;
	}
	public void set_balance(double bal) {
		this.balance = bal;
	}
	
	public void set_password(String Password){
		this.password = Password;
	}

	//  getter methods
	String get_position() {
		return position;
	}
	String get_qualification() {
		return qualification;
	}
	double get_salary() {
		return salary;
	}
	double get_balance() {
		return balance;
	}

	String get_password() {
		return password;
	}
	// like accountant,sales and manager;
}
