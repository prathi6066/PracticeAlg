package prathi.learn.practicealg.arrays;

class SearchMatrix{

    static class  IntPair extends Pair<Integer, Integer> {
        public IntPair(int first, int second) {
            super(first, second);
        }
    }

    static class Pair<X, Y> {
        public X first;
        public Y second;
        public Pair(X first, Y second) {
            this.first = first;
            this.second = second;
        }
    }

    public static IntPair searchInMatrix(int matrix[][], int value) {
        //TODO: Write - Your - Code
        int currentRow = matrix.length-1;
        int currentCol = 0;

        while (currentRow >=0 && currentCol >=0 && currentRow < matrix.length && currentCol < matrix[0].length) {

            if (matrix[currentRow][currentCol] == value)
                return new IntPair(currentRow, currentCol);
            else if(matrix[currentRow][currentCol] > value) {
                currentRow--;
            }  else {
                currentCol++;
            }
        }
        return new IntPair(-1, -1);
    }


    public static void main(String[] args) {
        int [] [] matrix = new int [] [] {
                {2, 4, 9, 13, 15},
                {3, 5, 11, 18, 22},
                {6, 8, 16, 21, 28},
                {9, 11, 20, 25, 31},
        };

        IntPair val_loc = searchInMatrix(matrix, 9);
        System.out.println("Verifying at " + Integer.toString(val_loc.first) + "," +
                Integer.toString(val_loc.second) + ": " + Integer.toString(matrix[val_loc.first][val_loc.second]));
    }
}