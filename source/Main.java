import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HangmanBody hangmanBody=new HangmanBody();
        Scanner sc=new Scanner(System.in);
        String fruitSource="D:\\CODING PROGRAMS\\JAVA\\JAVA projects\\src\\Hangman_List_Fruits";
        String foodSource="D:\\CODING PROGRAMS\\JAVA\\JAVA projects\\src\\Hangman_List_Foods";
        System.out.println("***************************");
        System.out.println("WELCOME TO OUR HANGMAN GAME");
        System.out.println("***************************");
        System.out.println("CHOOSE YOUR WORD TYPE:\n1)FRUITS\n2)FOODS");
        System.out.print("ENTER YOUR CHOICE(1-2): ");
        int choice =sc.nextInt();
        switch (choice){
            case 1: hangmanBody.hangmanGame(fruitSource);
                break;
            case 2:
                hangmanBody.hangmanGame(foodSource);
                break;

        }
    }
    }
