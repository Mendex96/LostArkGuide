package com.example.lostaktguide.app;
import java.util.Objects;

public class InitToTypeState {
    public boolean initState;

    public InitToTypeState(boolean initState){this.initState = initState;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InitToTypeState that = (InitToTypeState) obj;
        return initState == that.initState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(initState);
    }
}
