
/**
 * Décrivez votre classe TitleAndDepthComparator ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

import java.util.*;
import java.io.*;
import edu.duke.*;

public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
    
    public int compare (QuakeEntry qe1, QuakeEntry qe2) {
        String title1 = qe1.getInfo();
        String title2 = qe2.getInfo();
        
        int compare = title1.compareTo(title2);
        
        if (compare == 0) {
            return Double.compare(qe1.getDepth(), qe2.getDepth());
        }
        
        return compare;
    }
}
