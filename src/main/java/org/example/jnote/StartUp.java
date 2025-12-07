package org.example.jnote;

import org.example.jnote.Builders.ButtonBuilder;
import org.example.jnote.Managers.ButtonManager;

public class StartUp {
    void build(){
        DependencyResolver di = new DependencyResolver();
        di.Add(ButtonManager.class, new ButtonManager());
        AccessLayer.DI = di;
    }
}
