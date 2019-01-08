import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BackEnd
{
    public static ArrayList<String> readScore()
    {
        Path path = Paths.get("src/scores.txt");
        ArrayList<String> scores = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(path))
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
        try(FileWriter fw = new FileWriter("scores.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(points);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}