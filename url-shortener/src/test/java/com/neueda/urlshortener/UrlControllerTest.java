package com.neueda.urlshortener;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.neueda.urlshortener.controller.UrlController;
import com.neueda.urlshortener.repository.UrlRepository;
import com.neueda.urlshortener.util.Encoder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UrlControllerTest {
	
	@Autowired
	private UrlController urlController;
	
	@Autowired
	private UrlRepository urlRepository;
	
	private String longUrl = "https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/test/annotation/DirtiesContext.html";
	
	@Test
	public void shortenedUrlIsShorterThanSix() {
		urlController = new UrlController();
//		AssertEquals(1, )

	}
	
	

}
