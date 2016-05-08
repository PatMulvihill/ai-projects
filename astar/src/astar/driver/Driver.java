package astar.driver;

//Local Imports
import astar.util.Board;
import astar.util.Tile;
import astar.io.UserInput;

//Java imports 
import java.util.ArrayList;

public class Driver{
    
    public static void main(String [] args){
        
        Board goalBoard = new Board();
        
        Board b = new Board();
        
        //Create a new user input object and get the state
        int i = 0;
        UserInput ui = new UserInput();
        for(int num : ui.getInitialState()){
            Tile tile = new Tile(num, i);
            b.insert(tile);
            ++i;
        }
        
        System.out.println(b.calcManDistance());
        
        
        //b.tiles.stream()
         //   .forEach(tile -> System.out.println(tile));
        b.getValidBoards();
    }
}