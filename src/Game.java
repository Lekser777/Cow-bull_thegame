import java.util.List;
import java.util.Random;

public class Game {

    int[]question;
    int cows;
    int bulls;

    public Game(){
        this.cows=0;
        this.bulls=0;

        Random random1=new Random();
        int num1=random1.nextInt(10);

        Random random2=new Random();
        int num2=random2.nextInt(10);
        while (num2==num1){num2=random2.nextInt(10);}

        Random random3=new Random();
        int num3=random3.nextInt(10);
        while (num3==num1||num3==num2){num3=random3.nextInt(10);}

        Random random4=new Random();
        int num4=random4.nextInt(10);
        while (num4==num1||num4==num2||num4==num3){num4=random4.nextInt(10);}

        int []question={num1,num2,num3,num4};
        this.question=question;


    }
    public int calcBulls(int[]answer){
        bulls=0;
        for (int i=0;i<question.length;i++)
        {
           if(question[i]==answer[i]){
               bulls++;
           }
        }
        return bulls;
    }
    public int calcCows(int[]answer){
        cows=0;
        for (int i=0;i<question.length;i++)
        {
            for (int j=0;j<answer.length;j++)
            {
                if(question[i]==answer[j]&&i!=j){
                    cows++;

                }
            }
        }
        return cows;
    }

    public int[] getQuestion() {
        return question;
    }
}
