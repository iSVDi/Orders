package com.example.exception;

import java.util.HashMap;
import java.util.Map;

public enum ShopExceptionType {
    USER_NOT_EXISTS;

     public Map<String, String> getMap() {
         Map<String, String> res = new HashMap<>();
         switch (this) {
            case USER_NOT_EXISTS -> {
                res.put("id", "user with such id doesn't exist");
            }
        };
        return res;
    }

}
