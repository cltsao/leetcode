import java.util.*;

public class RaceCar {
    class State {
        int position;
        int speed;
        int steps;

        State(int position, int speed, int steps) {
            this.position = position;
            this.speed = speed;
            this.steps = steps;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return position == state.position && speed == state.speed;
        }

        @Override
        public int hashCode() {
            return Objects.hash(position, speed);
        }
    }

    // BFS
    public int racecar(int target) {
        // State: position, speed, steps
        Set<State> visitedStates = new HashSet<>();
        Queue<State> nextStates = new LinkedList<>();
        State initialState = new State(0, 1, 0);
        visitedStates.add(initialState);
        nextStates.add(initialState);

        State state;
        while((state = nextStates.poll()) != null) {
            State accelerateState = new State(state.position + state.speed, state.speed * 2, state.steps + 1);
            if (accelerateState.position == target) return accelerateState.steps;
            // Need to prune unlikely states
            if (accelerateState.position > 0 && accelerateState.position < 20000 && !visitedStates.contains(accelerateState)) {
                nextStates.add(accelerateState);
                visitedStates.add(accelerateState);
            }

            State reverseState = new State(state.position, state.speed > 0 ? -1 : 1, state.steps + 1);
            if (!visitedStates.contains(reverseState)) {
                nextStates.add(reverseState);
                visitedStates.add(reverseState);
            }
        }

        return -1; // Impossible to arrive at target
    }
}
