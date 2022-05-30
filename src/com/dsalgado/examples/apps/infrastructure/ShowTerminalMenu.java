package com.dsalgado.examples.apps.infrastructure;

import com.dsalgado.examples.apps.domain.Menuable;

public class ShowTerminalMenu implements Menuable {

    @Override
    public void showMenu() {
        System.out.println("Hola");
    }

    @Override
    public void createMenu() {

    }
}
