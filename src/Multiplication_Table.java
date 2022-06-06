public class Multiplication_Table {
    public static void main(String[] args) {

//      下半边  i控制行 j控制列
        for (int i = 1; i < 10; i++) {
            String line = "";
            for (int j = 1; j < 10; j++) {
                if (i < j)
                    break;
                line += i + "*" + j + "=" + i * j + "\t";
            }
            System.out.println(line);
        }

        System.out.println();

//      上半边  i控制行 j控制列
        for (int i = 1; i < 10; i++) {
            String line = "";
            for (int j = 1; j < 10; j++) {
                if (i > j){
                    line +=  "\t\t";
                }
                else if (i <= j ) {
                    line += i + "*" + j + "=" + i * j + "\t";
                }
            }
            System.out.println(line);
        }


    }
}
