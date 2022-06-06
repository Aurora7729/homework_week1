import java.util.Scanner;

public class MathGame {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // 游戏设置
        int rangeStart = 1;
        int rangeEnd = 50;
        int Total_chances = 10;

        // 游戏统计
        int totalGameCount = 0;
        int totalCorrectCount = 0;

        // 是否结束游戏
        boolean Stop_flag = false;

        while (!Stop_flag) {
            // 初始化本次游戏的变量
            int guessLeft = Total_chances;
            int rangelenth = rangeEnd - rangeStart;
            double randNum = Math.random();
            int num = ((int) (randNum * rangelenth  + rangeStart)) ;
            System.out.println(num);
            num += rangeStart;
            if (num <= rangeStart) {
                num = rangeStart + 1;
            }
            if (num >= rangeEnd) {
                num = rangeEnd - 1;
            }

            System.out.println("=================== Guess number ===================");
            System.out.println("The number have been randomly created.The number range is between" + rangeStart + "to" + rangeEnd );
            System.out.println(Total_chances + "chances in total.Enter -1 to end the game at any time.");

            // 本次游戏是否开始了
            boolean Start_flag = true;
            // 本次是否猜中数字
            boolean Correct_flag = false;
            while (guessLeft > 0) {
                if(guessLeft == 1)
                    System.out.println(guessLeft + "chance left,Please enter the guessed number and press Enter to confirm");
                else
                    System.out.println(guessLeft + "chances left,Please enter the guessed number and press Enter to confirm");

                int guessNum = in.nextInt();
                // 输入-1，结束游戏
                if (guessNum == -1) {
                    Stop_flag = true;
                    break;
                }

                if (guessNum <= rangeStart || guessNum >= rangeEnd) {
                    System.out.println("Please input a number between" + rangeStart + "to" + rangeEnd );
                    continue;
                }
                // 只要至少猜过一次，就算玩过了。
                if (Start_flag) {
                    totalGameCount++;
                    Start_flag = false;
                }
                // 可以用的猜测次数减1
                guessLeft--;
                if (guessNum == num) {
                    totalCorrectCount++;
                    Correct_flag = true;
                    System.out.println("Congratulations! The number is" + num +
                            ".You guessed " + (Total_chances - guessLeft) + "times.");
                    break;
                } else if (guessNum > num) {
                    System.out.println("The number you guess is larger than the target number.");
                } else {
                    System.out.println("The number you guess is smaller than the target number.");
                }
            }

            if (!Correct_flag) {
                System.out.println("The target number is " + num + ".You failed this time.");
            }
        }

        System.out.println("Number of games:" + totalGameCount + ". Number of successes:" + totalCorrectCount + ".");
    }
}