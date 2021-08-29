import java.util.*;
import java.util.ArrayList;
import edu.duke.*;
import java.io.*;

public class WordGram {
    private String[] myWords;
    //array of strings
    private int myHash;

    public WordGram (String[] source, int start, int size) {
        myWords = new String[size];
        //System.out.println("Array "+Arrays.toString(myWords));
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt (int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        return myWords.length;
    }

    public String toString(){
        String ret = "";
        for (int i=0; i<myWords.length; i++) {
            ret += myWords[i]+" ";
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        // compare me to other
        if (this.length() != other.length()) {
            return false;
        }
        
        for (int i=0; i < myWords.length ; i++) {
            if (!myWords[i].equals(other.wordAt(i))) {
                return false;
            }
        }
        return true;

    }

    public WordGram shiftAdd (String word) {    
        //WordGram out = new WordGram (String[] source, int start, int size) 
        
        String[] words = new String[myWords.length];
        //System.out.println(".shiftAdd length of my Words "+myWords.length);
        
        for (int i=0; i < myWords.length-1; i++) {
            words[i] = myWords[i+1];
        }
        
        words[myWords.length-1]=word;
        
        //System.out.println(".shiftAdd array of words "+ Arrays.toString(words));
        
        WordGram out = new WordGram (words, 0, words.length);         
        return out;
    }
    
    public int hashCode () {
        //WordGram wg = new WordGram(myWords, start, size);
        return this.toString().hashCode();
        //String myHashtostring = wg.toString();
        //return myHash;
    }
}