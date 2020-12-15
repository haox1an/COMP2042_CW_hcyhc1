package Controller;

/**
 * This method is to control the speed and number of sprite/obstacles according to the level
 */
public class LevelInfo {

    public LevelInfo(){};

    /**
     * This method control the number of the sprite
     * @param lvl current level of the game
     * @param rowNum Type of the sprite
     * @return the number of the sprite
     */
    public double ObjNum(int lvl, int rowNum){
        double objNum[][] =
                {       //row1.........row9
                        //row0 -- row 4 = car;
                        //row5 -- row 6 = log & turtle
                        {1,2,1,2,1,3,4,3,2,3},//level1
                        {1,2,1,2,1,3,4,3,2,3},//level2
                        {2,3,2,2,2,3,4,3,2,3},//level3
                        {2,3,2,2,2,3,3,3,2,3},//...
                        {3,4,3,2,3,3,3,2,1,2},//...
                        {3,4,3,2,3,2,3,2,1,2},//...
                        {4,5,4,2,4,2,2,2,1,2},//...
                        {4,5,4,3,4,2,2,2,1,2},//...
                        {5,5,5,3,5,1,1,1,1,1},
                        {5,5,5,3,5,1,1,1,1,1}//level10
                };

        return objNum[lvl - 1][rowNum];
    }

    /**
     * This method control the speed of the sprite according to the level
     * @param lvl current level of the game
     * @param rowNum type of the sprite
     * @return the speed of the sprite
     */
    public double ObjSpeed(int lvl, int rowNum){
        double objSpeed[][] = {
                {1, -1, 1, -1, 2, .75, .75, -1., -2, .75},
                {1.5, -1.5, 1.5, -1.5, 2.5, 1.25, 1.25, -1.5, -2, 1.25},
                {2, -2, 2, -2, 3, 1.75, 1.75, -2, -2.5, 1.75},
                {2.5, -2.5, 2.5, -2.5, 3.5, 2.25, 2.25, -2.5, -3, 2.25},
                {3, -3, 3, -3, 4, 2.75, 2.75, -3, -3.5, 2.75},
                {3.5, -3.5, 3.5, -3.5, 4.5, 3.25, 3.25, -3.5, -4, 3.25},
                {4, -4, 4, -4, 5, 3.75, 3.75, -4, -4.5, 3.75},
                {4.5, -4.5, 4.5, -4.5, 5.5, 4.25, 4.25, -4.5, -5, 4.25},
                {5, -5, 5, -5, 6, 4.75, 4.75, -5, -5.5, 4.75},
                {5.5, -5.5, 5.5, -5.5, 6.5, 5.25, 5.25, -5.5, -6, 5.25},
        };

                    return objSpeed[lvl - 1][rowNum];
    }



}