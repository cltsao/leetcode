public class Excel {
    Cell[][] mat;

    class Cell {
        // reference: [fromRow, toRow, fromCol, toCol]
        int[][] references;
        int val;
        int get() {
            if (references != null) {
                int sum = 0;
                for(int[] reference : references) {
                    for(int row = reference[0]; row <= reference[1]; ++row) {
                        for(int col = reference[2]; col <= reference[3]; ++col) {
                            sum += mat[row][col].get();
                        }
                    }
                }
                return sum;
            } else {
                return val;
            }
        }
    }

    int getColIndex(char column) {
        return column - 'A';
    }

    public Excel(int height, char width) {
        mat = new Cell[height][getColIndex(width) + 1];
        for(Cell[] row : mat) {
            for(int col = 0; col < row.length; ++col) {
                row[col] = new Cell();
            }
        }
    }

    public void set(int row, char column, int val) {
        --row;
        mat[row][getColIndex(column)].val = val;
        mat[row][getColIndex(column)].references = null;
    }

    public int get(int row, char column) {
        --row;
        return mat[row][getColIndex(column)].get();
    }

    public int sum(int row, char column, String[] numbers) {
        --row;
        Cell cell = mat[row][getColIndex(column)];
        cell.references = new int[numbers.length][];
        for(int i = 0; i < numbers.length; ++i) {
            String[] cells = numbers[i].split(":");
            int[] fromCell = parseCellString(cells[0]);
            int[] toCell = parseCellString(cells[cells.length - 1]);
            cell.references[i] = new int[] {fromCell[0], toCell[0], fromCell[1], toCell[1]};
        }
        return cell.get();
    }

    private int[] parseCellString(String cell) {
        int[] cellIndex = new int[2];
        cellIndex[0] = Integer.parseInt(cell.substring(1)) - 1;
        cellIndex[1] = getColIndex(cell.charAt(0));
        return cellIndex;
    }
}
