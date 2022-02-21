public class SmallestRectangleEnclosingBlackPixels {
    // Binary search: O(m log n + n log m)
    public int minArea(char[][] image, int x, int y) {
        return (search(image, true, x, image.length - 1, false) - search(image, true, 0, x, true) + 1) *
                (search(image, false, y, image[0].length - 1, false) - search(image, false, 0, y, true) + 1);
    }

    private int search(char[][] image, boolean searchRow, int start, int end, boolean searchMin) {
        if (searchMin) {
            // Black pixel exists in the end row/col, find the min row/col that contains black pixel since start
            while (end > start) {
                int middle = (start + end) / 2;
                if (hasBlack(image, searchRow, middle)) {
                    end = middle;
                } else {
                    start = middle + 1;
                }
            }
            return end;
        } else {
            // Black pixel exists in the start row/col, find the max row/col that contains black pixel till end
            while (end > start) {
                int middle = (start + end + 1) / 2;
                if (hasBlack(image, searchRow, middle)) {
                    start = middle;
                } else {
                    end = middle - 1;
                }
            }
            return start;
        }
    }

    private boolean hasBlack(char[][] image, boolean searchRow, int index) {
        if (searchRow) {
            for (int c = 0; c < image[index].length; ++c) {
                if (image[index][c] == '1') return true;
            }
        } else {
            for (int r = 0; r < image.length; ++r) {
                if (image[r][index] == '1') return true;
            }
        }
        return false;
    }

    // Brute force: O(mn)
    public int minAreaBruteForce(char[][] image, int x, int y) {
        int minR = image.length - 1, maxR = 0, minC = image[0].length, maxC = 0;

        for (int r = 0; r < image.length; ++r) {
            for (int c = 0; c < image[r].length; ++c) {
                if (image[r][c] == '1') {
                    minR = Math.min(minR, r);
                    maxR = Math.max(maxR, r);
                    minC = Math.min(minC, c);
                    maxC = Math.max(maxC, c);
                }
            }
        }

        return (maxR - minR + 1) * (maxC - minC + 1);
    }
}
