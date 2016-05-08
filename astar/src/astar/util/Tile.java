package astar.util;

import java.lang.Comparable;


public class Tile implements Comparable{
    
    public int location;
    public int id;
    
    
    public Tile(){}
    
    public Tile(int idIn, int locationIn){
        id = idIn;
        location = locationIn;
    }
    
   public int getLocation(){
       return location;
   }
   
   public int xCoord(){
       return location % 3;
   }
   
   public int yCoord(){
       if(location < 3){
           return 0;
       }else if(location < 6){
           return 1;
       }else{
           return 2;
       }
   }
   
    
    @Override
    public int compareTo(Object o){
        //Implement
        
        /*
        PQueue frontier<Board>;
        
        frontier.enqueue(initialState);
        while(frontier.peek().manDist() > 0)
            Board b = q.pop();
            
            //put all of t's children into frontier
            //every valid move needs to be put into frontier
            for(Board b2 : b.validMoves()){
                frontier.enqueue(b2);
            }
            
            //Get the nodes with the best manDist
            while(q.peek().manDist == t.manDist)
                //Save them all to be explored
                unexp.add(q.pop());
        */
        return -1;
    }

    @Override
    public String toString(){
        return "Tile: \n" +
            "Id: " + id + "\n" +
            "Location: " + location;
    }
    
    @Override
    public boolean equals(Object obj){
        Tile rhs = (Tile) obj;
        return (id == rhs.id && location == rhs.location);
    }
}