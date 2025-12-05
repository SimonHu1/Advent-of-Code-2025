import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayTwo {
    private long password;
    public DayTwo() {
        System.out.println("Advent of Code Day Two Solution");
    }

    public void solve() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/input2.txt"));
            String[] parts = br.readLine().split(",");
            password = 0;
            for (int i = 0; i < parts.length; i++) {
                System.out.println(parts[i]);
                String[] ranges =  parts[i].split("-");
                password += dupeCounter(Long.parseLong(ranges[0]),Long.parseLong(ranges[1]));
            }
            System.out.println("Password One: " + password);
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("error");
        }
    }

    public long dupeCounter(long rangeOne, long rangeTwo)
    {
        //Assumes that rangeOne <= rangeTwo
        long rangeTotal = 0;
        for (long i = rangeOne; i <= rangeTwo; i++) {
            int[] digitCounter = new int[10];
            long placeholder = i;
            while(placeholder > -1)
            {
                long digitValue = placeholder%10;
                digitCounter[(int)digitValue]++;
                placeholder = placeholder/10;
                if(placeholder == 0) placeholder = -1;
            }
            for(int j = 0; j < 10; j++)
            {
                if (digitCounter[j] > 1)
                {
                    rangeTotal += i;
                    j = 10;
                }
            }
        }
        System.out.println("Range Total: " + rangeTotal);
        return rangeTotal;
    }
}
