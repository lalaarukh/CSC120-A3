import java.util.Scanner;
import java.util.Random;

class Conversation {
  public static void main(String[] arguments) {

    System.out.println("How many rounds?");
    Scanner in = new Scanner(System.in);
    int r = in.nextInt();
    in.nextLine();
    System.out.println("Hi there! What's on your mind?");

    String[] canned_responses = new String[] {"I know right!", "Tell me about it", "Oh my God me too"};
    Random random = new Random();
    String[] toMirror = {"I","i", "me", "am","you","my","your"};
    String[] replacements = {"you","you","you", "are","I","your","my"};
    String input;
    String[] transcript = new String[2 * r + 2];
    transcript[0] = "Hi there! What's on your mind?";

    for (int i = 1; i <= r; i++){
      input = in.nextLine();
      transcript[2 * i - 1] = "User: " + input;
      String[] words = input.split(" ");
      String mirrored = "";
      for (int j = 0; j < words.length; j++){
        String l = " ";
        for (int m = 0; m < toMirror.length; m++ ){
          if (words[j].equals(toMirror[m])){
            l = replacements[m];
          }
        }
        if (l.equals(" ")){
          l = words[j];
        }
        mirrored += l + " ";
      }
      if (!mirrored.equals(" ")){
        System.out.println("Machine: " + mirrored);
        transcript[2 * i] = "Machine: " + mirrored;
      } else {
        String response = canned_responses[random.nextInt(canned_responses.length)];
        System.out.println("Machine: " + response);
        transcript[2 * i] = "Machine: " + response;
      }
    }

    System.out.println("See ya!");
    transcript[2 * r + 1] = "See ya!";
    System.out.println("\nTRANSCRIPT:");
    for (String s : transcript){
      if (s != null){
        System.out.println(s);
      }
    }
    in.close();
  }
}
