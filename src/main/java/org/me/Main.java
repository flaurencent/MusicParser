package org.me;

import org.me.music.io.ImportManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ImportManager.getInstance().displayDialog();
    }
}