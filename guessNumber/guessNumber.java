import java.util.Scanner;

public class guessNumber {
    static int guess=1;
    static int n, sysn;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //loading();

        print("Welcome to Guess_The_Number! \n");

        print("I'm thinking of a number b/w 1 & 10. \n");
        print("Guess the number! \n");
        print("You've got 3 tries.. \n");
        print("Enter -1 to quit the game.. \n");

        while(n!=-1) {
            sysn = (int)Math.floor(Math.random()*(10-1+1)+1);
            while(guess!=4 && n!=-1) {
                print("Guess " + guess + ": ");
                n = sc.nextInt();
                guess++;

                if(n==sysn) {
                    print("Yup.. its " + n + ".. GG! \n");
                    break;
                } else if(n!=sysn && n!=-1) {
                    print("Incorrect.. \n");
                }
            } if(n!=-1) {
                print("New Game.. \n");
                guess=1;
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
}
