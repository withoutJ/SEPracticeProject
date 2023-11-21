package test;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import sportfacility.*;

public class TestReview {

    @Test
    public void testReview_01() {
        String expectedComment = "Great facility!";
        int expectedRate = 5;

        Review review = new Review(expectedComment, expectedRate);

        assertEquals( "Great facility!",review.getComment());
    }


@Test
public void testReview_02() {
    String expectedComment = "Great facility!";
    int expectedRate = 4;

    Review review = new Review(expectedComment, expectedRate);

    assertEquals( 4,review.getRate());
	}
}

