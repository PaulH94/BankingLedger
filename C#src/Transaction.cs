//Create by Paul Huynh
//Transaction class

using System;
using System.Collections.Generic;
using System.Text;

namespace BankingLedger
{
    public class Transactions
    {
        private String transactionType;                 //The transaction type: either deposit or withdrawal
        private double transactionAmount;               //The amount that is deposited or withdrawn


        //Constructor
        public Transactions(String tType, double tAmount)
        {
            this.transactionType = tType;
            this.transactionAmount = tAmount;
        }

        //Display the transaction
        public override String ToString()
        {
            return (transactionType + ": " + transactionAmount);
        }

    }
}
