import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/*
Main Method of the system. Which controls everything.
   By :-  Bernabas Tekklign;
  Gitub User Name:-  ----- "Barnaan2"
  Email Address  ------ "BarnaanTekalign@gmail.com"
   " CopyRight--- feel free to use it for any purpose "

*/
public class Methods {

	static int[] idNumbers;
	// generate file that object will be seralized to;
	static void generateId( int identification,int type){
		Random Id = new Random();
		int number =1 + Id.nextInt(1000000);
		checkId(number,identification,type);
	}


	// check uniqueness of the file name generated and add tags
	static void checkId(int idNumber,int idetification, int type){
		String fileName = "Null.txt";
		String Type = "";
		if(type == 1){
			Type += "A";
			fileName = "Admin.txt";
		}
		else if(type == 2){
			Type += "B";
			fileName = "Banker.txt";
		}
		else if(type == 3){
			Type += "C";
			fileName = "Customer.txt";
		}
		else{
			System.out.println("the type is not correct.");
		}
		try{
			String Id = Type + idNumber;
			BufferedReader ids = new BufferedReader(new FileReader(fileName));
			String data = "";

			while((data = ids.readLine()) != null){
				if(data == Id){
					generateId(type,idetification);
				}
			}
			ids.close();

			saveId(Id,fileName,idetification);

		}
		catch(Exception e){
			System.out.println("there is an error within your code");
			System.out.println(e.getMessage());
		}
	}


	// will save the generated file name and create relation
	static void saveId(String Id, String fileName,int idetification){
		try{
			PrintWriter addId = new PrintWriter(new FileOutputStream(fileName,true));
			addId.println(Id);
			addId.close();
		}

		catch(Exception e){
			System.out.println("there is an error within your code");
			System.out.println(e.getMessage());
		}
		String  Filename = fileNamer(Id);
		setRelation(idetification,Filename);
	}

