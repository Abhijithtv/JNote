package org.example.jnote.Managers;

import org.example.jnote.Builders.ButtonBuilder;
import org.example.jnote.Common.IJNoteButton;
import org.example.jnote.Enums.IJNButtonEnum;

import java.security.PublicKey;
import java.util.HashMap;

public class ButtonManager {
    private HashMap<String, IJNoteButton> _cache;

    public ButtonManager(){
        _cache = new HashMap<>();
    }

    public IJNoteButton getInstance(String name, IJNButtonEnum type){
        String key = buildKey(name, type);
        _cache.computeIfAbsent(key, _ -> {
            try {
                return ButtonBuilder.GetInstance(type, name);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return _cache.get(key);
    }

    private String buildKey(String name, IJNButtonEnum type){
        return name + "###" + type.toString();
    }
}
