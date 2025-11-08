import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestaurantArrayDriver {

    public static int overallAvg(Restaurant[] a) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                sum = sum + a[i].getRating();
                count++;
            }
        }
        if (count == 0) return 0;
        return sum / count;
    }

    public static int count(Restaurant[] a, Restaurant o) {
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null && a[i].equals(o)) {
                c++;
            }
        }
        return c;
    }

    public static int groupAvg(Restaurant[] a, String s) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null && a[i].getName().equalsIgnoreCase(s)) {
                sum = sum + a[i].getRating();
                count++;
            }
        }
        if (count == 0) return 0;
        return sum / count;
    }

    public static Restaurant[] lessThan(Restaurant[] a, Integer i) {
        Restaurant[] temp = new Restaurant[a.length];
        int j = 0;
        for (int k = 0; k < a.length; k++) {
            if (a[k] != null && a[k].getRating() < i) {
                temp[j] = a[k];
                j++;
            }
        }
        // make result array the right size
        Restaurant[] result = new Restaurant[j];
        for (int m = 0; m < j; m++) {
            result[m] = temp[m];
        }
        return result;
    }

    public static void groupEdit(Restaurant[] a, String s, Integer n) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null && a[i].getName().equalsIgnoreCase(s)) {
                a[i].setRating(a[i].getRating() + n);
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter file name: ");
            String fname = in.nextLine();

            File f = new File(fname);
            Scanner fileIn = new Scanner(f);

            Restaurant[] arr = new Restaurant[100]; // assume max 100
            int index = 0;

            while (fileIn.hasNext() && index < arr.length) {
                String name = fileIn.next();
                int rating = fileIn.nextInt();
                arr[index] = new Restaurant(name, rating);
                index++;
            }
            fileIn.close();

            System.out.println("All restaurants:");
            for (int i = 0; i < index; i++) {
                System.out.println(arr[i]);
            }

            System.out.println("Overall avg: " + overallAvg(arr));
            System.out.println("Count Subway(70): " + count(arr, new Restaurant("Subway", 70)));
            System.out.println("Group avg McDonalds: " + groupAvg(arr, "McDonalds"));

            Restaurant[] low = lessThan(arr, 75);
            System.out.println("Restaurants < 75:");
            for (int i = 0; i < low.length; i++) {
                System.out.println(low[i]);
            }

            groupEdit(arr, "Subway", 10);
            System.out.println("After editing Subway ratings:");
            for (int i = 0; i < index; i++) {
                if (arr[i].getName().equalsIgnoreCase("Subway")) {
                    System.out.println(arr[i]);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
