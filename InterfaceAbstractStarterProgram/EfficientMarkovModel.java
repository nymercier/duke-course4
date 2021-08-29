
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
import java.util.*;

public class EfficientMarkovModel extends AbstractMarkovModel {
    //private int order;
    private HashMap <String, ArrayList<String>> myMap;
    
    public EfficientMarkovModel (int order) {
        super(order);
        myMap = new HashMap <String, ArrayList<String>>();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        super.setTraining(s);
        buildMap();
        printHashMapInfo();
    }
    
    //private HashMap <String, ArrayList<String>> myMap;
    
    private String getKey(int index) {
        return myText.substring(index, index + order);
    }
    
    private String getFollowingLetter(int index) {
        return myText.substring(index+order, index+order+1);
    }
    
    private void buildMap() {

        for (int i = 0; i < myText.length() - order; i++) {
            String key = getKey(i);
            String follow = getFollowingLetter(i);
            if (myMap.containsKey(key)) {
                myMap.get(key).add(follow);
            }
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(follow);
                myMap.put(key, list);
            }
        }

    }
    
    public ArrayList<String> getFollows(String key) {
        return myMap.get(key);
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
            System.out.println("key "+key+" "+follows);
            //System.out.println(index);
            if (follows == null) {
                break;
            }

            index = myRandom.nextInt(follows.size());
            String next =follows.get(index);
            sb.append(next);
            //System.out.println(key);
            key = key.substring(1)+next;
        }
        return sb.toString();
    }
    
    public void printHashMapInfo () {
        //for (String s : myMap.keySet()) {
            //System.out.println(s+myMap.get(s));
        //}
        System.out.println("number of keys in the HashMap " + myMap.size());
        System.out.println("MAX " + longestFollowsSize());
    }
    
    
    public int longestFollowsSize() {
        int max = 0;
        for (String s : myMap.keySet()) {
            if (max < myMap.get(s).size()){
                max = myMap.get(s).size();
            }
            //myMap.get(s).size();
        } 
        return max;
    }
    
    public String toString() {
        return "Efficient Markov Model order " + order;
    }
}
