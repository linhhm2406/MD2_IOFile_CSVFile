import java.io.*;

public class CSVTest {

    public void readCSV(String path) {
        File file = new File(path);
        String splitSymbol = '"' + ","+'"' ;

        if (!file.exists()) {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }
        }

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        String line = "";
        String[] splitArray;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                splitArray = line.split(splitSymbol);

                for (int i = 0; i < splitArray.length; i++) {
                    System.out.printf("%-20s",splitArray[i]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//            while (true) {
//                try {
//                    if ((line = bufferedReader.readLine()) == null) break;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                splitArray = line.split(splitSymbol);
//
//                for (int i = 0; i < splitArray.length; i++) {
//                    System.out.print(splitArray[i] + "\t");
//                }
//                System.out.println();
//            }
//}


    public static void main(String[] args) {
        CSVTest csvTest = new CSVTest();
        String path = "test.csv";

        csvTest.readCSV(path);
    }
}
