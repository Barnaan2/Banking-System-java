package Banking_System;
import java.util.Scanner;
/*
This is Demo System Of Banking System. Written In Java 
   By :-  Bernabas Tekklign;
  Gitub User Name------ "@Barnaan2"
  Email Address  ------ "BarnaanTekalign@gmail.com"
   " CopyRight--- feel free to use it for any purpose"

*/


// Interface for the user
class Home_page{

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
	    login(input);

	}

	//welcome
	public static int welcome (Scanner input){
		 Admin obj = new Admin();
		 obj = Admin_method.getObject(20001);
		 Banker obji = new Banker();
		 obji= Banker_method.getObject(30001);
		System.out.println(" Welcome to Barnaan2 Banking System:  ");
		System.out.println("          ");
		System.out.println("   Exit:                [0]");
		System.out.println("   Login As Admin:      [1]  ");
		System.out.println("   Login As Employee:   [2]");
		System.out.print(" Your Choice:  ");
		int login_choice = input.nextInt();
		System.out.println("");
		System.out.println("");
		System.out.println(" To start With the System -- Admin Id is =  20001 and Password is [" + obj.get_password()+"]");
		System.out.println(" To start With the System as Employee -- Employee Id is =  30001 and Password is [" + obji.get_password()+"]");
		System.out.println("  ");
		System.out.print(" Your Choice:  ");
		
		return login_choice;
	}


	public static  void login(Scanner insert){

		try{
			int num = welcome(insert);
			switch(num){
			case 0:
				System.exit(0);
				System.out.println(" You Exited  ");
				break;
			case 1:
				System.out.println("*************");
				adminValidate(insert);
				break;
			case 2:
				System.out.println("************");
				employeeValidate(insert);
				break;
			default:
				System.out.println("please select  [0]---[3]");
				login(insert);
				break;
			}}
		catch(Exception e){
			System.out.println("choose only number not a Spelling or onther chars");
			Scanner again = new Scanner(System.in);
			login(again);
		}

	}


	static int trial=0;
	static void adminValidate(Scanner insert)

	{// type 1 for Admin 2 for banker for customers

		int type = 1;
		System.out.println("Enter Your Administerator Id Number: ");
		System.out.print(" Your ID Number:  ");
		int Id  = insert.nextInt();
		if(Authenthicator(Id,type)){
			adminWelcome(insert,Id);
			
		}
		else{
			trial ++;
			if(trial >= 3) 
			{
				System.out.println("You Have Tried Three Times! Access Denied. ");
				System.exit(0);}
			System.out.println("Your ID number was incorrect please try again");
			System.out.println("Alert [--Id Number Format--] is 2000  ");
		   }
		  adminValidate(insert);
	}

	
	static void employeeValidate(Scanner insert)
	{int type = 2;
	System.out.println("Enter Your Employee Id Number");
	System.out.print(" Your ID Number:  ");
	int Id  = insert.nextInt();
	if(Authenthicator(Id,type)){
		employeeWelcome(insert,Id);
	}
	else{
		if(trial >= 3) 
		{
			System.out.println("You Have Tried Three Times! Access Denied. ");
			System.exit(0);
			}
		System.out.println("Your Id Number Is Incorret");
		System.out.println("Alert [--Id Number Format--] is 3000");
		employeeValidate(insert);
	}
	}


	static int  Trial = 0;
	static void adminWelcome(Scanner input,int Id){
		System.out.println("welcome to Admin page");
		Admin_method  admin = new Admin_method();

		if(admin.checkPassword(Id)){
			admin.operations(input);
		}
		else {
			Trial ++;
			if(Trial >= 3) 
			{
				System.out.println("You password Was Not Correct! you have tried ["+Trial+"]times!  Access Denied");
				Trial =0;
				login(input);
				}
			System.out.println("You password Was Not Correct! you have tried ["+Trial+"] times!try gain");
			adminWelcome(input, Id);
		}
	}
	
	static void employeeWelcome(Scanner input , int id){
		System.out.println("welcome to Employee");
		Banker_method  employee= new Banker_method();
		if(employee.checkPassword(id)) {
			employee.operations(input); 
		}
		else {
			Trial ++;
			if(Trial >= 3) 
			{
			System.out.println("You password Was Not Correct! you have tried ["+Trial+"]times!  Access Denied");
			Trial =0;
			login(input);
				}
			System.out.println("You password Was Not Correct! you have tried ["+Trial+"]times! try gain");
			employeeValidate(input);
		}
	}

	public static boolean  Authenthicator(int Id,int type){
		boolean checked = false;
		String file = Methods.getFileName(Id);
		switch(type){
		case 1:
			// check id range for administrators
			if(file!= null)
			{ int idrange = 20000;
			if((Id >=idrange)&&(Id < 30000))
			{ checked = true;}
			else { 
				checked = false; 
			}
			}
			break;
		case 2:
			// this is id range for the bankers
			if(file!= null)
			{ int idrange = 30000;
			if((Id >=idrange)&&(Id < 50000))
			{ checked = true;}
			else { 
				checked = false; 
			}
			}
			break;
		case 3:
			// this is id range 
			if(file!= null)
			{ int idrange = 10000;
			if((Id >=idrange)&&(Id < 20000))
			{ checked = true;}
			else { 
				checked = false; 
			}
			}
			break;
		default:
			System.out.println("access is denied! ");
			break;
		}
		return checked;
	}

}
