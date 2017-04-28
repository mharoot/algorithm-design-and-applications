import java.io.*;

/**
 * Created by michael on 4/27/17.
 */
public class Driver {


    private static File getFile(String filename) throws IOException  {
        String dir = System.getProperty("user.dir");
        return new File(dir, filename);
    }

    private static String getFileContent(String filename) throws IOException {
        //Read text from file
        StringBuilder content = new StringBuilder();
        BufferedReader br = new BufferedReader(getFileReader(filename));
        String line;

        while ((line = br.readLine()) != null) {
            content.append(line);
            content.append('\n');
        }
        line = content.toString();
        br.close();
        return line;
    }

    private static FileReader getFileReader(String filename) throws IOException {
        return new FileReader(getFile(filename));
    }

    public static void main(String[] args) {
        try {
            String txt = getFileContent("src/GraphData.txt");
            System.out.println(txt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
