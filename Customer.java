import java.util.ArrayList;

public class Customer {
    
    private String name;
    private ArrayList<Double> transactions;
    
    public Customer(String name,double initialTransactions){
        
        this.name = name;
        transactions = new ArrayList<>();
        transactions.add(initialTransactions);
    }
