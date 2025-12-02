package org.example.jnote;

import org.example.jnote.Primary.PrimaryTextArea;

import java.lang.reflect.Type;
import java.util.HashMap;

public class DependencyResolver {
    private static HashMap<Class<?>, Object> map;

    public DependencyResolver(){
        map = new HashMap<>();
    }

    public  <T> T resolve(Class<T> abstractClass) {
        return abstractClass.cast(map.get(abstractClass));
    }

    public <T> void Add(Class<T> abstractClass, Object obj){
        map.put(abstractClass, obj);
    }
}
