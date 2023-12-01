# JavaProjects
## 1. Banco

Em um banco, para se cadastrar uma conta bancária, é necessário informar o número da conta, o 
nome do titular da conta, e o valor de depósito inicial que o titular depositou ao abrir a conta. Este 
valor de depósito inicial, entretanto, é opcional, ou seja: se o titular não tiver dinheiro a depositar 
no momento de abrir sua conta, o depósito inicial não será feito e o saldo inicial da conta será, 
naturalmente, zero.
Importante: uma vez que uma conta bancária foi aberta, o número da conta nunca poderá ser 
alterado. Já o nome do titular pode ser alterado (pois uma pessoa pode mudar de nome por 
ocasião de casamento, por exemplo).
Por fim, o saldo da conta não pode ser alterado livremente. É preciso haver um mecanismo para 
proteger isso. O saldo só aumenta por meio de depósitos, e só diminui por meio de saques. Para 
cada saque realizado, o banco cobra uma taxa de $ 5.00. Nota: a conta pode ficar com saldo 
negativo se o saldo não for suficiente para realizar o saque e/ou pagar a taxa.
Você deve fazer um programa que realize o cadastro de uma conta, dando opção para que seja ou 
não informado o valor de depósito inicial. Em seguida, realizar um depósito e depois um saque, 
sempre mostrando os dados da conta após cada operação

### Output

```
Enter account number: 8532
Enter account holder: Alex Green
Is there an initial deposit (y/n)? y
Enter initial deposit value: 500.00
Account data:
Account 8532, Holder: Alex Green, Balance: $ 500.0
Enter a deposit value: 200.00
Updated account data:
Account 8532, Holder: Alex Green, Balance: $ 700.0
Enter a withdraw value: 300.00
Updated account data:
Account 8532, Holder: Alex Green, Balance: $ 395.0
```

### Código
#### Classe Account
```java
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
```

#### Classe Main
```java
package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account acc;

        System.out.print("Enter account number: ");
        Integer number = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter account holder: ");
        String holder = sc.nextLine();
        System.out.print("Is there an initial deposit (y/n)? ");
        char choice = sc.next().charAt(0);

        if(choice == 'y'){
            System.out.print("Enter initial deposit value: ");
            Double amount = sc.nextDouble();
            acc = new Account(number, holder, amount);
        } else {
            acc = new Account(number, holder);
        }

        System.out.println("Account data:");
        System.out.println(acc);

        System.out.print("Enter a deposit value: ");
        Double amount = sc.nextDouble();
        acc.deposit(amount);
        System.out.println("Updated account data:");
        System.out.println(acc);

        System.out.print("Enter a withdraw value: ");
        Double withdraw = sc.nextDouble();
        acc.withdraw(withdraw);
        System.out.println("Updated account data:");
        System.out.println(acc);
    }
}
```

