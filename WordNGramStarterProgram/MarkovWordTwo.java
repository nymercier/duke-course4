
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWordTwo implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int order;
    
    public MarkovWordTwo(int order) {
        myRandom = new Random();
        this.order = order;
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
        myText = text.split("\\s+");
    }
    
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-order);  // random word to start with
        
        String key1 = myText[index];
        String key2 = myText[index+1];
        
        sb.append(key1);
        sb.append(" ");
        sb.append(key2);
        sb.append(" ");
        
        for(int k=0; k < numWords-order; k++){
            ArrayList<String> follows = getFollows(key1, key2);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            System.out.println("key "+key1+" key "+key2+" array "+ follows);
            
            key1 = key2;
            key2 = next;
        }
        
        return sb.toString().trim();
    }
    
    private int indexOf (String[] words, String target1, String target2, int start) {
        //start = 0;
        for (int k=start; k<words.length-order; k++){
            if (words[k].equals(target1) && words[k+1].equals(target2)) {
                return k;
            }
        }
        return -1;
    }
    
    private ArrayList<String> getFollows(String key1, String key2) {
        
        ArrayList<String> follows = new ArrayList<String>();
        int index = indexOf(myText, key1, key2, 0);
        
        while (index!=-1) {
            follows.add(myText[index+order]);
            index = indexOf(myText, key1, key2, index+1);
        }
        
        return follows;
    }
    
    public void testindexof() {
        String st = "this is just a test yes this is a simple test"; 
        st = st.replace('\n', ' '); 
        MarkovWordOne markovWord = new MarkovWordOne(); 
        MarkovRunner run = new MarkovRunner();
        run.runModel(markovWord, st, 2); 
        //System.out.println(indexOf(array,"simple",5));
    }
    
}
