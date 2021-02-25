public class PaintFill {

    static boolean validCoord(int x, int y, int n, int m) {
        if (x < 0 || y < 0)
            return true;

        if (x >= n || y >= m)
            return true;

        return false;
    }

    static void paintFill(int image[][], int x, int y, int currentColor, int newColor) {
        if (validCoord(x, y, image.length, image[0].length))
            return;
        if (image[x][y] != currentColor)
            return;

        image[x][y] = newColor;

        paintFill(image, x + 1, y, currentColor, newColor);
        paintFill(image, x - 1, y, currentColor, newColor);
        paintFill(image, x, y + 1, currentColor, newColor);
        paintFill(image, x, y - 1, currentColor, newColor);
    }

    public static void main(String[] args) {
        int image[][] = {
                {1, 1, 1},
                {1, 3, 1},
                {1, 0, 1}
        };
        int x = 0, y = 0, newColor = 5;
        int currentColor = image[x][y];
        paintFill(image, x, y, currentColor, newColor);
        for (int[] row :image) {
            for (int col : row)
                System.out.print(col + " ");
            System.out.println();
        }
    }

}
