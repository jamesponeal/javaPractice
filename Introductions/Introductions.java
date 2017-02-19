import java.io.Console;

public class Introductions {

  public static void main(String[] args){
    Console console = System.console();
    String firstName = console.readLine("What is your name?  ");
    console.printf("Hello %s!\n", firstName);
    console.printf("%s is learning how to write Java.\n", firstName);
  }
}

//Type 'javac Introductions.java' in command line to compile the java code into a usable java file.

