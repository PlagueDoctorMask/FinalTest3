package FinalTest3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {
        System.out.println("Welcome to animal registry\nChoose the command:");
        int choice = 0;
        while (choice != 3){
            Scanner scanner = new Scanner(System.in);
            System.out.println("");
            System.out.println("1)Create a new animal\n2)Create new action\n3)Exit");
            choice = scanner.nextInt();
            if (choice == 1) {
                Create_Animal();
            }
            if (choice == 2) {
                Create_Action();
            }
            if (choice == 3) {
                System.out.println("Goodbye!");
            }
        }
        
    }
    public static void Create_Animal(){
        System.out.println("");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Choose new animal");
    String new_animal = scanner.nextLine();
    String filename = new_animal + ".java";
    System.out.println("Does it belongs to pets or pack animals?");
    String answer = scanner.nextLine();
    try(FileWriter fileWriter = new FileWriter(filename, true)){
            fileWriter.write(
                "package FinalTest3;\r\n" + //
                        "\r\n" + //
                        "public class "+new_animal+" extends "+answer+" implements Action{\r\n" + //
                        "    private int id;\r\n" + //
                        "\r\n" + //
                        "    private String names;\r\n" + //
                        "\r\n" + //
                        "    private String actions;\r\n" + //
                        "\r\n" + //
                        "    private String birthdate;\r\n" + //
                        "\r\n" + //
                        "    private int species_id;\r\n" + //
                        "\r\n" + //
                        "\r\n" + //
                        "    public void action(){\r\n" + //
                        "        System.out.println(\"\");\r\n" + //
                        "    }\r\n" + //
                        "}"
            );
            fileWriter.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        moveFile("C:/Users/Dmitriy/Desktop/Ft3/"+filename,"C:/Users/Dmitriy/Desktop/Ft3/FinalTest3/"+filename);
        
}
public static void Create_Action(){
    System.out.println("");
    Scanner scanner = new Scanner(System.in);
    System.out.println("Choose the animal");
    String animal_choice = scanner.nextLine();
    System.out.println("Choose the action");
    String new_action = scanner.nextLine();
    String filename = animal_choice + ".java";
    Path path = Paths.get("C:/Users/Dmitriy/Desktop/Ft3/FinalTest3/"+filename);
    String text = "public static void "+new_action+"() {\r\n" + //
            "        System.out.println(\""+new_action+"ing\");\r\n" + //
            "    }";
 
    try {
        Files.write(path, text.getBytes(), StandardOpenOption.APPEND);
        System.out.println("Action was created succefully");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
private static void moveFile(String src, String dest ) {
    Path result = null;
    try {
       result =  Files.move(Paths.get(src), Paths.get(dest));
    } catch (IOException e) {
       System.out.println("Exception while moving file: " + e.getMessage());
    }
    if(result != null) {
       System.out.println("Animal was created successfully.");
    }else{
       System.out.println("Animal creation failed.");
    }  
 }

}
