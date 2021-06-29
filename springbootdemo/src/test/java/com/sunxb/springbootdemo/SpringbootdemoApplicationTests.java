package com.sunxb.springbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringbootdemoApplicationTests {

	@Test
	void contextLoads() {
		//test 
	}

	@Test
	void listContains(){
		List<String> list = new ArrayList<>();
		list.add("qqq");
		System.out.println(list.contains("qqq"));
	}

	@Test
	void listTest(){
		String id = "131025199205214810";
		String id2 = id.substring(id.length()-1);
		System.out.println("id2 = " + id2);
	}

}
