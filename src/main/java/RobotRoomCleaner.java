import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This is the robot's control interface.
// You should not implement it, or speculate about its implementation
interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();

    public void turnRight();

    // Clean the current cell.
    public void clean();
}

public class RobotRoomCleaner {
    // Maintain a two-dimensional map with origin in (0, 0).
    // Each dimension is a list expandable on both directions. First list is for non-negative index, and second list is for negative index.
    List<List<Boolean>[]>[] map;

    static final int[][] directions = new int[][] {new int[] {1, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{0, -1}};

    public void cleanRoom(Robot robot) {
        initMap();
        setMap(0, 0, true);
        visit(robot,0, 0, 0);  // Initial direction is relative, so just assume going right
    }

    private void initMap() {
        map = new List[2];
        map[0] = new ArrayList<>();
        map[1] = new ArrayList<>();
    }

    private void visit(Robot robot, int x, int y, int dir) {
        // System.out.println("Visit (" + x + ", " + y + ") by direction " + Arrays.toString(directions[dir]));
        robot.clean();

        // try cell on the right, ahead, and then on the left
        robot.turnRight();
        dir = (dir + 1) % 4;
        for(int i = 0; i < 3; ++i) {
            int[] direction = directions[dir];
            if (!getMap(x + direction[0], y + direction[1])) {
                setMap(x + direction[0], y + direction[1], true);
                boolean success = robot.move();
                if (success) {
                    visit(robot, x + direction[0], y + direction[1], dir);
                    robot.turnRight();  // because robot move backward to this cell
                } else {
                    // System.out.println("Hit a wall at (" + x + ", " + y + ") by direction " + Arrays.toString(direction));
                    robot.turnLeft();  // turn left to the next direction to try
                }
            } else {
                // Prune known walls or cells that have been visited
                robot.turnLeft();  // turn left to the next direction to try
            }
            dir = (dir + 3) % 4;
        }

        // Move back to where the robot came from
        robot.move();
    }

    private boolean getMap(int x, int y) {
        List<Boolean>[] row;
        if (y >= 0) {
            if (y >= map[0].size()) return false;
            row = map[0].get(y);
        } else {
            if (-y > map[1].size()) return false;
            row = map[1].get(-y - 1);
        }

        if (x >= 0) {
            if (x >= row[0].size()) return false;
            return row[0].get(x);
        } else {
            if (-x > row[1].size()) return false;
            return row[1].get(-x - 1);
        }
    }

    private void setMap(int x, int y, boolean value) {
        List<Boolean>[] row;
        if (y >= 0) {
            while (y >= map[0].size()) map[0].add(new List[] {new ArrayList<>(), new ArrayList<>()});
            row = map[0].get(y);
        } else {
            while (-y > map[1].size()) map[1].add(new List[] {new ArrayList<>(), new ArrayList<>()});
            row = map[1].get(-y - 1);
        }

        if (x >= 0) {
            while (x >= row[0].size()) row[0].add(false);
            row[0].set(x, value);
        } else {
            while (-x > row[1].size()) row[1].add(false);
            row[1].set(-x - 1, value);
        }
    }
}
