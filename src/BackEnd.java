import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BackEnd
{
    public void readScores() throws IOException
    {
        String scoreList = "";
        int places = 1;
        BufferedReader in = new BufferedReader(new FileReader("scores.txt"));

        String line;
        while((in.readLine()) != null)
        {
            scoreList += places + ": " + in.readLine();
        }
        in.close();
    }
}
