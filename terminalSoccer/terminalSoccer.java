// Under Development..

import java.util.Scanner;

public class terminalSoccer {
    static String usr="Player";
    static boolean ball=true;
    static int tpass, pass;
    static int p, sysp;
    static final int pMin=1, pMax=3; // during passes

    public static void main(String[] args) {
        Scanner main = new Scanner(System.in);
        print("Welcome! \n");
        print("Enter player name: ");
        usr = main.next();
        print("Hello " + usr + "!\n");
        print("How many passes? ");
        tpass = main.nextInt();
        while(tpass <= 1) { // Invalid Input..
            print("Invalid Input.. \nEnter a number greater than 1.. \n");
            print("How many passes? ");
            tpass = main.nextInt();
        }

        print("Aight! \n" + tpass + " passes needed for goal time.. \n");
        print("You have the ball.. \n");
        print("Enter numbers from 1 to 3.. \n");
        print("[Note: input > 3 = Foul] \n");

        for(int pass=tpass; pass!=0; pass--){
            print(usr + ": ");
            p = main.nextInt();
            sysp = (int)Math.floor(Math.random()*(pMax-pMin+1)+pMin);
            print("Computer: " + sysp + "\n");

            // foul
            if(p < 1 || p > 3) {
                foul();
            }

            if(p == sysp) {
                if(ball==true) {
                    print("The computer got the ball.. \n");
                    ball=false;
                    pass=tpass;
                } else {
                    print("You got the ball.. \n");
                    ball=true;
                    pass=tpass;
                }
            }
        }
        if(ball==true){
            print("Its Goal Time for " + usr + "!\n");
            goalTime();
        } else {
            print("Its Goal Time for Computer! \n");
            goalTime();
        }
    }

    public static void foul() { // might remove..
        print("It's a foul by " + usr + "!\n");
        System.exit(0); // for now ¯\_(ツ)_/¯
    }

    public static void goalTime() { // might remove..
        print("Enter numbers from 4 to 6.. \n");
        print("[Note: input > 3 = Foul] \n");
        System.exit(0); // for now ¯\_(ツ)_/¯
    }

    public static void print(String t, Integer...n) {
        Integer n1 = n.length > 0 ? n[0] : 50;
        for(int i = 0; i < t.length(); i++){
            System.out.printf("%c", t.charAt(i));
            try{
                Thread.sleep(n1); // Default Delay: 0.05s
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    }
}
