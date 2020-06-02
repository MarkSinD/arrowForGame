package com.gamecodeschool.arrowford;

import android.util.Log;

public class GameState {
    private static volatile boolean mThreadRunning = false;
    private static volatile boolean mPaused = true;

    GameState(){
        Log.e("Обьект GameState ", "создан");
    }
    void stopThread(){ mThreadRunning = false; }
    void startThread(){ mThreadRunning = true; }

    boolean getThreadRunning(){return mThreadRunning; }

    void stopEverything() {
        mPaused = true;
    }

}

