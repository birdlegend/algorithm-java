package com.zsb.collection;

/**
 * Created by zsb on 2018/3/27.
 */

import java.util.Stack;

/**
 * 广度优先遍历
 * https://blog.csdn.net/gavin_john/article/details/71374487
 * 迷宫通道类，一个Cell代表地图上的一个方块
 *
 * @author Gavin
 */
class Cell {
    private int x; // 单元所在行
    private int y; // 单元所在列
    private char c; // 字符，通道对应'0'，墙对应'1'
    private boolean isVisited;// 是否访问过

    public Cell(int x, int y, char c, boolean isVisited) {
        super();
        this.x = x;
        this.y = y;
        this.c = c;
        this.isVisited = isVisited;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cell other = (Cell) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.getC() + "(" + this.getX() + ", " + this.getY() + ")";
    }
}

public class Maze {

    public static void main(String[] args) {
        char maze[][] = {{'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '1', '1', '0', '0', '1', '1'},
                {'1', '0', '0', '1', '1', '0', '0', '1', '0', '1'},
                {'1', '0', '0', '0', '0', '0', '0', '1', '0', '1'},
                {'1', '0', '0', '0', '0', '1', '1', '0', '0', '1'},
                {'1', '0', '0', '1', '1', '1', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '0', '1', '0', '1', '0', '1'},
                {'1', '0', '1', '1', '0', '0', '0', '1', '0', '1'},
                {'1', '1', '0', '0', '0', '0', '1', '0', '0', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '1', '1'},};
//        mazeExit1(maze, 8, 8, 1, 7);
        mazeExit(maze, 8, 8, 1, 7);
    }

    /**
     * 求解迷宫
     *
     * @param maze  迷宫的字符数组
     * @param in_x  起点x坐标
     * @param in_y  起点y坐标
     * @param out_x 终点x坐标
     * @param out_y 终点y坐标
     */
    public static void mazeExit(char maze[][], int in_x, int in_y, int out_x, int out_y) {
        Cell[][] cells = createMaze(maze);
        Cell start = cells[in_x][in_y];
        Cell end = cells[out_x][out_y];

        Stack<Cell> stack = new Stack();
        stack.push(start);
        start.setVisited(true);

        while (!stack.isEmpty()) {
            Cell cur = stack.peek();
            if (end.equals(cur)) { // 到达终点
                int x = out_x, y = out_y;
                while (!stack.isEmpty()) {
                    Cell tmp = stack.pop();
//                    System.out.println(tmp.toString());
//                    需要过滤多余的点
//                    1 1 1 1 1 1 1 1 1 1
//                    1 0 0 1 1 1 * * 1 1
//                    1 0 0 1 1 * * 1 0 1
//                    1 0 * * * * 0 1 0 1
//                    1 0 * * * 1 1 * * 1
//                    1 0 * 1 1 1 * * * 1
//                    1 0 * * * 1 * 1 * 1
//                    1 0 1 1 * * * 1 * 1
//                    1 1 0 0 * * 1 0 * 1
//                    1 1 1 1 1 1 1 1 1 1
                    // 需要与上一个点相邻， 先横着搜索，再竖着搜索
                    if (Math.abs(tmp.getX() - x) + Math.abs(tmp.getY() - y) <= 1)
                        tmp.setC('*');
                    x = tmp.getX();
                    y = tmp.getY();
                }
                printMaze(cells);
                return;
            } else {
                boolean isDead = true;
                for (int i = 0; i < 4; i++) {
                    Cell nextCell = getCell(cells, cur, i);
                    if (isValid(nextCell)) { // 其他所有可以走的方向都压栈，广度优先遍历
                        nextCell.setVisited(true);
                        isDead = false;
                        stack.push(nextCell);
                    }
                }
                if (isDead)
                    stack.pop(); //该cell无可走路径，回退一步。
            }
        }
        System.out.println("找不到路径");
    }

    public static Cell getCell(Cell[][] cells, Cell now, int direction) {
        int x = now.getX();
        int y = now.getY();
        Cell cell = null;

        switch (direction) {
            case 0:
                cell = cells[x + 1][y];
                break;
            case 1:
                cell = cells[x][y + 1];
                break;
            case 2:
                cell = cells[x - 1][y];
                break;
            case 3:
                cell = cells[x][y - 1];
                break;

        }
        return cell;
    }

    /**
     * 判断一个cell是否是通道
     *
     * @param cell
     * @return
     */
    public static boolean isValid(Cell cell) {
        return cell != null && cell.getC() == '0' && !cell.isVisited();
    }


    /**
     * 根据输入的二维char数组创建二维Cell数组
     *
     * @param maze 二维char数组
     * @return
     */
    private static Cell[][] createMaze(char[][] maze) {
        Cell[][] cells = new Cell[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                char c = maze[i][j];
                Cell cell = new Cell(i, j, c, false);
                cells[i][j] = cell;
            }
        }
        return cells;
    }

    /**
     * 打印迷宫
     *
     * @param cells
     */
    private static void printMaze(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j].getC() + " ");
            }
            System.out.println();
        }
    }
}


