import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a loan and the investment that fund it. This is the connection between a loan and investments.
 */
public class LoanConnection {

    /**
     * The loan funded.
     */
    private Loan loan;

    /**
     * The investment that funds the loan.
     */
    private List<Investment> investments;

    /**
     * Initialize the connection with the loan we are working on.
     */
    public LoanConnection (Loan loan){
        this.loan = loan;
        investments = new ArrayList<>();
    }

    /**
     * Add an investment to the connection.
     */
    public void addInvestment(Investment investment){
        investments.add(investment);
    }

    /**
     * Returns the list of investments.
     */
    public List<Investment> getInvestments() {
        return investments;
    }

    /**
     * Displays the connection: the loan and then the investments.
     */
    public String toString(){
        String res = "\n\n" + loan.toString();
        for (Investment inv : investments){
            res += inv.toString();
        }
        return res;
    }
}
