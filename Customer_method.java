
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
/*
This is Demo System Of Banking System Written In Java 
   By :-  Bernabas Tekklign;
  Gitub User Name:-  ----- "Barnaan2"
  Email Address  ------ "BarnaanTekalign@gmail.com"
   " CopyRight--- use it for any purpose you need"

*/
public class Customer_method {
	// any thing can customer do comes here.
	static Customer obj = new Customer();
	static Banker_method back = new Banker_method();
	static Scanner forIteration = new Scanner(System.in);
	static int Num = 0;
	
	
	public static Customer getObject(int id) {
		Customer object = new Customer();
		String filename = Methods.getFileName(id);
		object =deserialize(filename);
		return object;
	}


	public static  Customer  deserialize(String fileName){
		Customer object = new Customer();
		try{ File files =  new File(fileName);
		FileInputStream output;
		output = new FileInputStream(files);
		ObjectInputStream input;
		input = new ObjectInputStream(output);
		object = (Customer) input.readObject();
		input.close();
		}

		catch(Exception e) {
			System.out.println(e.getMessage()); }
		return object; }


	// withdraw 
	public void withdraw(int id, double amount)throws Exception {
		String check = Methods.getFileName(id);
		if(check == null) {
			throw new Exception("Account Number does Not Exist! try again");
		} else {

			obj = getObject(id);
			double balance =obj.get_balance();
			double leftBalance = balance - amount;
			double minimumAllowedBalance = Admin_method.minimumAllowedBalance;
			if(leftBalance < minimumAllowedBalance) {
				throw new Exception("your balance is lower the set limit! please try lower amount");
			}
			else {
				balance =leftBalance;
				obj.set_balance(balance);
				Methods.saveChanges(id, obj);
			
				if(Num == 0) {
					System.out.println("Operation was  sucessfully ");
					back.serveCustomer(forIteration);
				}
			     Num = 0;
			}
		}
	}
// deposit
	public void deposit(int id ,double amount)throws Exception
	{
		String check = Methods.getFileName(id);
		if(check == null) {
			throw new Exception("Account Number does Not Exist! try again");
		} else {
			Customer obj = new Customer();
			obj = getObject(id);
			double balance =obj.get_balance();
			double newBalance = balance + amount;
		     
			if(amount <= 0) {
				throw new Exception("your amount to deposit is less than the set limit! please try lower amount");
			}
			else {
				balance =newBalance;
				obj.set_balance(balance);
				Methods.saveChanges(id, obj);
				System.out.println("Operation was  sucessfully ");
				   back.serveCustomer(forIteration);
				
			}}
		}
	public void checkBalance(int id)throws Exception {
		String check = Methods.getFileName(id);
		if(check == null) {
			throw new Exception("Account Number does Not Exist! try again");
		}
		else {
			obj = getObject(id);
			System.out.println("Balance is "+ obj.get_balance());
			 back.serveCustomer(forIteration);
		}
	}
	
	public void transfer(int senderId, int receivId,double amount) throws Exception {
		try
		{
		String checkSender = Methods.getFileName(senderId);
		String checkReceiver = Methods.getFileName(receivId);
		if(checkSender == null) {
			throw new Exception("Sender Account Number does Not Exist! try again");
		}
		else if(checkReceiver == null) {
			throw new Exception(" Reciever Account Number Does Not Exist! try again");
		}
		
		else { Num ++;
			withdraw(senderId,amount);
			Customer obji = new Customer();
			obji = getObject(receivId);
			 double balance = obji.get_balance();
			 double newBalance = amount + balance;
			 obji.set_balance(newBalance);
		    Methods.saveChanges(receivId,obji);
		    System.out.println("Operation Completed");
		    back.serveCustomer(forIteration);
		}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			Scanner Input = new Scanner(System.in);
	        back.serveCustomer(Input);
		}
	}
	}
