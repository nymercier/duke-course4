
/**
 * Write a description of class MarkovZero here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import java.util.Random;

public class MarkovZero extends AbstractMarkovModel {
    
    
    public MarkovZero() {
        super(0);
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        //Remember, for MarkovZero, this class generates each letter by randomly 
        //choosing a letter from the training text.
        
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        
        for(int k=0; k < numChars; k++){
            
            int index = myRandom.nextInt(myText.length());
            sb.append(myText.charAt(index));
        }
        
        return sb.toString();
    }
}
