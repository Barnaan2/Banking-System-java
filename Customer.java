

/*
This is Demo System Of Banking System Written In Java 
   By :-  Bernabas Tekklign;
  Gitub User Name:-  ----- "Barnaan2"
  Email Address  ------ "BarnaanTekalign@gmail.com"
   " CopyRight--- feel free to use it for any purpose"

*/
import java.io.Serializable;
public class Customer extends Bank implements Serializable{
	static final long  serialVersionUID = 4L;
	private double balance;
	private int account_creator;

	//setters
	public void set_balance(double balance) {
		this.balance = balance;
	}
	public void set_account_creator(int id) {
		this.account_creator = id;
	}

	// getters
	double get_balance() {
		return balance;
	}
	int  account_creator() {
		return account_creator;
	}

}
