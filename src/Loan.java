import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.util.Date;

/**
 * This class represents a loan. It stores the information of the loan as attributes:
 * ID of the loan, amount of the loan, type of loan, term of the loan, completion date.
 */
public class Loan {

    /**
     * ID of the loan - a positive integer.
     */
    @CsvBindByName
    private int loanId;

    /**
     * The money required by the borrower.
     */
    @CsvBindByName
    private int loanAmount;

    /**
     * The type of the loan: FIXED or TRACKER.
     */
    @CsvBindByName
    private String product;

    /**
     * The term (in month) of the investment.
     */
    @CsvBindByName
    private int term;

    /**
     * The date of completion of the loan.
     */
    @CsvBindByName
    @CsvDate("dd/MM/yyyy")
    private Date completedDate;

    public int getLoanId() {
        return loanId;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public String getProduct() {
        return product;
    }

    public int getTerm() {
        return term;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    /**
     * Display the information on the prompt.
     * @return The information for each attributes.
     */
    public String toString(){
        return "\nLoan ID: " + loanId + "\n Loan Amount: " + loanAmount + "\n Product Type:" + product + "\n Term:" +
                term + "\n Completed Date: " + completedDate;
    }
}