	// create text file that the object will be seralized on;
	static  String  fileNamer(String Id){
		String filename = Id + ".txt";
		return filename;
	}
//Serialize any class type of object         
	public static <V> void seralize(String fileName, V object){
		try{  File files = new File(fileName);
		FileOutputStream os = new FileOutputStream(files);
		ObjectOutputStream dos = new ObjectOutputStream(os);
		dos.writeObject(object);
		dos.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	//create file to save the relation of ID and File name
	void create_Relation(){
		try{
			String filename = "Relation.txt";
			File files = new File(filename);
			FileOutputStream hash = new FileOutputStream(files);
			ObjectOutputStream hashmap = new ObjectOutputStream(hash);
			HashMap<Integer,String> data = new HashMap<Integer,String>();
			//one key can only have one value and can exist only once;
			data.put(000000,"me");
			hashmap.writeObject(data);
			hashmap.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	


	// set relation of Id and File name
	static void setRelation(Integer identifaction, String fileName){
		String filename = "Relation.txt";
		HashMap<Integer,String>  data;
		//valueOf();
		data = (HashMap<Integer,String>) deserialize(filename);
		data.put(identifaction,fileName);
		seralize(filename,data);
	
	}


	// deseralize hashmap object to help us search for our objects
	@SuppressWarnings({ "unchecked" })
	public static  HashMap<Integer,String>  deserialize(String fileName){
		HashMap<Integer,String> object = new HashMap<Integer,String>();
		try{ File files =  new File(fileName);
		FileInputStream output;
		output = new FileInputStream(files);
		ObjectInputStream input;
		input = new ObjectInputStream(output);
		object = (HashMap<Integer,String>) input.readObject();
		input.close();
		}

		catch(Exception e) {
			System.out.println(e.getMessage()); }
		return object; }

	// it return file name for user we passed in
	static String getFileName(Integer identifaction){
		String filename = "Relation.txt";
		HashMap<Integer,String>  data;
		data = (HashMap<Integer,String>) deserialize(filename);
		String fileName =data.get(identifaction);
		return fileName; 
	}
// this delete the relation
	static void delete(Integer identifaction){
		String filename = "Relation.txt";
		HashMap<Integer,String>  data;
		data = (HashMap<Integer,String>) deserialize(filename);
		data.remove(identifaction);
		  data.keySet();
		seralize(filename,data);

		System.out.println("the operation is done");
	}
  
	// generate account number for the customer
	static int accountNumberGenerator(){
		int accountNumber = 10000;
		try{  String fileName = "accountNumber.txt";
		BufferedReader ids = new BufferedReader(new FileReader(fileName));
		int numberOfAccountNumber = 0;
		while(ids.readLine() != null){
			numberOfAccountNumber +=1;
		}
		accountNumber += numberOfAccountNumber;
		ids.close();
		PrintWriter account = new PrintWriter(new FileOutputStream(fileName,true));
		account.println(accountNumber);
		account.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return accountNumber;
	}


	//generate ID number for admin users
	static int AdminIdGenerate() {
		int Idnumber = 20000;
		try{  
			String fileName = "AdminId.txt";
			BufferedReader ids = new BufferedReader(new FileReader(fileName));
			int Admins = 0;
			while(ids.readLine() != null){
				Admins +=1;
			}

			Idnumber += Admins;
			ids.close();
			PrintWriter account = new PrintWriter(new FileOutputStream(fileName,true));
			account.println(Idnumber);
			account.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return Idnumber;   
	}


	//generate Id number for employee users
	static int EmpIdGenerate(){
		int Idnumber = 30000;
		try{  
			String fileName = "EmployeeId.txt";
			BufferedReader ids = new BufferedReader(new FileReader(fileName));
		
			int numberOfAccountNumber = 0;
			while( ids.readLine() != null){
				numberOfAccountNumber +=1;}

			Idnumber += numberOfAccountNumber;
			ids.close();
			PrintWriter account = new PrintWriter(new FileOutputStream(fileName,true));
			account.println(Idnumber);
			account.close(); }

		catch(Exception e){
			System.out.println(e.getMessage());}
		return Idnumber;
	} 

	// uses to create file in case we had an error related it
	public void create_files(String Filename) 
	{
		try {
			File file = new File(Filename);
			 file.createNewFile(); }
		catch(Exception e) {
			System.out.println(e.getMessage()); }
	}
	
	
	
	// date for input
	public static String date() {
		LocalDate date = LocalDate.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dateNow = date.format(formatter);
		return dateNow;
	}


	// create array of object that will store our data
	public static void createObjectArray(int type,int number) {

		Scanner input = new Scanner(System.in);
		int num = number;
		switch(type) {
		case 1:

			Admin[] obj = new Admin[num];
			createObject(obj,number);
			takeInput(obj,number,input);
			break;
		case 2:

			Banker[] banker = new Banker[num];
			// banker array that have length of 4 holds five elements
			createObject(banker,number);
			takeInput(banker,number,input); 
			break;
		case 3:
			Customer[] customer = new Customer[num];
			createObject(customer,number);
			takeInput(customer,number,input);   
			break;
		default:
			System.out.println("there is an error with your code");
			break;
		}
	}
	//create customer object
	public static void createObject(Customer[] obj, int index){
		int type = 3;
		int num =index;
		idNumbers = new int[num];
		for(int i = 0; i<index; i++)
		{
			obj[i] = new Customer();
			int Acc_no =accountNumberGenerator();
			idNumbers[i]=Acc_no;
			generateId(Acc_no, type);
		}}


	//create Admin object
	public static void createObject(Admin[] obj, int index){
		int type = 1;
		int num =index;
		idNumbers = new int[num];
		for(int i = 0 ; i<index; i++)
		{
			obj[i] = new Admin();
			int AdmId = AdminIdGenerate();
			idNumbers[i]=AdmId;
			generateId( AdmId, type);
		}}

	//create Employee object
	public static void createObject(Banker[] obj, int index){
		int type = 2;
		int num =index;
		idNumbers = new int[num];

		for(int i = 0; i<index; i++)
		{
			obj[i] = new Banker();
			int empId = EmpIdGenerate();
			idNumbers[i]=empId;
			generateId( empId, type);
		}
	}


	//take input form users to set our fields
	public static void takeInput(Admin[] user,int index,Scanner input)
	{
		System.out.println("Please fillout  the Information");

		for(int i = 0; i<index; i++){

			System.out.print("Name: ");
			String name = input.nextLine();
			user[i].set_name(name);
			int id = idNumbers[i];
			user[i].set_id(id);
			// here i need to set id number and for that i need that array;
			System.out.println("Age:");
			int age = input.nextInt();
			user[i].set_age(age);
			input.nextLine();
			System.out.println("Sex:");
			String gender = input.nextLine();
			user[i].set_gender(gender);
			System.out.println("date set by the system");
			user[i].set_date_of_regstration(date());
			System.out.println("Branch: ");
			String Branch = input.nextLine();
			user[i].set_branch(Branch);
			System.out.println("password: ");
			String password = input.nextLine();
			user[i].set_password(password);
			if(i < index-1){
				System.out.println("insert the Next Admin");

			}
			String filename = getFileName(id);
			seralize(filename,user[i]);
		}}


	// take input to store 
	public static void takeInput(Banker[] user,int index, Scanner input)
	{
		System.out.println("Please fillout  the Information");
		for(int i = 0; i<index; i++){   
			System.out.print("Name: ");
			String name = input.nextLine();
			user[i].set_name(name);
			int id = idNumbers[i];
			user[i].set_id(id);
			// here i need to set id number and for that i need that array;
			System.out.println("Age:");
			int age = input.nextInt();
			user[i].set_age(age);
			input.nextLine();
			System.out.println("Sex:");
			String gender = input.nextLine();
			user[i].set_gender(gender);
			System.out.print("Enter Qualification :");
			String qual = input.nextLine();
			user[i].set_qualification(qual);
			System.out.print("Enter Position :");
			String position = input.nextLine();
			user[i].set_position(position);
			System.out.println("Date is set by the system");
			user[i].set_date_of_regstration(date());
			System.out.println("Branch: ");
			String Branch = input.nextLine();
			user[i].set_branch(Branch);
			System.out.println("Salary: ");
			double salary = input.nextDouble();
			user[i].set_salary(salary);
			input.nextLine();
			System.out.println("password: ");
			String password = input.nextLine();
			user[i].set_password(password);
			if(i <index-1){
				System.out.println("insert the Next Employee");}
			String filename = getFileName(id);
			seralize(filename,user[i]);
		}
	}


	//take input to store
	public static void takeInput(Customer[] user,int index, Scanner input)
	{
		System.out.println("Please fillout  the Information");

		for(int i = 0; i<index; i++){

			System.out.print("Name: ");
			String name = input.nextLine();
			user[i].set_name(name);

			int id = idNumbers[i];
			user[i].set_id(id);
			// here i need to set id number and for that i need that array;
			System.out.println("Age:");
			int age = input.nextInt();
			user[i].set_age(age);
			input.nextLine();
			System.out.println("Sex:");
			String gender = input.nextLine();
			user[i].set_gender(gender);
			System.out.println("date is set by the system");
			user[i].set_date_of_regstration(date());
			System.out.println("Branch: ");
			String Branch = input.nextLine();
			user[i].set_branch(Branch);
			System.out.println("Balance :");
			double balance = input.nextDouble();
			user[i].set_balance(balance);
			input.nextLine();
			System.out.println("your Id number: ");
			int creator =  input.nextInt();
			user[i].set_account_creator(creator);
			if(i <index-1){
				System.out.println("insert the Next Customer");
			}
			String filename = getFileName(id);
			seralize(filename,user[i]);
		}
	}
	public static void printIdnumbers() {
		System.out.println("The account numbers / id numbers are :");

		for(int i:idNumbers) {
			System.out.println(i);
		}
	}

	public static <V>void saveChanges(int id, V object ) {
		String filename = getFileName(id);
		seralize(filename,object);
	}

}
