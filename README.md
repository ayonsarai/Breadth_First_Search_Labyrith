# BFS Algorithm for Shortest Path in a Maze in Java

# Algorithm: 

## BFS(Graph, start_node):
   * create a queue Q
   * mark start_node as visited
   * enqueue start_node into Q

   ## while Q is not empty:
       * current_node = dequeue Q
       * process current_node

       ## for each neighbor of current_node:
          * if neighbor is not visited:
              * mark neighbor as visited
              * enqueue neighbor into Q


# Algorithm Steps:

Initialize a queue and add the starting cell to it.

Initialize a 2D array to keep track of visited cells.

For each cell, explore its neighbors (up, down, left, right).

If a neighbor is the destination, return the path length.

If a neighbor is an open path and hasn't been visited, mark it as visited and add it to the queue.

Repeat until the queue is empty or the destination is found.


# Explanation:


# Initialization:

DIRECTIONS array defines the four possible movements (up, down, left, right).
VISITED array tracks which cells have been visited to prevent re-processing.
QUEUE is initialized with the starting position and an initial distance of 0.

# BFS Process:
WHILE the queue is not empty, the algorithm processes each cell.
FOR each cell, it checks if it has reached the destination.
IF THEN explores all valid neighbors and adds them to the queue with an incremented distance.

# Helper Function:
isValid checks if a cell is within the bounds of the maze, is an open path, and has not been visited.

# This implementation ensures that the shortest path in an unweighted maze is found efficiently using BFS.
