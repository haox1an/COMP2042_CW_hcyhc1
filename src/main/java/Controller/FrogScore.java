package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FrogScore{

    private final String FILE_PATH = "src/main/resources/File/score.txt";

    static List<Integer> scoreList;
    File scoreFile;

    public FrogScore(){

    }

    public void createFile(){

        try{
            scoreFile = new File(FILE_PATH);
            if(!scoreFile.exists()){
                scoreFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.print("File not created");
            e.printStackTrace();
        }
    }

    public void addScore(int score) throws FileNotFoundException {

        scoreList = new ArrayList<>();
        Scanner reader = new Scanner(scoreFile);
        PrintWriter writer;
        scoreList.add(score);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            scoreList.add(Integer.parseInt(data));
        }
        scoreList.sort(Collections.reverseOrder());
        scoreList = scoreList.stream().limit(5).collect(Collectors.toList());
        writer = new PrintWriter(scoreFile);

        scoreList.forEach(highscore -> {
            writer.println(highscore.toString());
        });
        writer.close();
    }



        public static String displayScore(){
            StringBuilder sb = new StringBuilder();
            for (Integer s : scoreList)
            {
                sb.append("\n");
                sb.append(s);
                sb.append("\n");
            }
            return sb.toString();
        }

        public boolean isHigher(int score){
            for (int i = 0; i < scoreList.size(); i++) {
                if (score >= scoreList.get(i) )
                    return true;
            }
               return false;
        }

        public List <Integer> getList(){
            return scoreList;
        }
}
