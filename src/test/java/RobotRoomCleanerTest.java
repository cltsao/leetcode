import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RobotRoomCleanerTest {
    static final int[][] directions = new int[][] {new int[] {1, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{0, -1}};

    class RobotImpl implements Robot {
        int[][] map;
        int x;
        int y;
        int dir;

        RobotImpl(int[][] map, int x, int y) {
            this.map = map;
            this.x = x;
            this.y = y;
            this.dir = 0;
        }

        @Override
        public boolean move() {
            int newX = x + directions[dir][0];
            int newY = y + directions[dir][1];
            if (newY < 0 || newY >= map.length) return false;
            if (newX < 0 || newX >= map[newY].length) return false;
            if (map[newY][newX] == 0) return false;
            x = newX;
            y = newY;
            return true;
        }

        @Override
        public void turnLeft() {
            dir = (dir + 3) % 4;
        }

        @Override
        public void turnRight() {
            dir = (dir + 1) % 4;
        }

        @Override
        public void clean() {
            ++map[y][x];
        }
    }

    @Test
    public void testExample1() {
        int[][] map = new int[][]{new int[]{1,1,1,1,1,0,1,1},new int[]{1,1,1,1,1,0,1,1},new int[]{1,0,1,1,1,1,1,1},new int[]{0,0,0,1,0,0,0,0},new int[]{1,1,1,1,1,1,1,1}};
        Robot robot = new RobotImpl(map, 3, 1);
        RobotRoomCleaner solution = new RobotRoomCleaner();
        solution.cleanRoom(robot);
        assertAllCellsCleaned(map);
    }

    @Test
    public void testExample2() {
        int[][] map = new int[][]{new int[]{1, 1}};
        Robot robot = new RobotImpl(map, 1, 0);
        RobotRoomCleaner solution = new RobotRoomCleaner();
        solution.cleanRoom(robot);
        assertAllCellsCleaned(map);
    }

    private void assertAllCellsCleaned(int[][] map) {
        for(int r = 0; r < map.length; ++r) {
            for(int c = 0; c < map[r].length; ++c) {
                assertNotEquals(1, map[r][c], "Cell[" + r + "][" + c + "] is not cleaned");
            }
        }
    }
}
