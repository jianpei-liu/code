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
import org.springframework.core.io.Resource;
import org.yaml.snakeyaml.Yaml;

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
        T.ValidMap = T.getMap("valid.yml");
    }

    public static void main(String[] args) throws IOException {
        String filed = getMessage(E.issue.getMsg());

    }

    private static String getMessage(String field) {
        return T.ValidFieldMap.getOrDefault(field, field);
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

    @SuppressWarnings("unchecked")
    private static Map<String, List<String>> getMap(String key) {
        Resource resource = new ClassPathResource(key);
        Yaml yaml = new Yaml();
        Map<Object, Map> map = null;
        try {
            map = (Map)yaml.load(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, List<String>> listMap = new HashMap<>(128);

        if (null == map) {
            return listMap;
        }
        map.forEach((k, v) -> {
            Map<Object, String> v1 = v;
            if (null != v1) {
                v1.forEach((ka, va) -> {
                    if (null != va) {
                        listMap.put(ka.toString(), Arrays.asList(va.split(",")));
                    }
                });
            }

        });


        return listMap;
    }




}