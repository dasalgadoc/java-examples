package com.dsalgado.examples.apps.application;

import com.dsalgado.examples.apps.domain.Menu;

public class CreateMenuService {

    private final Menu menu;

    private CreateMenuService(Menu menu){
        this.menu = menu;
    }

    public Menu getMenu() {
        return this.menu;
    }
}
