package com.neueda.urlshortener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.neueda.urlshortener.util.Encoder;

@SpringBootTest
public class EncoderTest {
	private Encoder encoder;
	private String longUrl = "https://www.google.ie/search?q=how+to+tie+a+knot"
			+ "&sxsrf=ALeKk012yknipnFcXa57fNTZ26pHXHb_1Q:1593443995376&source=lnms"
			+ "&tbm=isch&sa=X&ved=2ahUKEwjwgMG6qafqAhVFr3EKHa0AA4EQ_AUoAXoECA4QAw&biw=1745&bih=881&dpr=1.1";
	private int id = 0;

	@Test
	public void testShortenedUrlIsLongerThanTwo() {
		encoder = new Encoder();
		assertTrue(encoder.encode(longUrl, ++id).length() > 2);
	}
	
	@Test
	public void testhortenedUrlIsShorterThanSix() {
		encoder = new Encoder();
		assertTrue(encoder.encode(longUrl, ++id).length() <= 6);
	}
	
	@Test
	public void overOneMillionEntries() {
		encoder = new Encoder();
		assertTrue(encoder.encode(longUrl, 1000000).length() <= 6);
	}
	
	@Test
	public void testLowerBoundary() {
		encoder = new Encoder();
		assertEquals("aab", encoder.encode(longUrl, 1));	
	}
	
	@Test
	public void testUpperBoundary() {
		encoder = new Encoder();
		assertEquals("aaMuvc", encoder.encode(longUrl, Integer.MAX_VALUE/3844));	
	}
	
	@Test
	public void lowerBoundaryUrlLongerThanTwo() {
		encoder = new Encoder();
		assertTrue(encoder.encode(longUrl, 1).length() > 2);	
	}
	
	@Test
	public void upperBoundaryUrlShorterThanSix() {
		encoder = new Encoder();
		assertTrue(encoder.encode(longUrl, Integer.MAX_VALUE/3844).length() <= 6);	
	}
	
	@Test
	public void testNegativeNumber() {
		encoder = new Encoder();
		assertEquals("", encoder.encode(longUrl, -1));
	}
}
