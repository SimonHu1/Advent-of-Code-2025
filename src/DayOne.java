import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayOne {
    private int password;
    private int currentpos;
    public DayOne() {
        System.out.println("Advent of Code Day One Solution");
    }
    public void solve(int part) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
            String line;
            currentpos = 50;
            password = 0;
            if(part == 1)
            {
                while ((line = br.readLine()) != null) {
                    calculateDial1(line, currentpos);
                }
                System.out.println("Password One: " + password);
            }
            if(part == 2)
            {
                while ((line = br.readLine()) != null) {
                    calculateDial2(line, currentpos);
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

    public void calculateDial1(String input, int pos)
    {
        boolean right = input.startsWith("R");
        int turn = Integer.parseInt(input.substring(1));
        int newturn = turn%100;
        if(right)
        {
            pos += newturn;
            if(pos > 99)
            {
                pos -= 100;
            }
        }
        else
        {
            pos -= newturn;
            if(pos < 0)
            {
                pos = 100+pos;
            }
        }
        if(pos==0) password++;
        currentpos=pos;
    }

    public void calculateDial2(String input, int pos)
    {
        boolean right = input.startsWith("R");
        int turn = Integer.parseInt(input.substring(1));
        if(turn/100 > 0) password+=turn/100;
        int newturn = turn%100;
        if(right)
        {
            pos += newturn;
            if(pos > 99)
            {
                pos -= 100;
                password++;
            }
            else if(pos == 0)
            {
                password++;
                if(newturn == 0)
                {
                    password--;
                }
            }
        }
        else
        {
            if(pos == 0)
            {
                password--;
            }
            pos -= newturn;
            if(pos < 0)
            {
                pos = 100+pos;
                password++;
            }
            else if(pos == 0)
            {
                password++;
            }
        }
        currentpos=pos;
    }
}
