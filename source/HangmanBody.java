import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class HangmanBody {
    String source;
    HangmanArt hangmanArt;
    HangmanBody(){
        this.hangmanArt=new HangmanArt();
    }
    //main game logic
    public void hangmanGame(String source) {
        Scanner sc=new Scanner(System.in);
        //reading the files...source provided during function call in main
        try(BufferedReader reader=new BufferedReader(new FileReader(source))){
            ArrayList <String> wordList=new ArrayList<>();
            String lines;
            int noOfGuesses=1;
            while((lines=reader.readLine())!=null){
                wordList.add(lines.trim().toUpperCase());
            }
            //random object
            Random rand=new Random();
            //getting a random item from the arraylist as our word to guess
            String word=wordList.get(rand.nextInt(wordList.size()));
            //new arraylist to store the random word in hidden format
            ArrayList<String> listHidden=new ArrayList<>();
            for(int i=0;i<word.length();i++){
                listHidden.add("_ ");
            }

            //printing the hidden dashed arraylist as dashed word
            String wordHidden="";
            for(int i=0;i<listHidden.size();i++){
                wordHidden+= listHidden.get(i);
            }
            System.out.println("***************************");
            System.out.println("HERE WE GO!");
            System.out.print("WORD: ");
            System.out.println(wordHidden);
            System.out.println("***************************");

            //creating guess logic
            while(noOfGuesses<=6) {
                //accepting guess as user input
                System.out.print("GUESS A LETTER: ");
                char guess=sc.next().toUpperCase().charAt(0);
                //create a flag to mark true and false for the matching condition
                boolean isFound=false;
                //chack for a matching character
                for(int i=0;i<word.length();i++){
                    if(word.charAt(i)==guess){
                        isFound=true;
                        listHidden.set(i,guess+" ");
                    }
                }
                //if u guess right
                if(isFound){
                    System.out.println("WOW...YOU GUESSEDD IT RIGHT!👍");
                    System.out.print("WORD: ");
                    for(int i=0;i< listHidden.size();i++){
                        System.out.print(listHidden.get(i)+" ");
                    }
                    //if we guess wrong
                }else if(isFound!=true){
                    System.out.println("YOU GUESSED IT WRONG!👎");
                    System.out.print("WORD: ");
                    for(int i=0;i< listHidden.size();i++){
                        System.out.print(listHidden.get(i)+" ");
                    }
                    System.out.println();
                    //hangman art
                    System.out.printf("NO.OF WRONG GUESSES: %d\n",noOfGuesses);
                    hangmanArt.printHangman(noOfGuesses);
                    noOfGuesses++;
                }

                //if we guess it all right
                if (!listHidden.contains("_ ")) {
                    System.out.println();
                    System.out.println("CONGRATULATIONS!YOU WIN!🥳");
                    System.out.printf("THE WORD WAS : %s\n",word);
                    return;

                }
                //while loop ends
            }
            System.out.println("NO.OF WRONG GUESSES: 6");
            hangmanArt.printHangman(noOfGuesses);
            System.out.println("GAME OVER!YOU LOSE!😔");
            System.out.printf("THE WORD WAS : %s\n",word);
        }catch (FileNotFoundException e){
            System.out.println("Sorry! File not found!");
        }catch(IOException e){
            System.out.println("I/O Error!");
        }
    }


}
