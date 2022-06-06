import java.util.Scanner;

public class ScoreProcess {
    public static void main(String[] args) {

        // 声明六个变量， 分别代表六门科目的成绩
        int ChineseIndex = 0;
        int MathIndex = 1;
        int EnglishIndex = 2;
        int PhysicsIndex = 3;
        int ChemistryIndex = 4;
        int BiologyIndex = 5;

        int totalScoreCount = 6;

        // 每门课的名字
        String[] names = new String[totalScoreCount];
        names[ChineseIndex] = "Chinese";
        names[MathIndex] = "Math";
        names[EnglishIndex] = "English";
        names[PhysicsIndex] = "Physics";
        names[ChemistryIndex] = "Chemistry";
        names[BiologyIndex] = "Biology";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the total number of years of grades:");

        int yearCount = scanner.nextInt();

        double[][] scores = new double[yearCount][totalScoreCount];


        for (int i = 0; i < yearCount; i++) {
            for (int j = 0; j < totalScoreCount; j++) {
                scores[i][j] = 80 + Math.random() * 20;
                System.out.println("The " + names[j] + " of year " + (i + 1) +  " is " + scores[i][j]);
            }
        }

        boolean cont = true;
        while (cont) {
            System.out.println("Please select an action to take:");
            System.out.println("1: Find the best grade in a certain year\n" +
                    "2: Find the average grade for a certain year\n" +
                    "3: Find the best grades in all years\n" +
                    "4: Find the best grades for a certain course over the years");

            int oprtId = scanner.nextInt();

            int year = 0;
            switch (oprtId) {
                case 1:
                    // 让用户输入指定的年份
                    System.out.println("Enter the year you want to query.");
                    year = scanner.nextInt();
                    if (year <= 0 || yearCount < year) {
                        System.out.println("Illegal year:" + year);
                        cont = false;
                        break;
                    }
                    year = year - 1;
                    // 指定年份的最好成绩的编号，开始假设是0
                    int bestOfYearScoreId = 0;
                    int[] record = new int[6];  //相同分数科目编号数组
                    int best_num = 0;           //科目个数
                    String Subject_record = ""; //科目拼接，便于显示
                    // 循环指定年份的成绩，找出最好的成绩
                    // 寻找最好成绩
                    for (int i = 1; i < totalScoreCount; i++) {
                        if (scores[year][bestOfYearScoreId] < scores[year][i]) {
                            bestOfYearScoreId = i;
                        }
                    }
                    //最好成绩是否有分数相同的科目
                    for (int i = 0; i < totalScoreCount; i++){
                        if (scores[year][bestOfYearScoreId] == scores[year][i]){
                            record[best_num] = i;
                            best_num += 1;
                        }
                    }
                    if(best_num == 1)
                        System.out.println("The best subjects in Year " + (year + 1) + " is " + names[bestOfYearScoreId] + ",the score is" + scores[year][bestOfYearScoreId] + ".");
                    else if (best_num > 1) {
                        System.out.println();
                        for (int i = 0;i < best_num; i++){
                            Subject_record += names[record[i]];
                            Subject_record += '\u0020';
                        }
                        System.out.println("Year " + (year + 1) + " have " + best_num + " best subject, the score is  "+ scores[year][bestOfYearScoreId] + ".");
                        System.out.println("The subjects are " + Subject_record);
                    }
                    break;
                case 2:
                    System.out.println("Please enter the grade point average for the year to be calculated");
                    year = scanner.nextInt();
                    if (year <= 0 || yearCount < year) {
                        System.out.println("Illegal year:" + year);
                        cont = false;
                        break;
                    }
                    year = year - 1;
                    double totalCountForAvg = 0;
                    for (int i = 0; i < totalScoreCount; i++) {
                        totalCountForAvg += scores[year][i];
                    }
                    double avgofYear = totalCountForAvg / totalScoreCount;
                    System.out.println("The average score of year " + (year + 1) + " is " + avgofYear + ".");
                    break;
                case 3:
                    int bestYear = 0;
                    int bestScore = 0;

                    for (int i = 0; i < yearCount; i++) {
                        for (int j = 0; j < totalScoreCount; j++) {
                            if (scores[bestYear][bestScore] < scores[i][j]) {
                                bestYear = i;
                                bestScore = j;
                            }
                        }
                    }

                    System.out.println("The score of " + names[bestScore] + " in year " + (bestYear + 1) + " is the best of all, the score is" + scores[bestYear][bestScore] + ".");
                    break;
                case 4:
                    System.out.println("Please enter subject number");
                    int subjectId = scanner.nextInt();
                    if (subjectId <= 0 || totalScoreCount < subjectId) {
                        System.out.println("Illegal subject number:" + subjectId);
                        cont = false;
                        break;
                    }
                    subjectId = subjectId - 1;
                    year = 0;
                    for (int i = 1; i < yearCount; i++) {
                        if (scores[year][subjectId] < scores[i][subjectId]) {
                            year = i;
                        }
                    }
                    System.out.println("The best score of"  + names[subjectId] +" is in year "+ (year + 1) + ", the score is " + scores[year][subjectId] + ".");

                    break;
                default:
                    cont = false;
                    System.out.println("Illegal operation " + oprtId + " program ends.");
            }
        }

    }
}
