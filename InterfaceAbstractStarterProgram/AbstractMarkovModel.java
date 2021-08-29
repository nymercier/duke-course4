
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int order;
    
    public AbstractMarkovModel(int order) {
        myRandom = new Random();
        this.order = order;
    }
    
    public void setTraining (String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText (int numChars);
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public ArrayList <String> getFollows (String key) {
        ArrayList <String> follows = new  ArrayList <String>();
        int pos = 0;
        //System.out.println(myText.length());
        for (int i=0; i < myText.length()-order; i++){
            int start = myText.indexOf(key,pos);
            // t int start = 0
            if (start == -1) {
                break;
            }
            if (start + key.length() >= myText.length()) {
                break;
            }
            //System.out.println(key);
            //System.out.println("int start "+start);
            String next = myText.substring(start+key.length(),start+key.length()+1);
            follows.add(next);
            pos = start+key.length();
        }
        return follows;
    }
    
    public String toString() {
    	return "Markov Model order " + order;
    }
    
}
