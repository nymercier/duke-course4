
/**
 * Write a description of EfficientMarkovWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
import edu.duke.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class EfficientMarkovWord implements IMarkovModel {
    
    private String [] myText;
    private Random myRandom;
    private int myOrder;
    
    private HashMap <WordGram, ArrayList<String>> myMap;
    
    public EfficientMarkovWord (int myOrder) {
        myRandom = new Random();
        this.myOrder = myOrder;
    }
    
    public String toString() {
        return "EfficientMarkovWord order " + myOrder;
    }
     
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    
    public void setTraining(String text) {
        myText = text.split("\\s+");
        //System.out.println(Arrays.toString(myText));
        buildMap();
        printHashMapInfo();
    }
    
    private int indexOf (String[] words, WordGram target, int start) {
        int size = myOrder;
        for(int i = start; i < words.length-size; i++) {
            WordGram wg = new WordGram(words,i,size);
            if (wg.equals(target)) {
                return i;
            }
        }
        return -1;
    }
    

    private ArrayList<String> getFollows (WordGram  kGram) {
        ArrayList<String> follows = new ArrayList<String>();
        int index = indexOf(myText, kGram, 0);
        while (index!=-1) {
            //int curr = index+myOrder;
            follows.add(myText[index+myOrder]);
            index = indexOf(myText, kGram, index+1);
        }
        return follows;
    }
        
    public String getRandomText (int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  
        WordGram key = new WordGram(myText,index,myOrder);
        
        sb.append(key.toString());
        sb.append(" ");
        
        for(int k=0; k < numWords-myOrder; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0 || follows == null) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            //System.out.println("key "+key+" array "+ follows);
            key = key.shiftAdd(next);
        }
        return sb.toString().trim();
    }
    
    private void buildMap() {
        myMap = new HashMap <WordGram, ArrayList<String>>();
        
        //for (int i = 0; i < myText.length-myOrder; i++) {
        for (int i = 0; i < myText.length-myOrder; i++) {
            WordGram key = new WordGram(myText,i,myOrder);
            //System.out.println("wordgram key\t" + key);
            String follow = myText[i+key.length()];
            //System.out.println("follow\t" + follow);
            
            //ArrayList<String> getFollows (WordGram  kGram)
            if (myMap.containsKey(key)) {
                myMap.get(key).add(follow);
            }
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(follow);
                myMap.put(key, list);
            }
        }
        
        WordGram key = new WordGram(myText,myText.length-myOrder,myOrder);
        if (!myMap.containsKey(key)) {
            ArrayList<String> list = new ArrayList<String>();
            //list.add("");
            myMap.put(key, list);
        }
    }
    
    public ArrayList<String> getFollows(String key) {
        return myMap.get(key);
    }
    
    
    public void printHashMapInfo () {
        for (WordGram s : myMap.keySet()) {
            //System.out.println("key \t"+s + "\t"+myMap.get(s));
        }
        System.out.println("number of keys in the HashMap " + myMap.size());
        System.out.println("MAX " + longestFollowsSize());
    }
    
    
    public int longestFollowsSize() {
        int max = 0;
        for (WordGram s : myMap.keySet()) {
            if (max < myMap.get(s).size()){
                max = myMap.get(s).size();
            }
            //myMap.get(s).size();
        } 
        return max;
    }
    
    
}
