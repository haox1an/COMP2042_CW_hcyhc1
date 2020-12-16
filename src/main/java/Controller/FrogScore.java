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

/**
 * This class create file, write and read score from file, and display the score
 * @author Chung Hao Xian
 */
public class FrogScore{

    private final String FILE_PATH = "src/main/resources/File/score.txt";

    static List<Integer> scoreList;
    File scoreFile;
    Scanner reader;
    public FrogScore(){
    }

    /**
     * This method is use to create file
     * If file has created, open the file
     */
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

    /**
     * Add Score to the file
     * @param score player's score
     * @throws FileNotFoundException
     */
    public void addScore(int score) throws FileNotFoundException {

        scoreList = new ArrayList<>();
        reader = new Scanner(scoreFile);
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


    /**
     * Display the Score from the file
     * @return the score from the file
     */
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


}
