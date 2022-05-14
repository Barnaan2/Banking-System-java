/*
solutions  of basic logical problems.
@Barnaan2


*/
import java.util.Scanner;
public class Base{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
       Method b = new Method();

System.out.println("Enter Length of the Array: ");
int index = input.nextInt();
int[] c =new int[index];


System.out.println("Enter Elements of the Array: ");
for(int i = 0; i <c.length; i++){
c[i] = input.nextInt();
}

System.out.println("which problem do you like to check? 1/2: ");
int num = input.nextInt();
if(num ==1){
System.out.println("Enter the n value: ");
int n = input.nextInt();
// calling the method required;

int value = b.hasNvalues(c,n);
if(value == 1){
	System.out.println("True");

}
else if(value==0){
System.out.println("False");
}}
else if(num == 2){
int	x = b.isBalanced(c);
System.out.println(x);

	}
}

}

//class to solve those problems.


class Method{

/*
to check number of different kind of number exist in a array


*/
	int hasNvalues(int[] a, int n){
		sort(a);
		int temp = a[0]; 
		int i =1;
		int store = 1;
		while(i<a.length){  
			if(temp != a[i])
				{  temp = a[i];
                  store++;}
                  i++;}

if(n==store){
	 return 1;
          }
else{
return 0;
}
}
/*
To check some array contains two or more same type of elements


*/
int isBalanced(int[] a){
	sort(a);
	int temp = 1;
	int check = 0;
 // a ={3,1,1,2,2,2,3}
	for(int i = 0; i<a.length; i++){

		for(int j = 0; j < a.length; j++)
			{
				if(a[i]!=a[j]){
                   temp++;
			        }
		}

			if(temp == a.length){
		   check++;}
// this second if conditinon is to stop the loop after we knew there is some value that is not doubled
	 if(check > 0){
		   	break;
		   }
	
	}
 if(check >0){
 	return 0;
 }	
 else{
 	return 1;
 }
}

void sort(int[] a){
// using the bubble sorting algorithim
for(int i = 0; i< a.length; i++){
	for(int j = i+1; j<a.length; j++){
		if(a[i]>a[j]){
			int temp = a[i];
			a[i] = a[j];
			a[j]= temp;
		}
	}
}

}	

}
