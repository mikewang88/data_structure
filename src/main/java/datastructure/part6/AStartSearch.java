package datastructure.part6;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: MikeWang
 * @Date: 2020/1/8 10:38 AM
 * @Description:
 */
public class AStartSearch {
    //两个集合
    //openlist 可到达的格子
    //closelist 已到达的格子
    //一个公式
    //F=G+H
    //G 从起点走到当前格子的成本，也就是已经花费了多少步
    //H 在不考虑障碍的情况下，从当前格子走到目标格子的距离，也就是离目标还有多远。
    //F G和H 的综合评估，也就是从起点到达当前格子，再从当前格子到大目标格子的总步数。


    //迷宫地图
    public static final int[][] MAZE = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
    };

    /**
     * A* 寻路主逻辑
     *
     * @param start 迷宫起点
     * @param end   迷宫终点
     * @return
     */
    public static Grid aStartSearch(Grid start, Grid end) {
        ArrayList<Grid> openList = new ArrayList<>();
        ArrayList<Grid> closeList = new ArrayList<>();
        //把起点加入openList
        openList.add(start);
        //主循环，每一轮检查1个当前方格节点
        while (openList.size() > 0) {
            // 在openlist 中查找F 值最小的节点，将其作为当前方格节点
            Grid currentGrid = findMinGird(openList);
            //将当前方格节点从openlist 中移除
            openList.remove(currentGrid);
            //当前方格节点进入closeList
            closeList.add(currentGrid);
            //找到所有邻近节点
            List<Grid> neighbors = findNeighbors(currentGrid, openList, closeList);
            for (Grid grid : neighbors) {
                if (!openList.contains(grid)) {
                    //邻近节点不在openList 中，标记 "父节点" G\H\F 并放入openlist
                    grid.initGrid(currentGrid, end);
                    openList.add(grid);
                }
            }
            //如果终点在openlist 中，直接返回终点格子
            for (Grid grid : openList) {
                if ((grid.x == end.x) && (grid.y == end.y)) {
                    return grid;
                }
            }
        }
        //openlist 用完了也没用找到
        return null;
    }

    private static ArrayList<Grid> findNeighbors(Grid grid, List<Grid> openList, List<Grid> closeList) {
        ArrayList<Grid> gridList = new ArrayList<>();
        if (isValidGrid(grid.x, grid.y - 1, openList, closeList)) {
            gridList.add(new Grid(grid.x, grid.y - 1));
        }
        if (isValidGrid(grid.x, grid.y + 1, openList, closeList)) {
            gridList.add(new Grid(grid.x, grid.y + 1));
        }
        if (isValidGrid(grid.x - 1, grid.y, openList, closeList)) {
            gridList.add(new Grid(grid.x - 1, grid.y));
        }
        if (isValidGrid(grid.x + 1, grid.y, openList, closeList)) {
            gridList.add(new Grid(grid.x + 1, grid.y));
        }
        return gridList;
    }

    private static Grid findMinGird(ArrayList<Grid> openList) {
        Grid tempGrid = openList.get(0);
        for (Grid grid : openList) {
            if (grid.f < tempGrid.f) {
                tempGrid = grid;
            }
        }
        return tempGrid;
    }

    private static boolean containGrid(List<Grid> grids, int x, int y) {
        for (Grid n : grids) {
            if ((n.x == x) && (n.y == y)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidGrid(int x, int y, List<Grid> openlist, List<Grid> closeList) {
        //是否越过边界 x <= MAZE.length???
        if (x < 0 || x >= MAZE.length || y < 0 || y >= MAZE[0].length) {
            return false;
        }
        //是否有障碍物
        if (MAZE[x][y] == 1) {
            return false;
        }
        //是否已经在openlist 中
        if (containGrid(openlist, x, y)) {
            return false;
        }
        //是否已经在closelist 中
        if (containGrid(closeList, x, y)) {
            return false;
        }
        return true;
    }

    static class Grid {
        public int x;
        public int y;
        public int f;
        public int g;
        public int h;
        public Grid parent;

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void initGrid(Grid parent, Grid end) {
            this.parent = parent;
            if (parent != null) {
                this.g = parent.g + 1;
            } else {
                this.g = 1;
            }
            this.h = Math.abs(this.x - end.x) + Math.abs(this.y - end.y);
            this.f = this.g + this.h;
        }

    }

    public static void main(String[] args) {
        // 起点
        Grid startGrid = new Grid(2,1);
        Grid endGrid = new Grid(2,5);
        //搜索迷宫终点
        Grid resultGrid = aStartSearch(startGrid,endGrid);
        //回溯迷宫路径
        ArrayList<Grid> path = new ArrayList<>();
        while (resultGrid!=null){
            path.add(new Grid(resultGrid.x,resultGrid.y));
            resultGrid =resultGrid.parent;
        }

        //输出迷宫和路径，路径用* 表示
        for (int i = 0;i<MAZE.length;i++){
            for (int j =0; j< MAZE[0].length;j++){
                if (containGrid(path,i,j)){
                    System.out.println("*,");
                }else {
                    System.out.println(MAZE[i][j]+",");
                }
            }
        }
        System.out.println();
    }

}
