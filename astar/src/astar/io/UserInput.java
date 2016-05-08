package astar.io;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class UserInput {
    
    private Scanner scanner;
    
    public UserInput(){
        scanner = new Scanner(System.in);
    }
    
    public ArrayList<Integer> getInitialState(){
        
        //Prompt the user for for row/column size
        //Sys.out("Row size...")
        //scanner.nextInt();
        int rowSize = 3;
        
        //Calculate max number for here
        int maxInput = rowSize * rowSize - 1;
        
        //Prompt the user for initial state
        System.out.println("Please input the state of the puzzle (ints separated by spaces):");
        
        //Get the single line of input
        //Could change this in the future to read from a file
        String input = scanner.nextLine();
        //Split the values by whitespace and save it into a list
        List<String> vals = new ArrayList<String>(Arrays.asList(input.split("\\s+")));
        
        
         
        //Create the set
        Set<Integer> nums = new HashSet<>();
        ArrayList<Integer> ret = new ArrayList<>();
        
        //Iterate through vals, inputting into the set
        for(String val : vals){
            int num = -1;
            
            try{
                num = Integer.parseInt(val);
            }catch(NumberFormatException nfe){
                System.out.println("The string " + val + " was passed in, and it is " +
                " not convertible to an int. \nMake sure you are passing valid ints in.");
                return getInitialState();
            }
            
            //Check that num is less than max
            if (num > maxInput || num < 0) {
                System.out.println("The number " + num + " is out of range.");
                return getInitialState();
            }
            
            //Insert into the set and see if return value indicates value 
            //is already in the set.
            if(!nums.add(num)){
                System.out.println("The number " + num + " was input already."
                + " Duplicates are not permitted.");
                return getInitialState();
            }
            
            //insert into our return data structure
            ret.add(num);
        }
        
        //Check length of vals
        if (vals.size() != maxInput + 1) {
            System.out.println("You must input " + (maxInput + 1) + " numbers to fill the puzzle.");
            getInitialState();
        }
        
        return ret;
    }
}