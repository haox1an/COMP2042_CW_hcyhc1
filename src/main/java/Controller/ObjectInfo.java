package Controller;

public class ObjectInfo {

    public ObjectInfo(){};

    public int ObjNum(int lvl, int rowNum){
        int objNum[][] =
                {       //row1.........row9
                        {1,2,3,4,5,6,7,8,9},//level1
                        {2,2,3,4,5,6,7,8,9},//level2
                        {5,2,3,4,5,6,7,8,9},//level3
                        {1,2,3,4,5,6,7,8,9},//...
                        {1,2,3,4,5,6,7,8,9},//...
                        {1,2,3,4,5,6,7,8,9},//...
                        {1,2,3,4,5,6,7,8,9},//...
                        {1,2,3,4,5,6,7,8,9},//...
                        {1,2,3,4,5,6,7,8,9}//level9
                };

        return objNum[lvl][rowNum];
    }

    public int ObjSpeed(int lvl, int rowNum){
        int objSpeed[][] =
                {
                        {1,2,3,4,5,6,7,8,9},//level1
                        {1,2,3,4,5,6,7,8,9},//level2
                        {5,2,3,4,5,6,7,8,9},//level3
                        {1,2,3,4,5,6,7,8,9},//...
                        {1,2,3,4,5,6,7,8,9},//...
                        {1,2,3,4,5,6,7,8,9},//...
                        {1,2,3,4,5,6,7,8,9},//...
                        {1,2,3,4,5,6,7,8,9},//...
                        {1,2,3,4,5,6,7,8,9}//level9
                };

        return objSpeed[lvl][rowNum];


    }


}