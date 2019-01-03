import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BackEnd
{
    public void readScores(String name) throws IOException
    {
        String scoreList = "";
        int places = 1;
        BufferedReader in = new BufferedReader(new FileReader(name));

        String line;
        while((line = in.readLine()) != null)
        {
            scoreList += places + ": " +
        }
        in.close();
    }
}
