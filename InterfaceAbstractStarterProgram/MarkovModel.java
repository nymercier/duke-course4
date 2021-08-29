
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
import edu.duke.*;
import java.io.*;
import java.util.ArrayList;

public class MarkovModel extends AbstractMarkovModel {
    //private int order;
    
    public MarkovModel(int order) {
        super(order);
    }
    
    public String getRandomText(int numChars){
        if (myText ==null) {
            return "empty";
        }
        
        StringBuilder sb = new StringBuilder();
        
        int index = myRandom.nextInt(myText.length()-order);
        String key = myText.substring(index,index+order);
        sb.append(key);
        
        for(int k=0; k < numChars-order; k++){
            ArrayList <String> follows = getFollows(key);
            //System.out.println("key "+key+" "+follows);
            //System.out.println(index);
            index = myRandom.nextInt(follows.size());
            String next =follows.get(index);
            sb.append(next);
            //System.out.println(key);
            key = key.substring(1)+next;
        }
        return sb.toString();
    }
}
