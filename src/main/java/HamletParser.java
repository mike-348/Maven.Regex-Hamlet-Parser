import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String replaceHamletWithLeon(String text) {

//        Pattern pattern = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
        Pattern pattern1 = Pattern.compile("Hamlet");
        Matcher matcher1 = pattern1.matcher(text);
        String result = matcher1.replaceAll("Leon");

        Pattern pattern2 = Pattern.compile("HAMLET");
        Matcher matcher2 = pattern2.matcher(result);
        result = matcher2.replaceAll("LEON");
        return result;
    }

    public String replaceHoratioWithTariq(String text) {

//        Pattern pattern = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
        Pattern pattern1 = Pattern.compile("Horatio");
        Matcher matcher1 = pattern1.matcher(text);
        String result = matcher1.replaceAll("Tariq");

        Pattern pattern2 = Pattern.compile("HORATIO");
        Matcher matcher2 = pattern2.matcher(result);
        result = matcher2.replaceAll("TARIQ");
        return result;
    }

    public int findHamlet(String text) {
        Pattern pattern1 = Pattern.compile("Hamlet");
        Pattern pattern2 = Pattern.compile("HAMLET");

        Matcher matcher1 = pattern1.matcher(text);
        Matcher matcher2 = pattern2.matcher(text);

        if (matcher1.find()) {
            return 1;
        } else if (matcher2.find()) {
            return 2;
        } else return -1;
    }

    public int findHoratio(String text) {
        Pattern pattern1 = Pattern.compile("Horatio");
        Pattern pattern2 = Pattern.compile("HORATIO");

        Matcher matcher1 = pattern1.matcher(text);
        Matcher matcher2 = pattern2.matcher(text);

        if (matcher1.find()) {
            return 1;
        } else if (matcher2.find()) {
            return 2;
        } else return -1;
    }

}
