import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DayThree {
    private Long password;
    public DayThree() {
        System.out.println("Advent of Code Day Three Solution");
    }

    public void solve(int part) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/input3.txt"));
            String line;
            password = 0L;
            while ((line = br.readLine()) != null) {
                if(part==1)
                {
                    calculateBank(line);
                }
                if(part==2)
                {
                    calculateBank2(line);
                }
            }
            if(part==1) System.out.println("Password One: "+password);
            if(part==2) System.out.println("Password Two: "+password);

        }
        catch(IOException e)
        {
            System.out.println("error");
        }
    }

    public void calculateBank(String line)
    {
        String digitCheck = "9";
        int firstDigitIndex = 0;
        int firstDigit = 0;
        int secondDigit = 0;
        String partString = line.substring(0,line.length()-1);
        while(firstDigit==0)
        {
            for(int i=0;i<partString.length();i++)
            {
                if((partString.charAt(i)+"").equals(digitCheck))
                {
                    firstDigit = Integer.parseInt(digitCheck);
                    firstDigitIndex=i;
                    i =  partString.length() + 1;
                }
            }
            digitCheck = ""+(Integer.parseInt(digitCheck) - 1);
        }
        partString = line.substring(firstDigitIndex+1);
        digitCheck = "9";
        while(secondDigit==0)
        {
            for(int i=0;i<partString.length();i++)
            {
                if((partString.charAt(i)+"").equals(digitCheck))
                {
                    secondDigit = Integer.parseInt(digitCheck);
                }
            }
            digitCheck = ""+(Integer.parseInt(digitCheck) - 1);
        }
        int maxJoltage = (firstDigit*10) + secondDigit;
        password += maxJoltage;

    }

    public void calculateBank2(String line)
    {
        int[] digitArray = new int[12];
        String digitCheck = "9";
        Long maxJoltage = 0L;
        int digitIndex = -1;
        String partString;
        //loops 12 times (once for each digit)
        for(int i=0;i<12;i++)
        {
            digitCheck = "9";
            partString = line.substring(digitIndex+1,line.length()-11+i);
            while(digitArray[i]==0)
            {
                for(int j=0;j<partString.length();j++)
                {
                    if((partString.charAt(j)+"").equals(digitCheck))
                    {
                        digitArray[i] = Integer.parseInt(partString.charAt(j)+"");
                        maxJoltage += (long) (Math.pow(10.0,11.0-i)*digitArray[i]);
                        digitIndex+=j+1;
                        j =  partString.length() + 1;
                    }
                }
                digitCheck = ""+(Integer.parseInt(digitCheck) - 1);
            }

        }
        password += maxJoltage;
    }
}
