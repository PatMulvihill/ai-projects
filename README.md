Project 2 (Extra Credit)        
CMPT 463 Artificial Intelligence
Due: May 10, 2016 Tuesday           
Spring 2016

Write a program in either C++ or Java to solve the 8-puzzle problem 
with A* search algorithm using Manhattan distance heuristic.
The goal state of the puzzle is shown below.
 
The initial state should be entered from the input. Test your program with at 
least one easy initial state and one hard initial state.
Your output should show the number of steps it takes from the initial state of 
the puzzle to the goal state. Your solution should also include the action 
(or state) of each step.

Submit the followings to Moodle (lms.manhattan.edu):
• Readme.txt (Readme.doc) should contain the project number, problem and
        algorithm description and input and output format.
        You should also include necessary explanations to any data structures
        or functions used in the code.
• Zip package of source code and executable files. If you are using any
        C++ or Java IDE, zip the project folder and submit it to Moodle.


Goal state:

[ ] [1] [2]
[3] [4] [5]
[6] [7] [8]

http://home.manhattan.edu/~tina.tian/CMPT463.html
Relevant slides:  CMPT463_06 (slides 15 - 36)

Pseudo Code for A*
// A*

initialize the open list
initialize the closed list
put the starting node on the open list (you can leave its f at zero)

while the open list is not empty
    find the node with the least f on the open list, call it "q"
    pop q off the open list
    generate q's 8 successors and set their parents to q
    for each successor
    	if successor is the goal, stop the search
        successor.g = q.g + distance between successor and q
        successor.h = distance from goal to successor
        successor.f = successor.g + successor.h

        if a node with the same position as successor is in the OPEN list \
            which has a lower f than successor, skip this successor
        if a node with the same position as successor is in the CLOSED list \ 
            which has a lower f than successor, skip this successor
        otherwise, add the node to the open list
    end
    push q on the closed list
end



###Packages and classes


#####Driver
src/driver/
    Driver.java

#####AStar
src/astar/
    
#####util
src/util/
    Box.java

#####io
src/util/
    UserInput.java
    
    
    
    
    
###To make sure java is working

source ~/.bashrc
