import java.util.Arrays;

public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length % 2 != 0) return new int[] {};
        int[] originalArray = new int[changed.length / 2];
        Arrays.sort(changed);
        originalArray[0] = changed[0];
        int nextOriginalPos = 1;
        int nextDoubledPos = 0;
        for(int pos = 1; pos < changed.length; ++pos) {
            if (nextDoubledPos < nextOriginalPos && changed[pos] == originalArray[nextDoubledPos] * 2) {
                ++nextDoubledPos;
            } else {
                if (nextOriginalPos < originalArray.length){
                    originalArray[nextOriginalPos++] = changed[pos];
                } else {
                    return new int[] {};
                }
            }
        }
        return originalArray;
    }
}
