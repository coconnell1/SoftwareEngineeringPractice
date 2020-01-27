package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw (double amount)  {
        if (amount > 0 && amount <= balance){
            balance-=amount;
        }
    }


    public static boolean isEmailValid(String email) {
        if (email == "") {
            return false;
        }
        if (email.indexOf('@') == -1) {
            return false;
        } else if (email.indexOf(".") == 0) {
            return false;
        } else if (email.indexOf("..") != -1) {
            return false;
        } else if (email.indexOf("-@") != -1) {
            return false;
        } else if (email.indexOf("#") != -1) {
            return false;
        } else {
            String eDomain = email.substring(email.indexOf("@"));

            if (eDomain.indexOf(".") == -1) {
                return false;
            }

            else if (eDomain.indexOf("#") != -1){
                return false;
            }

            else{
                String emailEnd = eDomain.substring((eDomain.indexOf(".")));

                if (emailEnd.length() < 3 && emailEnd.length() < 4){
                    return false;
                }

                else if (eDomain.indexOf(".") == -1){
                    return false;
                }
            }
        }
        return true;
    }
}

