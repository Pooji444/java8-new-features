import java.io.*;
import java.util.Scanner;

public class Reader {

    public static String readFunctions(String functionName, String fileName) throws FileNotFoundException {
        StringBuilder builder = new StringBuilder();

        Scanner fileReader = new Scanner(new File(fileName));
        int openBrackets = 0, closedBrackets = 0, startChecking = 0;
        String openBracket = "{", closedBracket = "}";

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            if(line.contains(functionName)) {
                startChecking = 1;
            }
            if(startChecking == 0) {
                continue;
            }
            if(line.contains(openBracket)) {
                openBrackets++;
            }
            if(line.contains(closedBracket)) {
                closedBrackets++;
            }
            if((openBrackets == closedBrackets) && (openBrackets != 0)) {
                builder.append(line).append("\n");
                break;
            }
            builder.append(line).append("\n");
        }

        return builder.toString();
    }

}
