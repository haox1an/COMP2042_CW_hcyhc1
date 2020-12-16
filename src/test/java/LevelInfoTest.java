

import Controller.LevelInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelInfoTest {
    LevelInfo info;
    double objnum;
    double objspeed;

    /**
     * Test if the application dipslay the correct number of object number and speed
     */
    @Test
    void objNum() {
        info = new LevelInfo();
        objnum = info.ObjNum(5,3);
        objspeed = info.ObjSpeed(3,5);
        assertEquals(2, objnum);
        assertEquals(1.75,objspeed);
    }
}