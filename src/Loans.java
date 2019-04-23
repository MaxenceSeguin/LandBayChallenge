import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Loans {

    List<Loan> list;

    /**
     * Create the loans list, order them by older completeDate.
     * @param filePath
     */
    public Loans(String filePath){
        try {
            list = new CsvToBeanBuilder<Loan>(new FileReader(filePath))
                    .withType(Loan.class).build().parse();
            list.sort(Comparator.comparing(Loan::getCompletedDate));
        } catch (FileNotFoundException e){
            list = new ArrayList<>();
            System.out.println("Error creating the loans list.");
        }
    }

    /**
     * Displays the list of loans.
     */
    public String toString(){
        return list.toString();
    }
}
