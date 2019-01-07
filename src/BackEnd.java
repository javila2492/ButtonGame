import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BackEnd
{
    public static ArrayList<String> readScore()
    {
        Path path = Paths.get("score.csv");
        ArrayList<String> scores = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path,
                StandardCharsets.US_ASCII))
        {
            String line = br.readLine();
            while (line != null)
            {
                scores.add(line);
                line = br.readLine();
            }

        } catch (IOException ioe)
        {
            ioe.printStackTrace();
        }


        return scores;
    }
    public static void updateScore(int points)
    {
        ArrayList<String> scores = readScore();
        for(int i = 0; i<scores.size();  i++)
        {
            if(points > Integer.parseInt(scores.get(i)))
            {
                try
                {
                    scores.add(i,""+points);
                    BufferedWriter out = new BufferedWriter(new FileWriter("src/sample/score.txt", false));
                    for(int j = 0;j < scores.size() - 1; j++)
                    {
                        out.write(scores.get(j) + "\n");
                    }
                    out.close();
                }
                catch (IOException e)
                {
                    System.out.println("exception occurred" + e);
                }
                break;
            }
        }
    }
}