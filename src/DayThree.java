import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DayThree {
    private int password;
    public DayThree() {
        System.out.println("Advent of Code Day Three Solution");
    }

    public void solve(int part) {
        if(part == 1) {

        }
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/input3.txt"));
            String line;
            password = 0;
            while ((line = br.readLine()) != null) {
                calculateBank(line);
            }
            System.out.println("Password One: "+password);
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
        //System.out.println("first dig index" + firstDigitIndex);
        //System.out.println("second part string" + partString.substring(partString.length()-1));
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
        if(secondDigit>firstDigit) System.out.println("BIG SDHAUDASIUD");
        int maxJoltage = (firstDigit*10) + secondDigit;
        System.out.println(maxJoltage);
        password += maxJoltage;

    }
}
