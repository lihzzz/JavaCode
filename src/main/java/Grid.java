//Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands which the sum of 1‘s on the island equal S (S>0).
//        An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
//        You may assume all four edges of the grid are all surrounded by water.
//        Example 1:
//        Input: grid = [
//        ["1","1","1","1","0"],
//        ["1","1","0","1","0"],
//        ["1","1","0","0","0"],
//        ["0","0","0","0","0"]
//        ], S = 9
//        Output: 1


import org.junit.Test;

public class Grid {
        private int ans = 0;
        public int sumIslands(char[][] grid, int S){
                // implementation
                int row = grid.length;
                if(row == 0){
                        return ans;
                }
                int col = grid[0].length;
                if(col == 0){
                        return ans;
                }
                for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                                int curArea = dfsHelper(grid,i,j);
                                if(curArea != 0 && curArea == S){
                                        ans++;
                                }
                        }
                }
                return ans;
        }

        public int dfsHelper(char[][] grid,int x,int y){
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1'){
                        return 0;
                }
                grid[x][y] = '9';
                return dfsHelper(grid,x+1,y) + dfsHelper(grid,x-1,y) + dfsHelper(grid,x,y-1) + dfsHelper(grid,x,y+1) + 1;

        }

        @Test
        public void sumIslandsTest(){
                char[][] grid = {
                        {'1', '1', '0', '1', '1'},
                        {'1', '1', '0', '1', '1'},
                        {'0', '0', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                };
                int S = 4;
                // test implementation
                Grid grid1 = new Grid();
                System.out.println(grid1.sumIslands(grid,S));

        }
}


