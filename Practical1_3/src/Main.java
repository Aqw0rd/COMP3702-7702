import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        removeLetterFromFile(args[0], args[1], args[2]);
    }

    private static void removeLetterFromFile(String fileName, String outputFileName, String letter){
        try {
            File inputFile = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter fw = new FileWriter(outputFileName, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            String st;
            String temp = "";
            while((st = br.readLine()) != null){
                temp += st.replaceAll(letter, "") + "\n";
            }
            out.println(temp);
            out.close();
            br.close();
            fw.close();
            bw.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }

    }
}
