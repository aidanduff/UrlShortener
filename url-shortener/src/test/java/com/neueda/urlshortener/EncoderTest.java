package com.neueda.urlshortener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.neueda.urlshortener.util.Encoder;

@SpringBootTest
public class EncoderTest {
	private Encoder encoder;
	private String longUrl = "https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue";
	private int id = 0;

	@Test
	public void shortenedUrlIsLongerThanTwo() {
		encoder = new Encoder();
		assertTrue(encoder.encode(longUrl, ++id).length() > 2);
	}
	
	@Test
	public void shortenedUrlIsShorterThanSix() {
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
	public void upperBoundaryUrlShorterThanSic() {
		encoder = new Encoder();
		assertTrue(encoder.encode(longUrl, Integer.MAX_VALUE/3844).length() <= 6);	
	}
}
