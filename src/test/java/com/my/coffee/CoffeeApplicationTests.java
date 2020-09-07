package com.my.coffee;

import com.my.coffee.component.RedisUtil;
import com.my.coffee.dao.UserDao;
import com.my.coffee.entity.User;
import com.my.coffee.mycontroller.MyController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoffeeApplication.class)
public class CoffeeApplicationTests {

	private MockMvc mvc;

	@Autowired
	private UserDao userDao;

	@Autowired
	private RedisUtil redisUtil;

	@Before
	public void before(){
		mvc = MockMvcBuilders.standaloneSetup(new MyController()).build();
	}

	@Test
	public void contextLoads() throws Exception {

		RequestBuilder requestBuilder = get("/my/myHello");
		mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string("heloo"));
	}

	@Test
	public void  testInsertSql(){
		User user= new User();
		user.setName("000789");
		User u = userDao.save(user);
		System.out.println(u.toString());

	}

	@Test
	public void  testQuerySql(){
		User user = userDao.findById(1);
		System.out.println(user.toString());
	}

	@Test
	public void  testRedisSet(){
		System.out.println(redisUtil.set("你好","你好的"));
	}


	@Test
	public void  testRedisGet(){
		System.out.println(redisUtil.get("你好"));
	}

	@Test
	public void  testRedisDel(){
		System.out.println(redisUtil.delete("你好"));
	}
}
