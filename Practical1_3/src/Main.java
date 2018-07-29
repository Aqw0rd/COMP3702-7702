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
            FileWriter fw = new FileWriter(outputFileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            String st;
            while((st = br.readLine()) != null){
                st = st.replaceAll(letter, "");

                out.println(st);
            }
            out.close();
            br.close();
            fw.close();
            bw.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }

    }
}
