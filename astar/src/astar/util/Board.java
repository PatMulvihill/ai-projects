package astar.util;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.lang.StringBuilder;

public class Board{
    
    public List<Tile> tiles;
    
    public Board(){
        tiles = new ArrayList<>();
    }
    
    public void insert(Tile b){
        tiles.add(b);
    }
    
    /**
     * Calculate the manhattan distance of the state.
     * Uses a formula of the form: 
     * Running sum i in range [1 -> 9) of:
     * Abs(XiCurr - XiGoal) + Abs(YiCurr YiGoal)
     * @return int the manhattan distance of the board
     */
    public int calcManDistance(){
        
        int dist = 0;
        
        //xy coords for both current tile and goal tile
        Tile curr = null;
        Tile goal = null;
        
        int xDist = 0;
        int yDist = 0;
        
        //Loop through tiles from 1-8
        for(int i = 1; i <= 8; ++i){
            //get current tile and x/y coords
            curr = getTile(i);
            goal = goalState.getTile(i);
            
            //Subtract the current x position from goal position
            xDist = goal.xCoord() - curr.xCoord();
            
            //Do the same for y
            yDist =   goal.yCoord() - curr.yCoord();      
            
            //Sum it into the distance
            dist += Math.abs(xDist) + Math.abs(yDist);            
        }
        
        return dist;
    }
    
    
    
    /**
     * Return the tile requested of.
     */
     public Tile getTile(int id){
         Tile t = tiles.stream()
            .filter(tile -> tile.id == id)
            .collect(Collectors.toList()).get(0);
        return t;
     }
     
    /*
    *   Deprecated not really sure if this method is necessary
    */
    public ArrayList<Board> getValidBoards(){
        ArrayList<Board> ret = new ArrayList<>();

        //Get the location of current 0 tile
        int location = tiles.stream()
                            .filter(tile -> tile.id == 0)
                            .collect(Collectors.summingInt(Tile::getLocation));
        
        int[] moves = validMoves.get(location);
        
        return ret;      
    }
    
    public Board swap()
    {
        
        return new Board();
    }
    

    /**
     * Compare two boards tile state.
     */
    @Override
    public boolean equals(Object obj){
        Board rhs = (Board) obj;
        
        //Compare the two array lists
        for(int i = 0; i < tiles.size(); ++i){
            if(!tiles.get(i).equals(rhs.tiles.get(i))){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        tiles.stream()
            .forEach(tile -> ret.append(tile + "\n"));        
        return ret.toString();
    }
    
    /**
     * A couple of static data structures.
     * Not sure if we need valid moves anymore.
     */
    public static HashMap<Integer, int []> validMoves;
    static {
    validMoves = new HashMap<>();
        //Insert the values
        validMoves.put(0, new int[]{1, 3});
        validMoves.put(1, new int[]{0,2,4});
        validMoves.put(2, new int[]{1, 5});
        validMoves.put(3, new int[]{0, 4, 6});
        validMoves.put(4, new int[]{1, 3, 5, 7});
        validMoves.put(5, new int[]{2, 4, 8});
        validMoves.put(6, new int[]{3, 7});
        validMoves.put(7, new int[]{4, 6, 8});
        validMoves.put(8, new int[]{5, 7});
    }
    
    /**
     * The goal state board, just tiles in order.
     */
    public static Board goalState;
    static {
        goalState = new Board();
        for(int i = 0; i < 9; ++i){
            goalState.insert(new Tile(i, i));
        }
    }
    
    

}

    
        
    // public int manhattanHeuristic() {

    //     int sum = 0;
    //     // ArrayList<Tile> tiles = board.getTiles();
    //     Tile goalState;
    //     int goalX;
    //     int goalY;
    //     int differenceX;
    //     int differenceY;
    
    //     for(Tile tile: tiles){
    
    //         if(tile.getNumber() != 0) {
    //             goalState = goalBoard.findTile(tile.getNumber());
    //             goalX = goalState.getXPosition();
    //             goalY = goalState.getYPosition();
    
    //             differenceX = goalX - tile.getXPosition();
    //             differenceY = goalY - tile.getYPosition();
    
    //             sum += Math.abs(differenceX) + Math.abs(differenceY);
    //         }
    
    //     }
    
    //   return sum;
    // }
    