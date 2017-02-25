import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
1. Read each input line.
2. Split line into an array.
3. Take population and put it into a separate population array.
4. Sort population array largest to smallest.
5. Iterate through sorted population array and cities array. If population for that city matches current value from population array, then print that data to screen.
*/

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);

        //Skip first line:
        scan.nextLine();

        //Create storage lists:
        ArrayList<String> citiesAL = new ArrayList<String>();
        ArrayList<String> popAL = new ArrayList<String>();
        ArrayList<String> stateAL = new ArrayList<String>();

        //Read each line and add to storage lists:
        while(scan.hasNext()){
            String line = scan.nextLine();
            citiesAL.add(line);
            String[] lineArray = line.split("\\|");
            popAL.add(lineArray[0]);
            stateAL.add(lineArray[2]);
        }

        //Eliminate duplicates from populations list:
        Set popHS = new HashSet();
        popHS.addAll(popAL);
        popAL.clear();
        popAL.addAll(popHS);

        //Eliminate duplicates from states list:
        Set stateHS = new HashSet();
        stateHS.addAll(stateAL);
        stateAL.clear();
        stateAL.addAll(stateHS);

        //Sort populations list:
        int[] popArray = new int[popAL.size()];
        for(int n = 0; n < popAL.size(); n++){
            popArray[n] = Integer.valueOf(popAL.get(n));
        }
        Arrays.sort(popArray);

        //Alphabetize states list:
        Collections.sort(stateAL);

        //Reverse order of populations array:
        for(int p = 0; p < popArray.length / 2; p++){
            int temp = popArray[p];
            popArray[p] = popArray[popArray.length - p - 1];
            popArray[popArray.length - p - 1] = temp;
        }

        //Iterate through population list:
        for (int i = 0; i < popArray.length; i++) {
            System.out.println(String.valueOf(popArray[i]));
            System.out.println("");
            //Iterate through city data list:
            for (int s = 0; s < stateAL.size(); s++) {
                for (int j = 0; j < citiesAL.size(); j++) {
                    String cityLine = citiesAL.get(j);
                    String[] cityArray = cityLine.split("\\|");
                    //If population of city matches current population value and current state value:
                    if(cityArray[0].equals(String.valueOf(popArray[i]))){
                        if(cityArray[2].equals(stateAL.get(s))){
                            //Sort interstates:
                            String[] interstatesArray = cityArray[3].split("\\;");
                            int[] interstatesNumbers = new int[interstatesArray.length];
                            for (int m = 0; m < interstatesArray.length; m++) {
                                interstatesNumbers[m] = Integer.parseInt(interstatesArray[m].replace("I-",""));
                            }
                            Arrays.sort(interstatesNumbers);
                            String interstatesString = "Interstates: ";
                            for (int k = 0; k < interstatesNumbers.length; k++) {
                                interstatesString += "I-";
                                interstatesString += String.valueOf(interstatesNumbers[k]);
                                if(k != interstatesNumbers.length-1){
                                    interstatesString += ", ";
                                }
                            }
                            System.out.println(cityArray[1] + ", " + cityArray[2]);
                            System.out.println(interstatesString);
                            System.out.println("");
                        }
                    }
                }
            }
        }
    }
}