import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents the list of investments in the CSV file.
 */
public class Investments {

    public List<Investment> list;

    /**
     * Create the investments list, order them by greater investmentAmount.
     * @param filePath the relative file path.
     */
    public Investments (String filePath){
        try{
            this.list = new CsvToBeanBuilder<Investment>(new FileReader(filePath))
                    .withType(Investment.class).build().parse();
            list.sort(Comparator.comparingInt(Investment::getInvestmentAmount));
            Collections.reverse(list);
        } catch (FileNotFoundException e){
            list = new ArrayList<>();
            System.out.println("Error creating the investments list.");
        }
    }

    /**
     * Returns a sub list of this.list filtered according to the type of investment required, and to the minimum term of
     * investment required.
     * @param type Type required
     * @param term Minimum term required
     * @return Sub list of this.list fulfilling the criteria.
     */
    public List<Investment> getListWithConditions(String type, int term){
        return list.stream()
                .filter( p->p.getProductType().equals(type) )
                .filter( p->p.getTerm() >= term )
                .collect(Collectors.toList());
    }

    /**
     * Displays the list of the investments.
     */
    public String toString(){
        return list.toString();
    }
}
