package com.example.lostaktguide.app;

import com.example.lostaktguide.data.ClassItem;

@SuppressWarnings("unused")
public class GuideMediator {

    private static GuideMediator INSTANCE;

    private ClassItem Class;


    private GuideMediator() {

    }


    public static GuideMediator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GuideMediator();
        }

        return INSTANCE;
    }

    // to reset the state when testing
    public static void resetInstance() {
        INSTANCE = null;
    }


}