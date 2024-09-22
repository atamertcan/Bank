import java.util.ArrayList;

public class Branch {
    
    private String name;
    private ArrayList<Customer> customers;
    
    public Branch(String name){
        this.name = name;
        customers = new ArrayList<>();
    }
    
    public String getName(){
        return name;
    }
    
    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    public boolean newCustomer(String nameCustomer, double initialTransaction){
        
        
         if (findCustomer(nameCustomer) == null) {
             
            customers.add(new Customer(nameCustomer, initialTransaction));
            return true;
        }
        return false;
        
    }
    
    public boolean addCustomerTransaction(String nameCustomer, double transaction){
        
        Customer customer = findCustomer(nameCustomer);
        
        if (customer != null) {
            
            customer.addTransaction(transaction);
            return true;
        }
        return false;
               
    } 

    private Customer findCustomer(String nameCustomer){
        
        for (int i = 0; i < customers.size(); i++) {
            
            Customer customer = customers.get(i);
            
            if (customer.getName().equals(nameCustomer)) {
                return customer;
            }
        }
        return null;
    }
                  
}
