/**
 * Created by Paul Huynh on 11/29/2017.
 * Transaction class
 */
public class Transactions {
    private String transactionType;                 //The transaction type: either deposit or withdrawal
    private double transactionAmount;               //The amount that is deposited or withdrawn

    //Transition constructor
    Transactions(String tType, double tAmount){
        this.transactionType = tType;
        this.transactionAmount = tAmount;
    }


    //Display the transaction
    @Override
    public String toString(){
        return(transactionType + ": " + transactionAmount);
    }
}
