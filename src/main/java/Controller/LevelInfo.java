package Controller;

public class LevelInfo {

    public LevelInfo(){};

    public double ObjNum(int lvl, int rowNum){
        double objNum[][] =
                {       //row1.........row9
                        //row0 -- row 4 = car;
                        {2,2,3,2,3,3,4,3,1,3},//level1
                        {2,2,3,2,3,3,4,3,1,3},//level2
                        {2,2,3,2,3,3,4,3,1,3},//level3
                        {2,2,3,2,3,3,4,3,1,3},//...
                        {2,2,3,2,3,3,4,3,1,3},//...
                        {2,2,3,2,3,3,4,3,1,3},//...
                        {2,2,3,2,3,3,4,3,1,3},//...
                        {2,2,3,2,3,3,4,3,1,3},//...
                        {2,2,3,2,3,3,4,3,1,3},
                        {2,2,3,2,3,3,4,3,1,3}//level10
                };

        return objNum[lvl - 1][rowNum];
    }

    public double ObjSpeed(int lvl, int rowNum){
        double objSpeed[][] =
                {
                        //speed
                        //Log       = 0.75
                        //LongLog   = -2
                        //Turtle    = -1
                        {1,-1,1,-1,2,-1,.75,-1,-2,.75},//level1
                        {1,-1,1,-1,2,-1,.75,-1,-2,.75},//level
                        {1,-1,1,-1,2,-1,.75,-1,-2,.75},//level
                        {1,-1,1,-1,2,-1,.75,-1,-2,.75},//level
                        {1,-1,1,-1,2,-1,.75,-1,-2,.75},//level
                        {1,-1,1,-1,2,-1,.75,-1,-2,.75},//level
                        {1,-1,1,-1,2,-1,.75,-1,-2,.75},
                        {1,-1,1,-1,2,-1,.75,-1,-2,.75},
                        {1,-1,1,-1,2,-1,.75,-1,-2,.75},//level
                        {1,-1,1,-1,2,-1,.75,-1,-2,.75},//level10



                };

        return objSpeed[lvl - 1][rowNum];


    }

    public double frogSpeed(int lvl, int rowNum){
        double frogSpeed[][] =
                {
                        //speed
                        //Log       = 0.75
                        //LongLog   = -2
                        //Turtle    = -1
                        {0.75, -2, -1},//lv1
                        {0.75, -2, -3},
                        {0.75, -2, -1},
                        {0.75, -2, -1},
                        {0.75, -2, -1},
                        {0.75, -2, -1},
                        {0.75, -2, -1},
                        {0.75, -2, -1},
                        {0.75, -2, -1},
                        {0.75, -2, -1},






                };

        return frogSpeed[lvl - 1][rowNum];


    }


}