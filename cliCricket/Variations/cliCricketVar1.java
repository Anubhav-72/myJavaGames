// A fun variation.. don't take seriously XD

import java.util.Scanner;

public class cliCricketVar1 {
    static String usr="Player"; // user name
    static int score; // user score
    static int sysScore; // computer score
    static int sysToss, sysFlick, sysn;
    static int Toss, Flick, n;
    static int sovScore, sysSovScore, wick;
    static int choice; // 1 = batting, 2 = balling
    static final int tossMin=1, tossMax=2; // for toss/flick/choice
    static final int bMin=1, bMax=10; // for sysn

    public static void main(String[] args) {
        Scanner main = new Scanner(System.in);
        loading();
        print("Welcome to C.L.I. Cricket! \n");
        print("Enter player name: ");
        usr = main.next();
        print("Hello " + usr + "!\n");

        print("Difficulty Levels: [0 = Normal, 1 = Impossible] \n");
        print("Enter Difficulty Level: ");
        int dif = main.nextInt();

        while(dif > 1 || dif < 0){
            print("Invalid Input.. \n");
            print("Enter Difficulty Level: ");
            dif = main.nextInt();
        }

        if(dif==1){
            impossible();
        } else {
        toss();
        while(Toss > 2 || Toss < 1){ // Invalid Input
            print("Invalid Input.. \n");
            toss();
        }
        // Check Toss:
        if(Toss == sysToss) {
            print("You've won the Toss! \n");
            print("Enter 1 for bat or 2 for ball: ");
            choice = main.nextInt();
        } else {
            System.out.println("You've lost the Toss..");
            choice = (int)Math.floor(Math.random()*(tossMax-tossMin+1)+tossMin);
        }

        // batting first
        if(choice == 1) {
            print("You're batting first.. \nEnter numbers from 1 to 10.. \n");
            print("[Note: Entering no. < 1 or > 10 = FLICK..] \n");
            batting(1);
            print("You're now balling.. \nEnter numbers from 1 to 10.. \n");
            print("[Note: Entering no. < 1 or > 10 = REBALL..] \n");
            balling(2);
        }
        // balling first
        else {
            print("You're balling first.. \nEnter numbers from 1 to 10.. \n");
            print("[Note: Entering no. < 1 or > 10 = REBALL..] \n");
            balling(1);
            print("You're now batting.. \nEnter numbers from 1 to 10.. \n");
            print("[Note: Entering no. < 1 or > 10 = FLICK..] \n");
            batting(2);
        }

        // Check Score
        if(score > sysScore){
            print("GG.. You've won the game!! \n");
            System.exit(0);
        } else if (score < sysScore) {
            print("You've lost the game.. L \n");
            System.exit(0);
        } else {
            superOver();
        }
        }
    }

    public static void impossible() {
        Scanner hd = new Scanner(System.in);

        print("You've lost the game.. L \n");
        print("Do you wanna try again (y/n)? ");
        char rematch = hd.next().charAt(0);

        while(rematch != 'y' && rematch != 'n') {
            print("Invalid Input.. \n");
            print("Do you wanna try again (y/n)? ");
            rematch = hd.next().charAt(0);
        }

        if(rematch == 'y') {
            print("I don't play with Losers XD \n");
        } else {
            System.exit(0);
        }
    }

