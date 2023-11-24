package com.example.culture_service;


import com.example.culture_service.domain.User;
import com.example.culture_service.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusUserLoginTest {

   @Autowired
   private UserMapper userMapper;

   @Test
    public void testSelectList(){
       List<User> List = userMapper.selectList(null);
       List.forEach(System.out::println);
//      User user = userMapper.selectById(1);
//      System.out.println(user);
   }

   @Test
   public void test2(){
      User user = new User();
      user.setName("张三");
      user.setPassword("123456");
      user.setUsername("小黄");
      int result = userMapper.insert(user);
      System.out.println("result:"+result);
   }

   @Test
   public void test3(){
//      int result = userMapper.deleteById(1727940283804454914L);
//      System.out.println("result:"+result);
      Map<String,Object> map = new HashMap<>();
      map.put("name","小黄");
      userMapper.deleteByMap(map);
   }



//   @Test
//   public void testLogin(String userName, String password){
//      User u = userMapper.login(userName,password);
//      if(u != null){
//         System.out.println("登录城东");
//      }else{
//         System.out.println("登录失败");
//      }
//   }


}
