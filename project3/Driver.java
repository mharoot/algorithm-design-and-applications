import java.awt.List;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by michael on 4/27/17.
 */
public class Driver {


    private static File getFile(String filename) {
        String dir = System.getProperty("user.dir");
        return new File(dir, filename);
    }

    private static String getFileContent(String filename) throws IOException {
        //Read text from file
        StringBuilder content = new StringBuilder();
        BufferedReader br = new BufferedReader(getFileReader(filename));
        String line;

        ArrayList list = new ArrayList();
        while ((line = br.readLine()) != null) {
            content.append(line);
            list = findIntegersInString(line);
            content.append('\n');
        }
        line = content.toString();
        br.close();
        return line;
    }

    private static FileReader getFileReader(String filename) throws FileNotFoundException {
    	FileReader fr = null;
        try {
			fr = new FileReader(getFile(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			fr = new FileReader(new File(filename));
		}
        return fr;
    }
    
    private static ArrayList findIntegersInString(String str) {
    	char[] charArr = str.toCharArray();
    	int n = charArr.length;
    	char ch;
    	String num = "";
    	ArrayList<Integer> integers = new ArrayList<Integer>();

    	for (int i = 0; i < n; i++) {
    		ch = charArr[i];
    	    if (ch != ' ') {
    	    	num += ch;
    	    } else if (ch == ' ' && num.length() > 0) {
    	    	// finished scanning a number so convert to integer
    	    	System.out.print(num+" ");
    	    	integers.add(Integer.valueOf(num));
    	    	num = "";
    	    }
    	}
    	
    	// if we still have a last number not processed add it
    	if (num.length() > 0 && Integer.valueOf(num) > 0 ) integers.add(Integer.valueOf(num));
    	System.out.println(num);
    	
		return integers;
    }

    
    
    
    public static void main(String[] args) throws IOException {
        
    	String whatIType = "src/GraphData.txt";
    	String whatDianeTypes = "/home/michael/Documents/eclipse/workspace/Project3Comp496Alg/src/GraphData.txt";

    	
    	Graph graph = new Graph(whatIType);
    	graph.printGraph();
    }
}
