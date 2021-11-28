package net.codetojoy.haiku.consumer;

import static org.junit.Assert.*;
import org.junit.*;

import net.codetojoy.haiku.common.*;

public class ResultTrackerTest {
    private ResultTracker resultTracker = new ResultTracker();

    @Test
    public void testIsMatch_red_empty() {
        // test
        var result = resultTracker.isMatch();

        assertFalse(result);
    }

    @Test
    public void testIsMatch_red_under() {
        resultTracker.consume(new Entry("" + 10,10));

        // test
        var result = resultTracker.isMatch();

        assertFalse(result);
    }

    @Test
    public void testIsMatch_red_over() {
        resultTracker.consume(new Entry("" + 18,Constants.TARGET_NUM_SYLLABLES+1));

        // test
        var result = resultTracker.isMatch();

        assertFalse(result);
    }

    @Test
    public void testIsMatch_green_one_entry() {
        resultTracker.consume(new Entry("" + 5150,Constants.TARGET_NUM_SYLLABLES));

        // test
        var result = resultTracker.isMatch();

        assertTrue(result);
    }

    @Test
    public void testIsMatch_green_N_entries() {
        resultTracker.consume(new Entry("" + 5150,5));
        resultTracker.consume(new Entry("" + 5151,7));
        resultTracker.consume(new Entry("" + 5152,5));

        // test
        var result = resultTracker.isMatch();

        assertTrue(result);
    }

    @Test
    public void testGetEntries_match_one() {
        resultTracker.consume(new Entry("" + 5150,Constants.TARGET_NUM_SYLLABLES));

        // test
        var result = resultTracker.getEntries();

        assertEquals(1, result.size());
        assertEquals(5150, result.get(0).id());
    }

    @Test
    public void testGetEntries_match_N() {
        resultTracker.consume(new Entry("" + 5150,5));
        resultTracker.consume(new Entry("" + 5151,7));
        resultTracker.consume(new Entry("" + 5152,5));

        // test
        var result = resultTracker.getEntries();

        assertEquals(3, result.size());
        assertEquals(5150, result.get(0).id());
        assertEquals(5151, result.get(1).id());
        assertEquals(5152, result.get(2).id());
    }

    @Test
    public void testGetEntries_under() {
        resultTracker.consume(new Entry("" + 5150,10));

        // test
        var result = resultTracker.getEntries();

        assertEquals(1, result.size());
        assertEquals(5150, result.get(0).id());
    }

    @Test
    public void testGetEntries_over_1() {
        resultTracker.consume(new Entry("" + 5150,10));
        resultTracker.consume(new Entry("" + 5151,16));

        // test
        var result = resultTracker.getEntries();

        assertEquals(1, result.size());
        assertEquals(5151, result.get(0).id());
    }

    @Test
    public void testGetEntries_over_2() {
        resultTracker.consume(new Entry("" + 5150,10));
        resultTracker.consume(new Entry("" + 5151,20));

        // test
        var result = resultTracker.getEntries();

        assertEquals(0, result.size());
    }

    @Test
    public void testGetEntries_match() {
        resultTracker.consume(new Entry("" + 5150,10));
        resultTracker.consume(new Entry("" + 5151,3));
        resultTracker.consume(new Entry("" + 5152,4));

        // test
        var result = resultTracker.getEntries();

        assertEquals(3, result.size());
        assertEquals(5150, result.get(0).id());
        assertEquals(5151, result.get(1).id());
        assertEquals(5152, result.get(2).id());
    }

    @Test
    public void testGetEntries_mega() {
        resultTracker.consume(new Entry("" + 5140,30));
        resultTracker.consume(new Entry("" + 5141,20));
        resultTracker.consume(new Entry("" + 5142,10));
        resultTracker.consume(new Entry("" + 5143,10));
        resultTracker.consume(new Entry("" + 5144,10));
        resultTracker.consume(new Entry("" + 5145,1));
        resultTracker.consume(new Entry("" + 5146,2));
        resultTracker.consume(new Entry("" + 5147,3));
        resultTracker.consume(new Entry("" + 5148,15));
        resultTracker.consume(new Entry("" + 5150,10));
        resultTracker.consume(new Entry("" + 5151,3));
        resultTracker.consume(new Entry("" + 5152,4));

        // test
        var result = resultTracker.getEntries();

        assertEquals(3, result.size());
        assertEquals(5150, result.get(0).id());
        assertEquals(5151, result.get(1).id());
        assertEquals(5152, result.get(2).id());
    }
}
