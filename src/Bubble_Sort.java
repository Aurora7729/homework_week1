import java.util.Scanner;

public class Bubble_Sort {
    public static String ASCII;
    public static void main(String[] args) {
        String sortresult;
        ASCII = "ASCII:[";
        boolean rangelentheselect = true;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a String:");
        String str = input.nextLine();
        System.out.println("dec or in  0:dec  1:inc");
        int rangelenthe = input.nextInt();
        System.out.println("The original string is: " + str + ".");
        System.out.println(str);

        /**ASCII数组*/
        int[] Char_array = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            Char_array[i] = (int)str.charAt(i);
        }

        if (rangelenthe == 0)
            rangelentheselect = false;

        if (rangelentheselect)
            sortresult = sortinc(Char_array);
        else
            sortresult = sortdec(Char_array);

        System.out.println("The result is: " );
        System.out.println(sortresult);
        System.out.println(ASCII);

    }


    public static String sortinc(int[] s1) {
        int count1 = s1.length;
        String str1 = "";
        for (int i = 0; i < count1 - 1; i++) {
            for (int j = 0; j < count1 - i - 1; j++) {
                if (s1[j] > s1[j + 1]) {
                    int temp = s1[j];
                    s1[j] = s1[j + 1];
                    s1[j + 1] = temp;
                }
            }
        }
        ASCII += s1[0];
        str1 += (char)s1[0];
        for (int i = 1; i < count1 ; i++) {
            str1 += (char) s1[i];
            ASCII += ',';
            ASCII += s1[i];
        }
        ASCII += ']';
        return str1;
    }

    public static String sortdec(int[] s2) {
        int count2 = s2.length;
        String str2 = "";
        for (int i = 0; i < count2 - 1; i++) {
            for (int j = 0; j < count2 - i - 1; j++) {
                if (s2[j] < s2[j + 1]) {
                    int temp = s2[j];
                    s2[j] = s2[j + 1];
                    s2[j + 1] = temp;
                }
            }
        }
        ASCII += s2[0];
        str2 += (char)s2[0];
        for (int i = 1; i < count2; i++) {
            str2 += (char) s2[i];
            ASCII += ',';
            ASCII += s2[i];
        }
        ASCII += ']';
        return str2;
    }

}