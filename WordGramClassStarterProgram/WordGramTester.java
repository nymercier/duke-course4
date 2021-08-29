import java.util.*;
import java.util.ArrayList;
import edu.duke.*;
import java.io.*;

public class WordGramTester {
    
    public void testWordGram(){
        //The void method testWordGram builds and prints several WordGrams from a String.
        
        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        //System.out.println("Array "+Arrays.toString(words));
        int size = 4;
        for(int index = 0; index <= words.length - size; index ++) {
            WordGram wg = new WordGram(words,index,size);
            wg.shiftAdd("yes");
            System.out.println(index+"\t"+wg.length()+"\t"+wg);
        }

    }
    
    public void testWordGramEquals(){
        //The void method testWordGramEquals tests if two WordGrams are equivalent. 

        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        
        ArrayList<WordGram> list = new ArrayList<WordGram>();
        int size = 4;
        
        for(int index = 0; index <= words.length - size; index += 1) {
            WordGram wg = new WordGram(words,index,size);
            list.add(wg);
        }
        
        WordGram first = list.get(0);
        System.out.println("checking "+first);
        
        for(int k=0; k < list.size(); k++){
            //if (first == list.get(k)) {
              if (first.equals(list.get(k))) {
                  // equals is a custom method
                System.out.println("matched at "+k+" "+list.get(k));
            }
        }
    }
    
    public void testShiftAdd() {
        String source = "what a cat. is a test this is a test of words";
        String[] words = source.split("\\s+");
        int size = 4;
	int index = 0;
	WordGram wg = new WordGram(words,index,size);
		
	System.out.println("Original:\t"+wg);
	System.out.println("Shifted:\t"+wg.shiftAdd("LOL"));
    }
    
    public void testHashCode () {
        String source = "Hello world";
        String[] words = source.split("\\s+");
        int size = 1;
	int index = 0;
	WordGram wg = new WordGram(words,index,size);
	
	int réponse = wg.hashCode();
	
	System.out.println("int hashcode:\t"+wg+" "+ réponse);
    }
}
