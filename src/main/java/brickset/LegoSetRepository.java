package brickset;

import repository.Repository;

import java.time.Year;
import java.util.Locale;
import java.util.logging.Level;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    /**
     *{@return the boolean value if all the lego set were manufactured in the year of 2009, using allmatch as a terminal stream operation}
     */

public boolean allLegoSetHavingYear2009(){
        return getAll().stream()
                .allMatch(legoSet -> legoSet.getYear().equals(Year.of(2009)));
}

    /**
     * prints all tags in a lego set, removes duplicates by using .distint() function.
     */
    public void PrintAllTagsOfLegoSets(){
    getAll().stream()
            .filter(legoSet -> legoSet != null)
            .flatMap(legoSet -> legoSet.getTags().stream())
            .distinct()
            .forEach(System.out::println);

}


    public static void main(String[] args) {
        var repository = new LegoSetRepository();
        System.out.println(repository.allLegoSetHavingYear2009());
        repository.PrintAllTagsOfLegoSets();
    }
}
