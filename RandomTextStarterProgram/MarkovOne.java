
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
import edu.duke.*;
import java.io.*;
import java.util.ArrayList;

public class MarkovOne {
    private String myText;
    private Random myRandom;
    
    public MarkovOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        //The getRandomText method has one integer parameter named numChars. 
        //This method generates and returns random text that is numChars long. 
        //Remember, for MarkovZero, this class generates each letter by randomly 
        //choosing a letter from the training text.

        //Modify for MarkovOne
         StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-1);
        String key = myText.substring(index,index+1);
        sb.append(key);
        
        for(int k=0; k < numChars-1; k++){
            ArrayList <String> follows = getFollows(key);
            if (follows.size() ==0) {
                break;
            }
            //System.out.println(index);
            index = myRandom.nextInt(follows.size());
            String next =follows.get(index);
            sb.append(next);
            key = next;
            //adds the given character to the end of the sequence
        }
        return sb.toString();
    }
    
    public ArrayList <String> getFollows (String key) {
        ArrayList <String> follows = new  ArrayList <String>();
        int pos = 0;
        //System.out.println(myText.length());
        while (pos < myText.length()){
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
}