    public static void loading() {
        print("Loading.. ");
        for(int i=0; i<=100; i+=10) {
            print(i + "%", 15);
            if(i<10){
                print("\b\b");
            } else {
                print("\b\b\b");
            }
        } System.out.print("\033[2K\r");
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

    public static void toss() {
        Scanner toss = new Scanner(System.in);
        print("Enter 1 or 2 for Toss: ");
        Toss = toss.nextInt();
        sysToss = (int)Math.floor(Math.random()*(tossMax-tossMin+1)+tossMin);
    }

    public static void batting(int x) {
        Scanner b1 = new Scanner(System.in);
        outer:
        while(true){
            print(usr + ": ", 10);
            n = b1.nextInt();
            sysn = (int)Math.floor(Math.random()*(bMax-bMin+1)+bMin);
            score += n;
            print("Computer: " + sysn + "\n", 10);
            
            // Flick
            if(n < 1 || n > 10) {
            score -= n;
            while(n < 1 || n > 10){
                print("Its a Flick.. \nEnter 1 or 2 for Flick: ");
                Flick = b1.nextInt();
                sysFlick = (int)Math.floor(Math.random()*(tossMax-tossMin+1)+tossMin);

                if(Flick == sysFlick){
                    print("You've won the Flick! \nYou can continue.. \n");
                    break;
                } else {
                    if(x==2){
                        print("You've lost the Flick! \nYou've lost the game.. L\n");
                        System.exit(0);
                    } else {
                        print("You've lost the Flick! \n");
                        break outer;
                    }
                }
            }}

            // Check if out
            if(n == sysn){
                score -= n;
                print("You're out.. \n");
                print("Your Score: " + score + "\n");
                break;
            } else if(x == 2 && score > sysScore) { // only if batting second
                print("Your Score: " + score + "\n");
                break;
            }
        }
    }

    public static void balling(int y) {
        Scanner b2 = new Scanner(System.in);
        while(true){
            print(usr + ": ", 10);
            n = b2.nextInt();
            sysn = (int)Math.floor(Math.random()*(bMax-bMin+1)+bMin);
            
            // reball
            while(n < 1 || n > 10){
                print("Invalid Input.. \nReball.. \n");
                print(usr + ": ", 10);
                n = b2.nextInt();
                sysn = (int)Math.floor(Math.random()*(bMax-bMin+1)+bMin);
            }
            
            sysScore += sysn;
            print("Computer: " + sysn + "\n", 10);
            
            // Check if out:
            if(n == sysn){
                sysScore -= sysn;
                print("The computer is out.. \n");
                print("The Computer's Score: " + sysScore + "\n");
                break;
            } else if(y == 2 && sysScore > score) { // only if balling second
                print("The Computer's Score: " + sysScore + "\n");
                break;
            }
        }
    }

    public static void superOver() {
        Scanner sov = new Scanner(System.in);
        print("Its a Super-Over!! \n");
        print("Each player gets six balls & two wickets.. \n");
        print("The one who gets more runs wins.. \n");
        
        // Player Batting
        print("You're batting first.. \nEnter numbers from 1 to 10.. \n");
        print("[Note: Entering no. < 1 or > 10 = FLICK..] \n");

        wick = 2;
        outer:
        for(int i=1; i<=6; i++){
            print(usr + ": ", 10);
            n = sov.nextInt();
            sysn = (int)Math.floor(Math.random()*(bMax-bMin+1)+bMin);
            sovScore += n;
            print("Computer: " + sysn + "\n", 10);

            // Flick
            if(n < 1 || n > 10) {
            sovScore -= n;
            while(n < 1 || n > 10){
                print("Its a Flick.. \nEnter 1 or 2 for Flick: ");
                Flick = sov.nextInt();
                sysFlick = (int)Math.floor(Math.random()*(tossMax-tossMin+1)+tossMin);

                if(Flick == sysFlick){
                    print("You've won the Flick! \nYou can continue.. \n");
                    break;
                } else {
                    print("You've lost the Flick! \n");
                    break outer;
                }
            }}

            if(n == sysn && wick == 2){
                sovScore -= n;
                wick -= 1;
                print("You've lost a wicket! \n");
                print("Remaining Wickets: " + wick + "\n");
                print("Your Score: " + sovScore + "\n");
            } else if(n == sysn && wick == 1){
                sovScore -= n;
                print("You're out! \n");
                print("Your Score: " + sovScore + "\n");
                break;
            }
        }

        // Computer Batting
        print("The computer is now batting.. \nEnter numbers from 1 to 10.. \n");
        print("[Note: Entering no. < 1 or > 10 = FLICK..] \n");

        wick = 2;
        for(int i=1; i<=6; i++){
            print(usr + ": ", 10);
            n = sov.nextInt();
            sysn = (int)Math.floor(Math.random()*(bMax-bMin+1)+bMin);
            sysSovScore += n;
            print("Computer: " + sysn + "\n", 10);

            // reball
            while(n < 1 || n > 10){
                print("Invalid Input.. \n");
                print(usr + ": ", 10);
                n = sov.nextInt();
                sysn = (int)Math.floor(Math.random()*(bMax-bMin+1)+bMin);
            }

            if(n == sysn && wick == 2){
                sovScore -= n;
                wick -= 1;
                print("The computer lost a wicket! \n");
                print("Remaining Wickets: " + wick + "\n");
                print("The computer's Score: " + sysSovScore + "\n");
            } else if(n == sysn && wick == 1){
                sovScore -= n;
                print("The computer is out! \n");
                print("The computer's Score: " + sysSovScore + "\n");
            } else if(sysSovScore > sovScore) {
                wick = 0;
                print("The Computer's Score: " + sysSovScore + "\n");
                print("You've lost the game.. L \n");
                System.exit(0);
            }
        }

        if(sovScore > sysSovScore) {
            print("GG.. You've won the game!! \n");
            System.exit(0);
        } else {
            print("Its a Draw! \n");
        }
    }
}
