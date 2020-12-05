package Controller;

public class FrogScore{
    int[] frogScore = new int[10];
    public FrogScore() {};

    public void setFrogScore(int level, int score){
        frogScore[level] = score;
    };

    public int getFrogScore(int level){
        return frogScore[level];
    }

}
