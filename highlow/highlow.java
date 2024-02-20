import java.util.Scanner;

public class highlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        loading();
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
