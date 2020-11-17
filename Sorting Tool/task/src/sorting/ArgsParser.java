package sorting;

import java.util.ArrayList;
import java.util.List;

public class ArgsParser {

    String[] args;
    static final String[] RIGHT_PARAMETERS = {"natural", "byCount", "long", "word", "line", "-sortingType", "-dataType"};

    public ArgsParser(String[] args) {
        this.args = args;
    }

    public boolean isSortingType() {
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-sortingType")) {
                    if (i == args.length - 1) {
                        return false;
                    } else if (!args[i + 1].equals("natural") && !args[i + 1].equals("byCount")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public String sortingType() {
        String sortingType = "natural";
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-sortingType")) {
                    sortingType = args[i + 1];
                    break;
                }
            }
        }
        return sortingType;
    }

    public boolean isDataType() {
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-dataType")) {
                    if (i == args.length - 1) {
                        return false;
                    } else if (!args[i + 1].equals("long") && !args[i + 1].equals("word") && !args[i + 1].equals("line")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public String dataType() {
        String dataType = "long";
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-dataType")) {
                    dataType = args[i + 1];
                    break;
                }
            }
        }
        return dataType;
    }

    public List<String> redundantParameters() {
        List<String> list = new ArrayList<>();
        for (String s : args) {
            if (!isParamInList(s)) {
                list.add(s);
            }
        }
        return list;
    }

    private boolean isParamInList(String param) {
        for (String s : RIGHT_PARAMETERS) {
            if (s.equals(param)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInputFile() {
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-inputFile")) {
                    if (i == args.length - 1) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String nameOfInputFile() {
        String fileName = "";
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-inputFile")) {
                    fileName = args[i + 1];
                    break;
                }
            }
        }
        return fileName;
    }

    public boolean isOutputFile() {
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-outputFile")) {
                    if (i == args.length - 1) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String nameOfOutputFile() {
        String fileName = "";
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-outputFile")) {
                    fileName = args[i + 1];
                    break;
                }
            }
        }
        return fileName;
    }


}
