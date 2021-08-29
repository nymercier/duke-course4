
/**
 * Write a description of MarkovWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import java.util.Random;
import edu.duke.*;
import java.io.*;
import java.util.ArrayList;

public class MarkovWord implements IMarkovModel {
    
    private String [] myText;
    private Random myRandom;
    private int myOrder;
    
    public MarkovWord (int myOrder) {
        myRandom = new Random();
        this.myOrder = myOrder;
    }
    
    public String toString() {
        return "MarkovWord order " + myOrder;
    }
     
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text) {
        myText = text.split("\\s+");
    }
    
    private int indexOf (String[] words, WordGram target, int start) {
        //start = 0;
        //ArrayList<WordGram> list = new ArrayList<WordGram>();
        int size = myOrder;
        
        for(int i = start; i < words.length-size; i++) {
            WordGram wg = new WordGram(words,i,size);
            //list.add(wg);
            //System.out.println("mot: "+index+" "+list.get(index));
            if (wg.equals(target)) {
                // equals is a custom method
                //System.out.println("matched at "+k+" "+list.get(k));
                return i;
            }
        }
        return -1;
    }
    
    public void testindexof() {
        String source = "Alo, ici, mon chat. Miaou. The getRandomText method has one integer parameter named numWords"; 
        
        String[] words = source.split("\\s+");
        int size = myOrder;
        int index = 3;
        WordGram wg = new WordGram(words,index,size);
    
        MarkovWord markovWord = new MarkovWord(3); 
        int réponse = indexOf(words, wg, 0);
        
        //run.runModel(markovWord, st, 56); 
        System.out.println("testindexof() "+réponse);
    }

    private ArrayList<String> getFollows (WordGram  kGram) {
        ArrayList<String> follows = new ArrayList<String>();
        //System.out.println("getFollows() + kGram "+kGram);
        int index = indexOf(myText, kGram, 0);
        //int réponse = indexOf(words, wg, 0); 
        //System.out.println("getFollows() + position "+index);
        //private int indexOf (String[] words, WordGram target, int start)
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
        // random word to start with,String key = myText[index];
        
        WordGram key = new WordGram(myText,index,myOrder);
        
        sb.append(key.toString());
        sb.append(" ");
        //System.out.println(sb);        

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
}

