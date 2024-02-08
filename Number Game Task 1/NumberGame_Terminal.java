import java.util.*;
public class NumberGame_Terminal {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        Random rand = new Random();
        int target = rand.nextInt(1,101);
        int Guess,Attempt=0;
        
        while(true)
        {
                System.out.println("\nEnter your Guess Between 1 and 100");
                Guess = sc.nextInt();
                Attempt++;
                if(Attempt<=12)
                {
                    if(Guess>target)
                    System.out.println("\nAttempts Remaining: "+(((12-Attempt)==0)?"Final Attempt":(12-Attempt) ) +"\nEnter low Number");
                    else if(Guess<target)
                    System.out.println("\nAttempts Remaining: "+(((12-Attempt)==0)?"Final Attempt":(12-Attempt) ) +"\nEnter high Number");
                    else if(Guess==target)
                    {
                        int score = 0;
                        if(Attempt==1) score=10;
                        else if(Attempt<=3) score = 9;
                        else if(Attempt<=4) score = 8;
                        else if(Attempt<=5) score = 7;
                        else if(Attempt<=7) score = 6;
                        else if(Attempt<=8) score = 5;
                        else if(Attempt<=9) score = 4;
                        else if(Attempt<=10) score = 3;
                        else if(Attempt<12) score = 2;
                        else if(Attempt==12) score = 1;
                        System.out.println(" ======================");
                        System.out.println("|   Correct Guess!!    |\n"+"|     Attempts: "+Attempt+"      |\n|     Score: "+score+"/10      |");
                        System.out.println(" ======================");
                        System.out.println("\nWant to Play Again? Yes/No:");
                        String again = sc.next();
                        Attempt = 0;
                        target = rand.nextInt(1,101);
                        if(!again.equals("Yes") && !again.equals("yes")) break;
                    }
                }
                else{
                    System.out.println(" ===========================");
                    System.out.println("|   Better Luck Next Time    |"+"\n|    Attempts Over!!         |");
                    System.out.println(" ===========================");
                    System.out.println("\nWant to Play Again? Yes/No:");
                    String again = sc.next();
                    Attempt = 0;
                    target = rand.nextInt(1,101);
                    if(!again.equals("Yes") && !again.equals("yes")) break;

                }
        }
        sc.close();
    }
}