import java.util.List;

public class DepthFirst {
    
    // If path was found, this method will return true
    // and the path list will be filled
    // like this: { xn, yn, ..., x2, y2, x1, y1, x0, y0 }
    // so the order is inverted ...
    // x and y are the start searching position
    //
    // Note: all visited nodes of maze array will be filled with 2
    //       and won't be cleaned up automatically
    public static boolean searchPath(int[][] maze, int x, int y
            , List<Integer> path) {
        
        if (maze[y][x] == 9) {
            path.add(x);
            path.add(y);
            return true;
        }
        
        if (maze[y][x] == 0||maze[y][x]==7) {
			
			if(maze[y][x]==7)
                maze[y][x] = 8;
		    else
				maze[y][x] = 2;
            
            int dx = -1;
            int dy = 0;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
       
            dx = 1;
            dy = 0;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = -1;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = 1;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
    
}