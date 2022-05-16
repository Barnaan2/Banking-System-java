
public interface customer_interface {
    // to remember the functionalites tha will given to customer
    public double check_balance(int account_number,String name, String password);
 public boolean withdraw(int account_number, double ammount,String name, String password);
 public boolean deposit(int account_number, double ammount, String name);
 public boolean transfer(int saccount_number,int raccount_number, double ammount,String sname,String rname, String password);
public boolean send(int raccount_number,String sname, String rname,double ammount );
public boolean delete(int account_number,String name, String password, String reason);
public boolean check_data(int account_number, String name,String password);
}
