import java.util.ArrayList;


public class Bank {
    
    private String name;
    private ArrayList<Branch> branches;
    
    public Bank(String name){
        this.name = name;
        branches = new ArrayList<>(); 
    }
    
    public boolean addBranch(String branchName){
        
        if(findBranch(branchName) == null){
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
        
    }
    
    public boolean addCustomer(String branchName, String nameCustomer, double initialTransaction){
        
        if(!(findBranch(branchName) == null)){

            return findBranch(branchName).newCustomer(nameCustomer, initialTransaction);
        
        }
            
        return false;

    }
    
    public boolean addCustomerTransaction(String branchName, String nameCustomer, double transaction){
        
        if(!(findBranch(branchName) == null)){
            
            return findBranch(branchName).addCustomerTransaction(nameCustomer, transaction);

        }
            
        return false;

        
    }
    
    private Branch findBranch(String branchName){
        
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }
    
    public boolean listCustomers(String branchName, boolean printTransactions){
        
        Branch branch = findBranch(branchName);
        
        if (branch != null) {
            
            System.out.println("Customer details for branch " + branch.getName());
            ArrayList<Customer> customers = branch.getCustomers();
            
            for (int i = 0; i < customers.size(); i++) {
                
                Customer customer = customers.get(i);
                System.out.println("Customer: " + customer.getName() + "[" + (i + 1) + "]");
                
                if (printTransactions) {
                    
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = customer.getTransactions();
                    
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }
        return false;
        
    }
    
}
