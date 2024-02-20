import java.util.Scanner;

public class superOver {
    static String usr="Player"; // user name
    static int sysn, n;
    static int Flick, sysFlick;
    static int sovScore, sysSovScore, wick;
    static final int tossMin=1, tossMax=2; // for toss/flick/choice
    static final int bMin=1, bMax=10; // for sysn
    static int mode=0, vn=0;

    public static void main(String[] args) {
        superOver();
    }

    public static void superOver() {
        Scanner sov = new Scanner(System.in);
        print("Its a Super-Over!! \n");
        print("Each player gets six balls & two wickets.. \n");
        print("The one who gets more runs wins.. \n");
        
        // Player Batting
        print("You're batting first.. \nEnter numbers from 1 to " + bMax + ".. \n");
        print("[Note: Entering no. < 1 or > " + bMax + " = FLICK..] \n");

        wick = 2;
        outer:
        for(int i=1; i<=6; i++){
            print(usr + ": ", 10);
            n = sov.nextInt();
            sysn = (int)Math.floor(Math.random()*(bMax-bMin+1)+bMin);
            sovScore += n;
            print("Computer: " + sysn + "\n", 10);

            // Flick
            if((n < 1) || (vn == 0 && n > 10) || (vn == 1 && n > 6)) {
            sovScore -= n;
            while((n < 1) || (vn == 0 && n > 10) || (vn == 1 && n > 6)){
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
            
            if(mode == 0) {
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
            } else if(mode == 1) {
                if((n+1 == sysn || n-1 == sysn) && (wick == 2)){
                    sovScore -= n;
                    wick -= 1;
                    print("You've lost a wicket! \n");
                    print("Remaining Wickets: " + wick + "\n");
                    print("Your Score: " + sovScore + "\n");
                } else if((n+1 == sysn || n-1 == sysn) && (wick == 1)){
                    sovScore -= n;
                    print("You're out! \n");
                    print("Your Score: " + sovScore + "\n");
                    break;
                }
    
                if(n == sysn) {
                    sovScore -=n;
                    sovScore += n*n;
                    print(n*n + " (" + n + "^2)" + " has been added to the score! \n");
                }
            }

            if(i == 6) {
                print("Your Score: " + sovScore + "\n");
            }
        }

        // Computer Batting
        print("The computer is now batting.. \nEnter numbers from 1 to " + bMax + ".. \n");
        print("[Note: Entering no. < 1 or > " + bMax + " = FLICK..] \n");

        wick = 2;
        for(int i=1; i<=6; i++){
            print(usr + ": ", 10);
            n = sov.nextInt();
            sysn = (int)Math.floor(Math.random()*(bMax-bMin+1)+bMin);
            sysSovScore += n;
            print("Computer: " + sysn + "\n", 10);

            // reball
            while((n < 1) || (vn == 0 && n > 10) || (vn == 1 && n > 6)){
                print("Invalid Input.. \n");
                print(usr + ": ", 10);
                n = sov.nextInt();
                sysn = (int)Math.floor(Math.random()*(bMax-bMin+1)+bMin);
            }
            if(mode == 0) {
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
            } else if(mode == 1) {
                if((n+1 == sysn || n-1 == sysn) && (wick == 2)){
                    sovScore -= n;
                    wick -= 1;
                    print("The computer lost a wicket! \n");
                    print("Remaining Wickets: " + wick + "\n");
                    print("The computer's Score: " + sysSovScore + "\n");
                } else if((n+1 == sysn || n-1 == sysn) && (wick == 1)){
                    sovScore -= n;
                    print("The computer is out! \n");
                    print("The computer's Score: " + sysSovScore + "\n");
                } else if(sysSovScore > sovScore) {
                    wick = 0;
                    print("The Computer's Score: " + sysSovScore + "\n");
                    print("You've lost the game.. L \n");
                    System.exit(0);
                }
    
                if(n == sysn) {
                    sysSovScore -=sysn;
                    sysSovScore += sysn*sysn;
                    print(sysn*sysn + " (" + sysn + "^2)" + " has been added to the score! \n");
                }
            }

            if(i == 6) {
                print("The Computer's Score: " + sysSovScore + "\n");
            }
        }
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
