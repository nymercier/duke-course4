
/**
 * Write a description of magdepth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;
import edu.duke.*;


public class magdepth implements Comparator<QuakeEntry> {
    public int compare (QuakeEntry qe1, QuakeEntry qe2) {
        
        int compare = Double.compare(qe1.getMagnitude(), qe2.getMagnitude());
        
        if (compare == 0) {
            return Double.compare(qe1.getDepth(), qe2.getDepth());
        }
        
        return compare;
    }
}
