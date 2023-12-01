package entities;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;

    public Account(Integer number, String holder){
        this.number = number;
        this.holder = holder;
    }

    public Account(Integer number, String holder, Double balance){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public Integer getNumber(){
        return number;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getHolder(){
        return holder;
    }

    public void setBalance(Double balance){
        this.balance = balance;
    }
    public Double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount + 5;
    }

    public String toString(){
        return "Account " + number + ", Holder: " + holder + ", Balance: $ " + balance;
    }

}
