import java.io.File;
import java.util.Scanner;

public class FileManager {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter directory path: ");
      String path = input.nextLine();
      File directory = new File(path);
      if (!directory.exists()) {
         System.out.println("Directory does not exist.");
         return;
      }
      System.out.println("File Manager");
      System.out.println("1. List files");
      System.out.println("2. Create a new file");
      System.out.println("3. Delete a file");
      System.out.println("4. Quit");
      System.out.print("Enter your choice: ");
      int choice = input.nextInt();
      switch (choice) {
         case 1:
            listFiles(directory);
            break;
         case 2:
            System.out.print("Enter file name: ");
            input.nextLine(); // Consuming the newline character
            String fileName = input.nextLine();
            createFile(directory, fileName);
            break;
         case 3:
            System.out.print("Enter file name: ");
            input.nextLine(); // Consuming the newline character
            fileName = input.nextLine();
            deleteFile(directory, fileName);
            break;
         case 4:
            System.out.println("Exiting file manager.");
            break;
         default:
            System.out.println("Invalid choice.");
            break;
      }
      input.close();
   }

   private static void listFiles(File directory) {
      File[] files = directory.listFiles();
      System.out.println("Files in " + directory.getAbsolutePath());
      for (File file : files) {
         System.out.println(file.getName());
      }
   }

   private static void createFile(File directory, String fileName) {
      File file = new File(directory, fileName);
      try {
         if (file.createNewFile()) {
            System.out.println("File created.");
         } else {
            System.out.println("File already exists.");
         }
      } catch (Exception e) {
         System.out.println("Error creating file.");
      }
   }

   private static void deleteFile(File directory, String fileName) {
      File file = new File(directory, fileName);
      if (!file.exists()) {
         System.out.println("File does not exist.");
      } else {
         if (file.delete()) {
            System.out.println("File deleted.");
         } else {
            System.out.println("Error deleting file.");
         }
      }
   }
}
