/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: T
 * Author:   root
 * Date:     2018/7/12 22:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.example.demo;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author root
 * @create 2018/7/12
 * @since 1.0.0
 */
public class T {

    private static Map<String, String> ValidFieldMap;
    private static Map<String, List<String>> ValidMap;


    static
    {
        T.ValidFieldMap = T.get("fileds-map.properties");
        T.ValidMap = T.getValidFieldList("valid.properties");
    }

    public static void main(String[] args) throws IOException {
        String filed = getMessage(E.issue.getMsg());

    }

    private static String getMessage(String field) {
        return T.ValidFieldMap.getOrDefault(field, field);
    }

    private static Map<String,List<String>> getValidFieldList(String key) {
        Map<String, String> valid = get(key);
        Map<String, List<String>> map = new HashMap<>();

        valid.forEach((k,v) -> {
            map.put(k,Arrays.asList(v.split(",")));
        });
        return map;
    }

    @SuppressWarnings("unchecked")
    private static Map<String,String> get(String propertiesFile){
        ClassPathResource classPathResource = new ClassPathResource(propertiesFile);
        Properties properties = new Properties();
        try
        {
            properties.load(classPathResource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>((Map) properties);
    }




}