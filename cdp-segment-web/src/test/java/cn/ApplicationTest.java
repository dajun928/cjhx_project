package cn;


import cn.dao.BookDao;
import com.alibaba.fastjson.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
class ApplicationTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoad() {
        System.out.println("---------------");
        bookDao.save();
    }


    @Test
    void contextLoad2() {
        System.out.println("---------------");


        try {
            // 读取 JSON 文件内容为字符串
            String jsonStringList = new String(Files.readAllBytes(Paths.get("E:\\workspace\\develop\\javaCodes\\cdp\\cdp-segment-web\\src\\main\\resources\\example.json")));
//            System.out.println(jsonStringList);
            String[] arr = jsonStringList.split("|");
            List<String> list = Arrays.asList(arr);
            for (String s : list) {
                System.out.println(s);
                System.out.println("---------------");

                // 将 JSON 字符串解析为 JSONObject 对象
//                JSONObject jsonObject = JSON.parseObject(s);
//
//                // 从 JSONObject 中获取数据
//                String name = jsonObject.getString("name");
//                int age = jsonObject.getInteger("age");
//
//                // 打印数据
//                System.out.println("Name: " + name);
//                System.out.println("Age: " + age);
            }
//            System.out.println(list);
//            System.out.println(jsonString);
//            // 将 JSON 字符串解析为 JSONObject 对象
//            JSONObject jsonObject = JSON.parseObject(jsonString);
//
//            // 从 JSONObject 中获取数据
//            String name = jsonObject.getString("name");
//            int age = jsonObject.getInteger("age");
//
//            // 打印数据
//            System.out.println("Name: " + name);
//            System.out.println("Age: " + age);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @Test
    void contextLoad3() {
        System.out.println("---------------");
        String filePath="E:\\workspace\\develop\\javaCodes\\cdp\\cdp-segment-web\\src\\main\\resources\\example.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                // 解析每一行的 JSON 对象
                JSONObject jsonObject = JSON.parseObject(line);

                // 从 JSON 对象中获取数据
                String name = jsonObject.getString("name");
                int age = jsonObject.getInteger("age");

                // 打印数据
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    void contextLoad4() {
        System.out.println("---------------");
        String filePath="E:\\workspace\\develop\\javaCodes\\cjhx_project\\cdp-segment-web\\src\\main\\resources\\example.json";
        try {
            String content=new String(Files.readAllBytes(Paths.get(filePath)));
            List<JSONObject> res = new ArrayList<>();
            JSONArray json = JSONArray.parseArray(content);
            for(int i = 0; i < json.size(); i++) {
                res.add(json.getJSONObject(i));
            }
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
