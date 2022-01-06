package com.lance.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/session")
public class SessionController {

    @PostMapping("/set")
    public void set(HttpSession session,
                    @RequestParam("key") String key,
                    @RequestParam("value") String value) {
        session.setAttribute(key, value);
    }

    @GetMapping("/get_all")
    public Map<String, Object> getAll(HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        for (Enumeration<String> enumeration = session.getAttributeNames();
             enumeration.hasMoreElements();) {
            String key = enumeration.nextElement();
            Object value = session.getAttribute(key);
            result.put(key, value);
        }
        return result;
    }

}
