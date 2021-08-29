
/**
 * Write a description of interface IMarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface IMarkovModel {
    // common practice
    
    public void setTraining(String text);
    
    public String getRandomText(int numChars);
    
    public void setRandom(int seed);
    
    //public void IMarkovModel.toString();
}
