import java.util.ArrayList;
import java.util.List;

public class ratInAMaze {
    public void ratInMazeFinder(int[][] maze, int xCordinate,int yCordinate, List<String> storage,
                                StringBuilder destinationAdd){
        if(xCordinate<0 || xCordinate>=maze.length ||
                yCordinate<0 || yCordinate>=maze[0].length || maze[xCordinate][yCordinate]==0) return;
        if(xCordinate==maze.length-1 && yCordinate==maze[0].length-1){
            storage.add(destinationAdd.toString());
            return;
        }

        // Down
        destinationAdd.append("D");
        maze[xCordinate][yCordinate]=0;
        ratInMazeFinder(maze,xCordinate+1,yCordinate,storage,destinationAdd);
        destinationAdd.deleteCharAt(destinationAdd.length()-1);
        maze[xCordinate][yCordinate]=1;
        // Right
        destinationAdd.append("R");
        maze[xCordinate][yCordinate]=0;
        ratInMazeFinder(maze,xCordinate,yCordinate+1,storage,destinationAdd);
        destinationAdd.deleteCharAt(destinationAdd.length()-1);
        maze[xCordinate][yCordinate]=1;
        // Left
        destinationAdd.append("L");
        maze[xCordinate][yCordinate]=0;
        ratInMazeFinder(maze,xCordinate,yCordinate-1,storage,destinationAdd);
        destinationAdd.deleteCharAt(destinationAdd.length()-1);
        maze[xCordinate][yCordinate]=1;
        //
        destinationAdd.append("U");
        maze[xCordinate][yCordinate]=0;
        ratInMazeFinder(maze,xCordinate-1,yCordinate,storage,destinationAdd);
        destinationAdd.deleteCharAt(destinationAdd.length()-1);
        maze[xCordinate][yCordinate]=1;

    }
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}};
        List<String> storage = new ArrayList<>();
        ratInAMaze obj=new ratInAMaze();
        obj.ratInMazeFinder(maze, 0, 0, storage, new StringBuilder());
        for(String i: storage){
            System.out.println(i);
        }

    }
}
