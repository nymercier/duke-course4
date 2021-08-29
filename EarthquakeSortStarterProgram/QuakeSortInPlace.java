
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
       }
        
    }

    public void testSortMagnitude () {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/earthQuakeDataDec6sample2.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        sortByMagnitude(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                              qe.getLocation().getLatitude(),
                              qe.getLocation().getLongitude(),
                              qe.getMagnitude(),
                              qe.getInfo());
        }
    }
    
    public int getLargestDepth (ArrayList<QuakeEntry> quakeData, int from) {
        int maxIdx = from;
        for (int i=from+1; i< quakeData.size(); i++) {
            if (quakeData.get(i).getDepth() > quakeData.get(maxIdx).getDepth()) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    public void sortByLargestDepth (ArrayList<QuakeEntry> in) {
       
        //for (int i=0; i< in.size(); i++) {
        for (int i=0; i<70; i++) {
            System.out.println("i"+i);
            int maxIdx = getLargestDepth (in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmax = in.get(maxIdx);
            in.set(i,qmax);
            in.set(maxIdx,qi);
        }
        
    }

    public void testSortDepth() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/earthQuakeDataDec6sample2.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        sortByLargestDepth(list);
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
        //int quakeNumber = 70;
        //System.out.println("Print quake entry in position " + quakeNumber);
        //System.out.println("Print name " + source);
        //System.out.println(list.get(quakeNumber));
    }
    
    public void onePassBubbleSort (ArrayList <QuakeEntry> quakeData, 
                                   int numSorted) {
        //sortByMagnitude(quakeData);
        //numSorted = 0;
        //for (int j=0; j<numSorted; j++) {
            //System.out.println("Printing Quakes after pass "+j);
            for (int i=0; i<numSorted; i++) {
                double first = quakeData.get(i).getMagnitude();
                double second = quakeData.get(i+1).getMagnitude();
                QuakeEntry st = quakeData.get(i);
                QuakeEntry sec = quakeData.get(i+1);
                if (first < second) {
                    quakeData.set(i,st);
                    quakeData.set(i+1,sec);
                }
                else {
                    quakeData.set(i,sec);
                    quakeData.set(i+1,st);
                }
            }
    }
    
    public void sortByMagnitudeWithBubbleSort (ArrayList <QuakeEntry> in) {
        int numElement = in.size();
        int num = numElement-1;
        
        for (int j=0; j<num; j++) {
            onePassBubbleSort(in, num);
            System.out.println("Printing Quakes after pass "+j);
            for (QuakeEntry qe: in) { 
                System.out.println(qe);
            }
        }
    }
    
    //testSort() ici
    public void testSortMagBubble() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/earthQuakeDataDec6sample2.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");   
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        sortByMagnitudeWithBubbleSort(list);
        System.out.println("EarthQuakes in sorted order:");
        for (QuakeEntry qe: list) { 
            //System.out.println(qe);
        } 
    }
    
    public boolean checkInSortedOrder (ArrayList<QuakeEntry> quakes) {
        for (int i=0; i<quakes.size()-1; i++) {
            if (quakes.get(i).getMagnitude() > quakes.get(i+1).getMagnitude()) {
                //System.out.println(i);
                return false;
            }
        }
        return true;
    }
   
    
    public void sortByMagnitudeWithBubbleSortWithCheck (ArrayList<QuakeEntry> in) {
        int numElement = in.size();
        int num = numElement-1;
                
        for (int j=0; j<num; j++) {
            if (checkInSortedOrder(in)==true) {
                System.out.println("Printing Quakes after pass "+j);
                break;
            }
            else {
                onePassBubbleSort(in, num); 
            }
        }
    }
    
    //testsort()
    public void testsortByMagnitudeWithBubbleSortWithCheck() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "data/earthquakeDataSampleSix2.atom";
        String source = "data/earthQuakeDataWeekDec6sample2.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");   
        
        System.out.println("EarthQuakes at beginning :");
        for (QuakeEntry qe: list) { 
            //System.out.println(qe);
        } 
        
        sortByMagnitudeWithBubbleSortWithCheck(list);
        
        System.out.println("EarthQuakes in sorted order:");
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
    }
    
  
    public void sortByMagnitudewithcheck (ArrayList<QuakeEntry> in) {
       
        for (int i=0; i< in.size(); i++) {
            
            if (checkInSortedOrder(in)==true) {
                System.out.println("Printing Quakes after pass "+i);
                break;
            }
            else {
                    int minIdx = getSmallestMagnitude(in,i);
                    QuakeEntry qi = in.get(i);
                    QuakeEntry qmin = in.get(minIdx);
                    in.set(i,qmin);
                    in.set(minIdx,qi);
                }
            }
        
        }
    
    
    public void testsortByMagnitudeWithCheck() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/earthQuakeDataWeekDec6sample2.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        
        sortByMagnitudewithcheck(list);
        
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
    }
}
