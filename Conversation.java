import java.util.Scanner;
import java.util.Random;

class Conversation {
  public static void main(String[] arguments) {  

    System.out.println("How many rounds?");
    Scanner round_count = new Scanner(System.in); 
    Integer r = round_count.nextInt();
    round_count.close();
    System.out.println("Hello there! What's on your mind?");
  
    String[] canned_responses = new String[] {"I know right!", "Tell me about it", "Oh my God me too"}; 
    Random random = new Random();
    Scanner in = new Scanner(System.in);
    String [] toMirror = {"I", "me", "am","you","my","your"};
    String [] replacements = {"you","you","are","I","your","my"};

    for (int i = 0; i < r; i++){ 
      String input = in.nextLine();
      //String input.nextLine();
      //System.out.println(input);
      String [] words = input.split(" ");
      String newSentence = "";
      for (int j = 0; j < words.length; j++){
        String l = words[j];
        for (int m = 0; m < toMirror.length; m++ ){
          if (words[j].equals(toMirror[j])){
            l = replacements[j]; 
          }
        }
        if (l.equals(" ")){;
          l = words[j];
      }
      newSentence += " " + l;
    }
      String response = canned_responses[random.nextInt(canned_responses.length)];
      System.out.println(response);
    } 

    System.out.println("See ya!");
    in.close();
  }
}
