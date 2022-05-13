class Problems{
	static int primeCount(int start, int end){
		int count = 0;
		for(int  i = start; i <= end; i++ ){
			int count_inner = 0;
			for(int j = 1; j< i; j++){
                 int val = i/j;
                 int check = val*j;
                 if(check == i){
                 	count_inner++;
                 }
             }
                 if(count_inner == 1)
                 {count ++;}
		}
		return count;
	}


	public static void main(String[] args){
		int prime = primeCount(10,30);
		System.out.println(prime);
	}
}