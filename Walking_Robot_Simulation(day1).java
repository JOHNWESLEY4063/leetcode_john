import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        final int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int answer = 0;
        int d = 0; 
        int x = 0; 
        int y = 0; 

        
        Set<Pair<Integer, Integer>> obstaclesSet = new HashSet<>();
        for (int[] o : obstacles) {
            obstaclesSet.add(new Pair<>(o[0], o[1]));
        }

        
        for (final int c : commands) {
            if (c == -1) {
                
                d = (d + 1) % 4;
            } else if (c == -2) {
                
                d = (d + 3) % 4;
            } else {
                
                for (int step = 0; step < c; ++step) {
                    
                    int nextX = x + direction[d][0];
                    int nextY = y + direction[d][1];

                    
                    if (obstaclesSet.contains(new Pair<>(nextX, nextY))) {
                        break; 
                    }

                    
                    x = nextX;
                    y = nextY;
                }
            }

            
            answer = Math.max(answer, x * x + y * y);
        }

        return answer; 
    }

    
    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return key.equals(pair.key) && value.equals(pair.value);
        }

        @Override
        public int hashCode() {
            return key.hashCode() ^ value.hashCode();
        }
    }
}
