package misc;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<Integer> generatePascalsRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        if (rowIndex < 0) {
            return row;
        }

        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);

            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j - 1) + row.get(j));
            }
        }

        return row;
    }

    public static void main(String[] args) {
        int rowIndex = 4; // Change this to get a different row (0-based index)
        List<Integer> pascalsRow = generatePascalsRow(rowIndex);

        System.out.println("Row " + rowIndex + " of Pascal's Triangle: " + pascalsRow);
    }
}
