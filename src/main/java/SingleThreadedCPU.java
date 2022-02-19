import java.util.*;

public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        TreeMap<Integer, List<int[]>> tasksByStartTime = new TreeMap<>();
        for(int i = 0; i < tasks.length; ++i) {
            int[] task = tasks[i];
            if (!tasksByStartTime.containsKey(task[0])) tasksByStartTime.put(task[0], new LinkedList<>());
            tasksByStartTime.get(task[0]).add(new int[]{task[1], i});
        }

        int[] executedTasks = new int[tasks.length];
        int pos = 0;
        int time = 0;
        PriorityQueue<int[]> readyTasks = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if (t1[0] != t2[0]) return t1[0] - t2[0];
                else return t1[1] - t2[1];
            }
        });
        while(!tasksByStartTime.isEmpty() || !readyTasks.isEmpty()) {
            if (readyTasks.isEmpty() && time < tasksByStartTime.firstKey()) time = tasksByStartTime.firstKey(); // Proceed to next start time

            while (!tasksByStartTime.isEmpty() && tasksByStartTime.firstKey() <= time) {
                for (int[] task : tasksByStartTime.pollFirstEntry().getValue())
                    readyTasks.offer(task);
            }

            int[] task = readyTasks.poll();
            executedTasks[pos++] = task[1];
            time += task[0];
        }
        return executedTasks;
    }
}
