
/**
 * Write a description of MarkovFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
import edu.duke.*;
import java.io.*;
import java.util.ArrayList;

public class MarkovFour {
    private String myText;
    private Random myRandom;
    
    public MarkovFour() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-4);
        String key = myText.substring(index,index+4);
        sb.append(key);
        
        
        for(int k=0; k < numChars-4; k++){
            ArrayList <String> follows = getFollows(key);
            System.out.println("key "+key+" "+follows);
            if (follows.size() ==0) {
                break;
            }
            //System.out.println(index);
            index = myRandom.nextInt(follows.size());
            String next =follows.get(index);
            sb.append(next);
            //System.out.println(key);
            key = key.substring(1)+next;
            //returns a string with the characters of this string,
            //starting from startIndex and going to the end of this string
            
            //key = next;
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
