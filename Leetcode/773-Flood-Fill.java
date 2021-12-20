/*
* @source https://leetcode.com/problems/flood-fill/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.20
*/
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        FloodFill floodFill = new FloodFill(image, sr, sc, newColor);
        return floodFill.getResult();
    }
}



class FloodFill {
    final int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int[][] image;
    private int sr;
    private int sc;
    private int newColor;
    private int pivotColor; 
    private int maxY;
    private int maxX;
    private boolean[][] isVisited;
     
    
    public FloodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        this.sr = sr;
        this.sc = sc;
        this.newColor = newColor;                
        this.pivotColor = this.image[sr][sc];
        this.maxY = image.length;
        this.maxX = image[0].length;
        this.isVisited = new boolean[maxY][maxX];
        this.image[sr][sc] = newColor;
    }
    public int[][] getResult() {
        execute();
        return this.getImage();
    }
    
    public void execute() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sr, sc));

        while(!queue.isEmpty()) {
            Node curNode = queue.poll();
            int curY = curNode.getY();
            int curX = curNode.getX();

            for(int i = 0; i < dir.length; i++) {
                int nextY = curY + dir[i][0];
                int nextX = curX + dir[i][1];

                if (isAccessible(nextY, nextX) && image[nextY][nextX] == this.pivotColor
                        && !isVisited[nextY][nextX]) {
                    isVisited[nextY][nextX] = true;
                    image[nextY][nextX] = newColor;
                    queue.add(new Node(nextY, nextX));
                }
            }
        }
    }
    
    public int[][] getImage() {
        return this.image;
    } 
    
    public  boolean isAccessible(int y, int x) {
        if (x < 0 || y < 0 || y > this.maxY - 1 || x > this.maxX - 1 || isVisited[y][x])
            return false;
        return true;
    }
}

class Node {
    private int x;
    private int y;

    public Node(int y, int x) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}
