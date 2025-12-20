import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayTwo {
    private long password;
    public DayTwo() {
        System.out.println("Advent of Code Day Two Solution");
    }

    public void solve(int part) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/input2.txt"));
            String[] parts = br.readLine().split(",");
            password = 0;
            if(part == 1)
            {
                for (int i = 0; i < parts.length; i++) {
                    String[] ranges =  parts[i].split("-");
                    password += dupeCounter(Long.parseLong(ranges[0]),Long.parseLong(ranges[1]));
                }
                System.out.println("Password One: " + password);
            }
            if(part == 2)
            {
                for (int i = 0; i < parts.length; i++) {
                    String[] ranges =  parts[i].split("-");
                    System.out.println(ranges[0] + " - " + ranges[1]);
                    password += dupeCounter2(Long.parseLong(ranges[0]),Long.parseLong(ranges[1]));
                }
                System.out.println("Password Two: " + password);
            }
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("error");
        }
    }

    public long dupeCounter(long rangeOne, long rangeTwo)
    {
        long rangeTotal = 0;
        for(long i=rangeOne;i<= rangeTwo;i++)
        {
            String numAsString = Long.toString(i);
            if(numAsString.length()%2==0 && numAsString.substring(0,numAsString.length()/2).equals(numAsString.substring(numAsString.length()/2)))
            {
                rangeTotal+=i;
            }
        }
        return rangeTotal;
    }

    public long dupeCounter2(long rangeOne, long rangeTwo)
    {
        long rangeTotal = 0;
        for(long i=rangeOne;i<= rangeTwo;i++)
        {
            String numAsString = Long.toString(i);
            for(int j=numAsString.length()/2; j>0;j--)
            {
                if(numAsString.length()%j==0)
                {
                    //is a repeat if for k substrings of length j, they are all equal
                    int repeatCount = 0;
                    for(int k=0;k<numAsString.length()/j-1;k++)
                    {
                        if(numAsString.substring(j*k,j*(k+1)).equals(numAsString.substring(j*(k+1),j*(k+2))))
                        {
                            repeatCount++;
                        }
                    }
                    if(repeatCount==(numAsString.length()/j)-1) {
                        System.out.println(numAsString);
                        rangeTotal+=i;
                        j=0;
                    }
                }
            }
        }
        System.out.println("rangeTotal: "+rangeTotal);
        return rangeTotal;
    }
    //Incorrect previous solution
//    public long dupeCounter(long rangeOne, long rangeTwo)
//    {
//        //Assumes that rangeOne <= rangeTwo
//        long rangeTotal = 0;
//        for (long i = rangeOne; i <= rangeTwo; i++) {
//            int[] digitCounter = new int[10];
//            long placeholder = i;
//            while(placeholder > -1)
//            {
//                long digitValue = placeholder%10;
//                digitCounter[(int)digitValue]++;
//                placeholder = placeholder/10;
//                if(placeholder == 0) placeholder = -1;
//            }
//            for(int j = 0; j < 10; j++)
//            {
//                if (digitCounter[j] > 1)
//                {
//                    rangeTotal += i;
//                    j = 10;
//                }
//            }
//        }
//        System.out.println("Range Total: " + rangeTotal);
//        return rangeTotal;
//    }
}
