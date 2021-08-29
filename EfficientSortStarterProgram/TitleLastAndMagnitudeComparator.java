
/**
 * Décrivez votre classe TitleAndDepthComparator ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

import java.util.*;
import java.io.*;
import edu.duke.*;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    
    public int compare (QuakeEntry qe1, QuakeEntry qe2) {
        String title1 = qe1.getInfo();
        String title2 = qe2.getInfo();
        
        String [] words = title1.split(" ");
        String lastw1 = words[words.length-1];
        System.out.println(lastw1);
        
        String [] words2 = title2.split(" ");
        String lastw2 = words2[words2.length-1];
        //System.out.println(lastw2);

        int compare = lastw1.compareTo(lastw2);
        System.out.println(compare);
        
        //int compare2 = title1.compareTo(title2);
        
        if (compare == 0) {
            return Double.compare(qe1.getMagnitude(), qe2.getMagnitude());
        }
        
        return compare;
        
    }
}
