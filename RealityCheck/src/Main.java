import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "C:.\\CollegeStats.csv";
        String line = "";
        boolean collegeFound = false;

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            System.out.println("What is your target college?");
            Scanner scan = new Scanner(System.in);

            String college = scan.nextLine();
            String[] values = line.split(",");
            while((line = br.readLine()) != null) {
                values = line.split(",");
                if (values[0].equals(college)) {
                   collegeFound = true;
                   break;
                }
            }
            if (!collegeFound) {
                System.out.println("College not found in database. Please retry.");
            } else {
                System.out.println("What is your math SAT score?");
                Integer math = scan.nextInt();
                System.out.println("What is your Reading SAT score?");
                Integer read = scan.nextInt();

                int q1 = Integer.parseInt(values[6]) + Integer.parseInt(values[8]);
                int q3 = Integer.parseInt(values[7]) + Integer.parseInt(values[9]);
                int q2 = (q1 + q3) / 2;
                int score = math + read;
                String chance = "";
                if (score < q1) {
                    chance = "very low";
                } else if (score > q1 && score < q2) {
                    chance = "low";
                } else if (score > q2 && score < q3) {
                    chance = "good";
                } else {
                    chance = "very good";
                }

                System.out.println("Your chances of admission based on SAT score is " + chance);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
