# The Great Vacuum Race
A two-player game where each player (vacuum) needs to earn as many points as possible by collecting dust.

## Description

The game board is a 2-dimensional grid. Each cell in this grid represents either
 a section of hallway, a piece of wall, or a dumpster. There are two players in 
 this game — two vacuums. Some of the cells are dirty: they contain dirt or dustballs.
  The vacuums’ objective is to clean up as many dirty cells as possible. The dirt
   is stationary, but the dustballs move about the grid and each cell that a dustball
    visits becomes dirty (if it wasn’t already) when the dustball leaves. The image
     above shows the initial state of the vacuum game. Notice the two vacuums,
 16 dirty cells, four dustballs, and three dumpsters.

Vacuum 1 moves left when the user presses the 'a' key, moves right on the 'd' key,
 moves up on the 'w' key and moves down on the 's' key. Similarly, vacuum 2 moves
  left on the 'j' key, moves right on the 'l' key, moves up on the 'i' key and 
  moves down on the 'k' key.

A vacuum cannot move onto the other vacuum (or a wall, of course), but can move 
onto dirt, a dust ball, a dumpster (or clean hallway, of course). After a vacuum
 moves, if there are dustballs, they move randomly.

Each time a vacuum cleans dirt, the vacuum’s score is incremented; the vacuum 
earns 1 point for cleaning a dirt, and 2 points for cleaning a dustball.

Each vacuum has a capacity. Cleaning up dirt or a dustball adds a constant amount
 to the fullness of the vacuum. When a vacuum becomes full, it cannot clean any 
 more dirt; it can still go to dirty hallways, but it has no effect on the dirt 
 that is there. A vacuum that enters a cell with a dumpster is emptied (i.e., it
  has zero fullness); thus, if a vacuum is full, in order to resume cleaning dirt,
   it must visit a dumpster. Dumpsters have no limit on their capacity.
The game ends when all dirt (including dustballs) is gone. The vacuum with the 
higher score wins, or, if the two scores are equal, we declare a tie.

## Usage
From the vacuum_race directory, execute the following in the terminal:
```
$ cd src
$ javac *.java
$ javac game/Play.java
$ java game.Play

```
Player 1:
* Move left: 'a'
* Move right: 'd'
* Move up: 'w'
* Move down: 's'

Player 2:
* Move left: 'j'
* Move right: 'l'
* Move up: 'i'
* Move down: 'k'

## Built With
* Java

## Author
* Nana Nosirova
