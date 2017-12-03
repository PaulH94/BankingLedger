/**
 * Created by Paul Huynh on 11/29/2017.
 */
public class Transactions {
    private String transactionType;
    private double transactionAmount;

    Transactions(String tType, double tAmount){
        this.transactionType = tType;
        this.transactionAmount = tAmount;
    }

    @Override
    public String toString(){
        return(transactionType + ": " + transactionAmount);
    }
}
