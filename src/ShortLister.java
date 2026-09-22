import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShortLister {

    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        Filter filter = new ShortWordFilter();

        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            try {
                Scanner input = new Scanner(selectedFile);

                System.out.println("Short words (less than 5 characters):");

                while (input.hasNext()) {
                    String word = input.next();

                    if (filter.accept(word)) {
                        System.out.println(word);
                    }
                }

                input.close();

            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }
    }
}