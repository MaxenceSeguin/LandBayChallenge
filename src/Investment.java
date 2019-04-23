import com.opencsv.bean.CsvBindByName;

/**
 * This class represents an investment. It stores the information of the investment as attributes:
 * name of investor, amount invested, type of investment, term of the investment.
 */
public class Investment {

    public Investment(){}

    public Investment(String i1, int i2, String i3, int i4){
        this.investor = i1;
        this.investmentAmount = i2;
        this.productType = i3;
        this.term = i4;
    }

    /**
     * The investor involved in the investment.
     */
    @CsvBindByName
    private String investor;

    /**
     * The money invested by the investor
     */
    @CsvBindByName
    private int investmentAmount;

    /**
     * The type of investment.
     */
    @CsvBindByName
    private String productType;

    /**
     * The term (in month) of the investment.
     */
    @CsvBindByName
    private int term;

    /**
     * Getters and setter.
     */

    public String getInvestor() {
        return investor;
    }

    public void setInvestor(String investor) {
        this.investor = investor;
    }

    public int getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(int investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    /**
     * End of getters setters.
     */

    public Investment copy(){
        return new Investment(this.investor, this.investmentAmount, this.productType, this.term);
    }

    /**
     * Displays the information on the prompt.
     * @return The information for each attributes.
     */
    public String toString(){
    return "\nInvestor: " + investor + "\n Investment: " + investmentAmount+ "\n Type: " + productType + "\n Term: " + term;
    }
}