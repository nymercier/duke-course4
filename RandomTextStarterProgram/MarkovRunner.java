
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

public class MarkovRunner {
    
    public void runMarkovZero() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovZero markov = new MarkovZero();
        markov.setTraining(st);
        
        // but every time you run it you get the same text
        for(int k=0; k < 3; k++){
            markov.setRandom(1024);
            String text = markov.getRandomText(500);
            //String text =  void setRandom(int seed)
            printOut(text);
        }
    }
    
    public void runMarkovOne() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne markov = new MarkovOne();
        markov.setTraining(st);
        
        // but every time you run it you get the same text
        for(int k=0; k < 3; k++){
            markov.setRandom(365);
            String text = markov.getRandomText(250);
            //String text =  void setRandom(int seed)
            printOut(text);
        }
    }
    
    public void runMarkovFour () {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovFour markov = new MarkovFour();
        //String test = "this is a test yes this is a test.";
        //markov.setTraining(test);
        markov.setTraining(st);

        // but every time you run it you get the same text
        for(int k=0; k < 3; k++){
            markov.setRandom(715);
            String text = markov.getRandomText(250);
            //String text =  void setRandom(int seed)
            printOut(text);
        }
    }
    
    public void runMarkovFourtest () {
        MarkovFour markov = new MarkovFour();
        String test = "this is a test yes this is a test.";
        markov.setTraining(test);
        markov.setRandom(25);
        // but every time you run it you get the same text
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(50);
            //String text =  void setRandom(int seed)
            printOut(text);
        }
    }
    
    public void MarkovModel () {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovModel markov = new MarkovModel();
        //String test = "this is a test yes this is a test.";
        //markov.setTraining(test);
        markov.setTraining(st);
        
        // but every time you run it you get the same text
        for(int k=0; k < 3; k++){
            markov.setRandom(953);
            String text = markov.getRandomText(50,7);
            //String text =  void setRandom(int seed)
            printOut(text);
        }
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
