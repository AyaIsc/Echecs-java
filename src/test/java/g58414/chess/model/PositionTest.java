/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58414.chess.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g58414
 */
public class PositionTest {

    @Test
    public void testSomeMethod() {
        System.out.println("Test  next NW row");

        //Direction dir = Direction.NW;
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.NW);

        int expResult = 5;
        int resultRow = position2.getRow();
        assertEquals(expResult, resultRow);
    }

    public void test2() {
        System.out.println("test next N row");

        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.N);

        int expResult = 5;
        int resultRow = position2.getRow();
        assertEquals(expResult, resultRow);
    }

    public void test3() {
        System.out.println("test next NE row");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.NE);

        int expResult = 5;
        int resultRow = position2.getRow();
        assertEquals(expResult, resultRow);
    }

    public void test4() {
        System.out.println("test next W row");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.W);

        int expResult = 4;
        int resultRow = position2.getRow();
        assertEquals(expResult, resultRow);
    }

    public void test5() {
        System.out.println("test next E row");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.E);

        int expResult = 4;
        int resultRow = position2.getRow();
        assertEquals(expResult, resultRow);
    }

    public void test6() {
        System.out.println("test next SW row");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.SW);

        int expResult = 3;
        int resultRow = position2.getRow();
        assertEquals(expResult, resultRow);
    }

    public void test7() {
        System.out.println("test next S row");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.S);

        int expResult = 3;
        int resultRow = position2.getRow();
        assertEquals(expResult, resultRow);
    }

    public void test8() {
        System.out.println("test next SE row ");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.SE);

        int expResult = 3;
        int resultRow = position2.getRow();
        assertEquals(expResult, resultRow);
    }

    public void test9() {
        System.out.println("Test  next NW column");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.NW);

        int expResult = 3;
        int resultColumn = position2.getColumn();
        assertEquals(expResult, resultColumn);
    }

    public void test10() {
        System.out.println("test next N column");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.N);

        int expResult = 4;
        int resultColumn = position2.getColumn();
        assertEquals(expResult, resultColumn);
    }

    public void test11() {
        System.out.println("test next NE column");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.NE);

        int expResult = 5;
        int resultColumn = position2.getColumn();
        assertEquals(expResult, resultColumn);
    }

    public void test12() {
        System.out.println("test next W column");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.W);

        int expResult = 3;
        int resultColumn = position2.getColumn();
        assertEquals(expResult, resultColumn);
    }

    public void test13() {
        System.out.println("test next E column");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.E);

        int expResult = 5;
        int resultColumn = position2.getColumn();
        assertEquals(expResult, resultColumn);
    }

    public void test14() {
        System.out.println("test next SW column");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.SW);

        int expResult = 3;
        int resultColumn = position2.getColumn();
        assertEquals(expResult, resultColumn);
    }

    public void test15() {
        System.out.println("test next S column");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.S);

        int expResult = 4;
        int resultColumn = position2.getColumn();
        assertEquals(expResult, resultColumn);
    }

    public void test16() {
        System.out.println("test next SE column ");
        Position position1 = new Position(4, 4);
        Position position2 = position1.next(Direction.SE);

        int expResult = 5;
        int resultColumn = position2.getColumn();
        assertEquals(expResult, resultColumn);
    }
}
