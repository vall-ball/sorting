package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(final String[] args) throws IOException {
        ArgsParser argsParser = new ArgsParser(args);

        if (!argsParser.isSortingType()) {
            System.out.println("No sorting type defined!");
        }

        if (!argsParser.isDataType()) {
            System.out.println("No data type defined!");
        }

        if (argsParser.isSortingType() && argsParser.isDataType()) {
            String dataType = argsParser.dataType();
            String sortingType = argsParser.sortingType();

            if (argsParser.isInputFile() && argsParser.isOutputFile()) {
                File inputFile = new File(argsParser.nameOfInputFile());
                File outputFile = new File(argsParser.nameOfOutputFile());
                FileHandler fileHandler = new FileHandler(inputFile, outputFile, dataType, sortingType);
                List<String> list = fileHandler.read();
                List<String> answer;

                switch (dataType) {
                    case "word":
                        FileWordHandler fileWordHandler = new FileWordHandler(list, sortingType);
                        answer = fileWordHandler.handle();
                        System.out.println("Ща пишу ворд");
                        fileHandler.write(answer);
                        break;
                    case "line":
                        FileLineHandler fileLineHandler = new FileLineHandler(list, sortingType);
                        answer = fileLineHandler.handle();
                        System.out.println("Ща пишу лайн");
                        fileHandler.write(answer);
                        break;
                    case "long":
                        FileNumberHandler fileNumberHandler = new FileNumberHandler(sortingType, list);
                        answer = fileNumberHandler.handle();
                        System.out.println("Ща пишу лонг");
                        System.out.print(answer);
                        System.out.print(outputFile.getName());
                        fileHandler.write(answer);
                        break;
                }

            } else {
                switch (dataType) {
                    case "word":
                        WordHandler wordHandler = new WordHandler(sortingType);
                        wordHandler.handle();
                        break;
                    case "line":
                        LineHandler lineHandler = new LineHandler(sortingType);
                        lineHandler.handle();
                        break;
                    case "long":
                        NumberHandler numberHandler = new NumberHandler(sortingType);
                        numberHandler.handle();
                        break;
                }
            }
        }
    }
}

/*
        String sortingType = "natural";
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-sortingType")) {
                    sortingType = args[i + 1];
                    break;
                }
            }
        }

        String dataType = "long";
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-dataType")) {
                    dataType = args[i + 1];
                    break;
                }
            }
        }
 */