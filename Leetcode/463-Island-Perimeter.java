/*
* @source https://leetcode.com/problems/island-perimeter/
* @author EunHyeJung
* @email ehye826@gmail.com
* @date 2021.12.21
*/
class Solution {
    public int islandPerimeter(int[][] grid) {
        IsLand isLand = new IsLand(grid);

        return isLand.getPerimeter();        
    }
}

class IsLand {
    final int[][] DIR = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final int LAND = 1;
    int nY;
    int nX;
    int[][] grid;
    boolean[][] isVisited;
    int perimeter;

    public IsLand(int[][] grid) {
        this.grid = grid;
        this.nY = grid.length;
        this.nX = grid[0].length;
        this.isVisited = new boolean[nY][nX];
        this.perimeter = 0;

        explore();
    }

    public int getPerimeter() {
        return this.perimeter;
    }

    public Land findFirstLand() {
        for(int y = 0; y < nY; y++) {
            for(int x = 0; x < nX; x++) {
                if(this.grid[y][x] == LAND) {
                    return new Land(y, x);
                }
            }
        }
        return null;
    }

    public void explore() {
        Queue<Land> queue = new LinkedList<>();
        Land firstLand = findFirstLand();
        queue.add(firstLand);
        this.isVisited[firstLand.getY()][firstLand.getX()] = true;

        while(!queue.isEmpty()) {
            Land curLand = queue.poll();
            this.perimeter += getLandPerimeter(curLand);
            
            for (int d = 0, dn = DIR.length; d < dn; d++) {
                int nextY = curLand.getY() + DIR[d][0];
                int nextX = curLand.getX() + DIR[d][1];
                if (isAccessible(nextY, nextX) && !isVisited[nextY][nextX] && this.grid[nextY][nextX] == LAND) {
                    this.isVisited[nextY][nextX] = true;
                    queue.add(new Land(nextY, nextX));
                }
            }
        }
    }

    public int getLandPerimeter(Land land) {
        int perimeter = 4;

        for (int d = 0, dn = DIR.length; d < dn; d++) {
            int nextY = land.getY() + DIR[d][0];
            int nextX = land.getX() + DIR[d][1];
            if (isAccessible(nextY, nextX) && this.grid[nextY][nextX] == LAND)
                perimeter -=1;
        }
        return perimeter;
    }

    public boolean isAccessible(int y, int x) {
        if (y < 0 || x < 0 || y > nY - 1 || x > nX - 1)
            return false;
        return true;
    }
}

class Land {
    private int y;
    private int x;

    public Land(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }
}

