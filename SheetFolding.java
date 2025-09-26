public class SheetFolding {

    private static int countFolds(int original, int target) {
        if (original < target || original % target != 0) return Integer.MAX_VALUE;
        int folds = 0;
        while (original > target) {
            if (original % 2 != 0) return Integer.MAX_VALUE; 
            original /= 2;
            folds++;
        }
        return folds;
    }

    public static int minFolds(int h, int w, int h1, int w1) {
        int folds1 = countFolds(h, h1) + countFolds(w, w1); 
        int folds2 = countFolds(h, w1) + countFolds(w, h1); 

        int ans = Math.min(folds1, folds2);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(minFolds(16, 8, 4, 2)); 
        System.out.println(minFolds(10, 5, 2, 5));
    }
}

