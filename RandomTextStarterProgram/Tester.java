
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
import edu.duke.*;
import java.io.*;
import java.util.ArrayList;

public class Tester {
    
    public void testGetFollows () {
        MarkovOne markov = new MarkovOne();
        String test = "this is a test yes this is a test.";
        markov.setTraining(test);
        //System.out.println(markov.setTraining(test));
        String key = "t";
        markov.getFollows(key);
        System.out.println(markov.getFollows(key));
        System.out.println("key "+key);
        System.out.println("nb de fois "+ ((markov.getFollows(key)).size()));
    }
    
    public void testGetFollowsWithFile () {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne markov = new MarkovOne();
        markov.setTraining(st);
        
        String key = "o";
        markov.getFollows(key);
        System.out.println(markov.getFollows(key));
        System.out.println("key "+key);
        System.out.println("nb de fois "+ ((markov.getFollows(key)).size()));
    }
    
    public void testGetFollowsMarkovFour () {
        MarkovFour markov = new MarkovFour();
        String test = "this is a test yes this is a test.";
        markov.setTraining(test);
        //System.out.println(markov.setTraining(test));
        String key = "t";
        markov.getFollows(key);
        System.out.println(markov.getFollows(key));
        System.out.println("key "+key);
        System.out.println("nb de fois "+ ((markov.getFollows(key)).size()));
    }
}
