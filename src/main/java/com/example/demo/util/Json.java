package com.example.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *  Мною разработанный класс для быстрой генерации JSON-ответа сложных оптимизированных запросов.
 *  В этом приложении можно было его не использовать (Только для демонстрации).
 * @author pasha chuvak
 *
 */
public class Json {

	/**
	 * Метод генерации JSON-ответа из объекта.
	 * @param object любой объект POJO
	 * @return строка JSON
	 */
    public static String getJson(Object object) {
    	String json = null;
    	try {
    		json = new ObjectMapper().writeValueAsString(object);
    	} catch (JsonProcessingException e) {
    		e.printStackTrace();
    	}
        return json;
    }

    /**
     * Метод получения карты из списка объектов и их имён
     * @param objects объекты из запроса
     * @param names имена объектов внутри списка
     * @return карта
     */
    public static HashMap<String, Object> getHashMap(List<Object> objects, List<String> names) {
        HashMap<String, Object> map = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            map.put(names.get(i), objects.get(i));
        }
        return map;
    }

    /**
     * Получение списка карт из нативных запросов к базе
     * @param objects список объектов
     * @param names имена из списка объектов
     * @return список карт
     */
    public static List<HashMap<String, Object>> getArrayHashMap(List<List<Object>> objects, List<String> names) {
        List<HashMap<String, Object>> array = new ArrayList<>();
        for (int i = 0; i < objects.size(); i++) {
            array.add(getHashMap(objects.get(i), names));
        }
        return array;
    }
}
