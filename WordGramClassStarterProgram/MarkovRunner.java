
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 2; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            markov.setRandom(seed);
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runMarkov() { 
        FileResource fr = new FileResource(); 
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        MarkovWord markovWord = new MarkovWord(2); 
        runModel(markovWord, st, 200); 
    } 
    
    public void testrunseedMarkov() { 
        FileResource fr = new FileResource(); 
        //String st = "this is a test this is a test
        
        //this is a test of words";
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        MarkovWord markovWord = new MarkovWord(5); 
        runModel(markovWord, st, 250, 844); 
    }
    
    public void testeffMarkov() { 
        FileResource fr = new FileResource(); 
        //String st = "this is a test yes this is really a test yes a test this is wow";
        //String fr = "yes-this-is-a-thin-pretty-pink-thistle";
        
        //this is a test of words";
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        EfficientMarkovWord markovEff = new EfficientMarkovWord(6); 
        runModel(markovEff, st, 250, 792); 
    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println(); 
                psize = 0;
            } 
        } 
        System.out.println("\n----------------------------------");
    } 

}
