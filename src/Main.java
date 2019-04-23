import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.List;

/**
 * The output from this file be a JSON representation. A loan is bound to investments (a list of investment).
 */
public class Main {

    public static void main(String[] args) {

        /** Initialize the loans and investment object from the files **/
        Investments investments = new Investments("investmentRequests-data.csv");
        Loans loans = new Loans("loans-data.csv");

        /** Create the solution according to the solving policy **/
        List<LoanConnection> solution = Solver.solveBiggestInvestmentFirst(investments, loans);

        /** Create and display the JSON representation from the solution **/
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(solution);
        System.out.println(json);
        try{
            FileOutputStream fos = new FileOutputStream("Solution.json");
            fos.write(json.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e){
            System.out.println("File creation failed.");
        }

    }
}
