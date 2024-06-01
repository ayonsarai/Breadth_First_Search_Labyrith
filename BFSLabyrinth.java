/* Sarai Ayon
 * 6/1/2024
 * CS 240 Data base structures and algorithms 
 * Algorithms HW 8 Breadth First Search, pick an example of where BFS would be an ideal application and write an algorithm for that application. */
//Breadth First Search (BFS) is an algorithm for traversing or searching tree or graph data structures. 
// It starts at the tree root, and explores all of the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level.
//BFS is an ideal application for finding the shortest path in an unweighted graph.
// The algorithm is implemented using a queue data structure.


import java.util.LinkedList;
import java.util.Queue;

public class BFSLabyrinth {
    // Directions for moving up, down, left, right
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // Maze is represented as a 2D array where 0's are open cells and 1's are walls
    public static void main(String[] args) {
        int[][] maze = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0}
        }; // 0's are open cells and 1's are walls
        // Start position
        int[] start = {0, 0};
        // End position
        int[] end = {4, 4};
        // Find the shortest path from start to end
        int shortestPathLength = bfsShortestPath(maze, start, end);
        System.out.println("The shortest path length is: " + shortestPathLength); // Shortest Path Output: 8
    } 
    // Find the shortest path from start to end in a maze
    public static int bfsShortestPath(int[][] maze, int[] start, int[] end) { 
        int rows = maze.length;// number of rows in the maze
        int cols = maze[0].length; // number of columns in the maze
        boolean[][] visited = new boolean[rows][cols]; // visited cells in the maze
        
        // BFS to find the shortest path
        Queue<int[]> queue = new LinkedList<>(); // queue for BFS
        queue.add(new int[]{start[0], start[1], 0}); // add the start cell to the queue
        visited[start[0]][start[1]] = true; // mark the start cell as visited
        
        // Continue until the queue is empty
        while (!queue.isEmpty()) { // while the queue is not empty
            int[] current = queue.poll(); // remove the cell from the queue
            int x = current[0], y = current[1], dist = current[2]; // current cell coordinates and distance
            // Check if we have reached the end cell
            if (x == end[0] && y == end[1]) { // if we have reached the end cell
                return dist; // return the distance
            } // if we have not reached the end cell

            // Explore all possible directions
            for (int[] direction : DIRECTIONS) { // for each direction
                int nx = x + direction[0]; // new x coordinate
                int ny = y + direction[1]; // new y coordinate
                
                // Check if the new cell is valid
                if (isValid(nx, ny, maze, visited)) { // if the new cell is valid
                    visited[nx][ny] = true; // mark the new cell as visited
                    queue.add(new int[]{nx, ny, dist + 1}); // add the new cell to the queue
                } // if the new cell is not valid
            } // end of for loop
        } // end of while loop

        // Return -1 if there is no path from start to end
        return -1; // Return -1 if there is no path from start to end
    } // end of bfsShortestPath method
    
    // Check if the cell is valid
    private static boolean isValid(int x, int y, int[][] maze, boolean[][] visited) { // Check if the cell is valid
        int rows = maze.length; // number of rows in the maze
        int cols = maze[0].length; // number of columns in the maze 
        return x >= 0 && x < rows && y >= 0 && y < cols && maze[x][y] == 0 && !visited[x][y]; // return true if the cell is valid
    } // end of isValid method

} // end of MazeSolver class