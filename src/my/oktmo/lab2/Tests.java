package my.oktmo.lab2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {
    private OktmoData data, data2;

    @Before
    public void setUp() throws Exception {
        String filename = "data-201710.csv",
                encoding = "cp1251";
        data = new OktmoData();
        data2 = new OktmoData();

        OktmoReader testReader = new OktmoReader();
        testReader.readPlaces(filename, encoding, data);
        testReader.regExpReader(filename, encoding, data2);
    }

    @Test
    public void readPlaces() {
        assertEquals("Code= ", 1601413116L, data.getPlaceByIndex(10).getCode());
        assertEquals("Status= ", "п", data.getPlaceByIndex(10).getStatus());
        assertEquals("Name= ", "Успеновка", data.getPlaceByIndex(10).getName());
        assertEquals("Count of NP= ", 10, data.getCountOfNP(10));

        assertEquals("Code= ", 99701000001L, data.getPlaceByIndex(-1).getCode());
        assertEquals("Status= ", "г", data.getPlaceByIndex(-1).getStatus());
        assertEquals("Name= ", "Биробиджан", data.getPlaceByIndex(-1).getName());
        assertEquals("Count of NP= ", 155873, data.getCountOfNP(-1));

    }

    @Test
    public void equalsTest() {
        assertEquals(data.getPlaceByIndex(1), data2.getPlaceByIndex(1));
        assertEquals(data, data2);
    }
}