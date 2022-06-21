package com.example.lostaktguide.app;

@SuppressWarnings("unused")
public class AppMediator {

    private static AppMediator INSTANCE;

    private GuideState mGuideState;


    private AppMediator() {

    }


    public static AppMediator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppMediator();
        }

        return INSTANCE;
    }

    // to reset the state when testing
    public static void resetInstance() {
        INSTANCE = null;
    }

    public GuideState getGuideState() {
        return mGuideState;
    }


    public NextToGuideState getNextGuideScreenState() {
        return null;
    }

    public void setNextGuideScreenState(GuideToNextState state) {

    }

    public void setPreviousGuideScreenState(GuideToPreviousState state) {

    }

    public PreviousToGuideState getPreviousGuideScreenState() {
        return null;
    }
}