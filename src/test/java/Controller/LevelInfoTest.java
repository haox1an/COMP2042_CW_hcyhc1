package Controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelInfoTest {
    LevelInfo info;
    double objnum;

    /**
     * Test if the application dipslay the correct number of object number
     */
    @Test
    void objNum() {
        info = new LevelInfo();
        objnum = info.ObjNum(1,0);
        assertEquals(1, objnum);
    }
}