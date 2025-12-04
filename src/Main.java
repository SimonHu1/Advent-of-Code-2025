import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static int password = 0;
    private static int currentpos = 50;
    public static void main(String[] args) {
        //Advent of Code Day 1
        //Read file
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
            String line;
            currentpos = 50;
            while ((line = br.readLine()) != null) {
                System.out.println(currentpos);
                System.out.println(line);
                calculateDial(line, currentpos);
            }
            System.out.println("Password: " + password);
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("error");
        }
    }

    public static void calculateDial(String input, int pos)
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
                System.out.println(pos +"," + newturn);
            }
        }
        else
        {
            pos -= newturn;
            if(pos < 0)
            {
                pos = 100+pos;
                System.out.println(pos +"," + newturn);
            }
        }
        if(pos==0) password++;
        currentpos=pos;
    }
}