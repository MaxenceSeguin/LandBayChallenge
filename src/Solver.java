import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solver {

    static public List<LoanConnection> solveBiggestInvestmentFirst(Investments investments, Loans loans){

        /** The list that contains the final set of connections **/
        List<LoanConnection> solution = new ArrayList<>();

        Investment investment;
        LoanConnection connection;
        List<Investment> investmentAvailable;
        boolean possible;
        int index, newInvestmentAmount, amount;

        for (Loan loan : loans.list){

            connection = new LoanConnection(loan);
            investmentAvailable = investments.getListWithConditions(loan.getProduct(), loan.getTerm());
            /** Sort the investment to match with the term. We will use the investments with the lowest term first. **/
            investmentAvailable.sort(Comparator.comparingInt(Investment::getTerm));
            possible = true;

            int moneyRequired = loan.getLoanAmount();

            while (moneyRequired > 0 && possible){

                if (!investmentAvailable.isEmpty()) { /** If investment is available **/
                    amount = investmentAvailable.get(0).getInvestmentAmount();

                    if (moneyRequired >= amount){ /** If we need the full investment **/
                        investment = investmentAvailable.remove(0);
                        connection.addInvestment(investment);
                        moneyRequired -= amount;

                    } else { /** Else we need just part of it **/
                        investment = investmentAvailable.get(0);
                        index = investments.list.indexOf(investment);

                        /** We set the remainder of the investment after the loan in the list of investment **/
                        newInvestmentAmount = investments.list.get(index).getInvestmentAmount() - moneyRequired;
                        investments.list.get(index).setInvestmentAmount(newInvestmentAmount);

                        /** We create a copy of investment to prevent altering the one in investments.list **/
                        investment = investment.copy();

                        /** We set the investment with the money taken from it to the LoanConnection **/
                        investment.setInvestmentAmount(moneyRequired);
                        connection.addInvestment(investment);

                        moneyRequired = 0;
                    }
                } else { /** If there is no more investment but the loan still requires money **/
                    possible = false;
                }
            }

            if (moneyRequired == 0){ /** The loan was fully funded **/
                solution.add(connection);
                investments.list.removeAll(connection.getInvestments());
            }

        }

        return solution;
    }

}
