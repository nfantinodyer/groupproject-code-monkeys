# COMP55GroupProject

Maze monkey game

Run in java and follow the on screen prompts to play this simple java graphics game.

#comp 55 res
The first commit must provide new file (README.md) that will have two sections, the first being the overview of the feature that you are implementing and a second section called pseudocode that will provide the pseudocoding process for this feature - as outlined in chapter 9 of code complete or what was mentioned in lecture.  You can edit that file or create it directly on GitHub.  The other 4+ commits must come on across at least two different days.  

#overview
My goal/issue to fix my comp55 group project was to use a file to make the code easier to read in level.java. To begin, I had to think of how I could make it easier to read and still utalize my old code. I didn't want to have it send information to a file to have it read it later as it would just add extra unnessisary code, so I did it manually. I put in the x,y value into the file for each wall position only for the hard map. I used file reader and buffered reader to read the file and put it into a array list. I then used a for loop to iterate through the arraylist and set the wall positions.

#psudocode

ArrayList;
Read "wall_positions.txt";
while line != null {
    x = 0;
    y = 1;
    wallPositions.add(x, y);
    }

for wallPositions {
    map.addEntity(x,y);
    walls.add(x,y);
}

#it works
It prints the same map as it did with the super long and hard to read code, but now it's easier to edit. 
