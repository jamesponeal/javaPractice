/*
1. Read each input line.
2. Create an interstates hashmap.
3. Isolate interstates from city data and iterate through them.
4. If interstate does not exist is hashmap, add iterstate as key and set value to 1. Else if it already exists in hashmap, add 1 to the count.
*/

public class Solution {
    public static void main(String args[] ) throws Exception {

        Scanner scan = new Scanner(System.in);

        //Skip first line:
        scan.nextLine();

        //Create storage lists:
        ArrayList<String> interstatesAL = new ArrayList<String>();
        Map<Integer, Integer> interstatesMap = new TreeMap<Integer, Integer>();

        //Read each line and isolate interstate numbers in an ArrayList:
        while(scan.hasNext()){
            String line = scan.nextLine();
            String[] lineArray = line.split("\\|");
            String[] iArray = lineArray[3].split("\\;");

            for (int m = 0; m < iArray.length; m++) {
                interstatesAL.add(iArray[m].replace("I-",""));
            }
        }

        //Sort interstates list:
        int[] interstatesArray = new int[interstatesAL.size()];
        for(int n = 0; n < interstatesAL.size(); n++){
            interstatesArray[n] = Integer.valueOf(interstatesAL.get(n));
        }
        Arrays.sort(interstatesArray);

        //Iterate through interstates list, if not already in interstates map, add it, otherwise increase count:
        for(int i = 0; i < interstatesArray.length; i++){
            if(interstatesMap.get(interstatesArray[i]) == null){
                interstatesMap.put(interstatesArray[i], 1);
            } else {
                interstatesMap.put(interstatesArray[i], interstatesMap.get(interstatesArray[i]) + 1);
            }
        }

        //Iterate through interstates map, print key and value:
        for (Integer key : interstatesMap.keySet()) {
           System.out.println("I-" + key + " " + interstatesMap.get(key));
        }
    }
}