import org.junit.jupiter.api.Test;

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

        }
    }

    @Test
    public void testExample1() {
        Robot robot = new RobotImpl(new int[][]{new int[]{1,1,1,1,1,0,1,1},new int[]{1,1,1,1,1,0,1,1},new int[]{1,0,1,1,1,1,1,1},new int[]{0,0,0,1,0,0,0,0},new int[]{1,1,1,1,1,1,1,1}}, 3, 1);
        RobotRoomCleaner solution = new RobotRoomCleaner();
        solution.cleanRoom(robot);
    }
}
