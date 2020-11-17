package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    File inputFile;
    File outputFile;
    String dataType;
    String sortingType;

    public FileHandler(File inputFile, File outputFile, String dataType, String sortingType) throws FileNotFoundException {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.dataType = dataType;
        this.sortingType = sortingType;
    }

    public List<String> read() {
        List<String> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: ");

        }
        return list;
    }

    public void write(List<String> list) throws IOException {
        FileWriter writer = new FileWriter(outputFile);
        for (String s : list) {
            writer.write(s);
        }
        writer.close();
    }

}
