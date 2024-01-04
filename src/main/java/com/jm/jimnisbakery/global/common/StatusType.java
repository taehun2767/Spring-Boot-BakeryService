package com.jm.jimnisbakery.global.common;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class StatusType {
    private static final Map<Integer, String> keyDictionary = new HashMap<>();
    public static int SUCCESS = 0;
    public static int FAIL = -1;
    public static int NOT_FOUND_USER = -2;
    public static int NOT_FOUND_BREAD = -3;

    public StatusType() {

    }

    static {
        initializeKeyDictionary();
    }

    private static void initializeKeyDictionary() {
        // StatusType 클래스의 모든 필드 순회
        Field[] fields = StatusType.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == int.class) {
                try {
                    int code = field.getInt(null); // 정적 필드의 값을 가져옴
                    String name = field.getName(); // 필드 이름을 가져옴
                    keyDictionary.put(code, name);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getStatusKey(int code) {
        return keyDictionary.get(code);
    }
}

