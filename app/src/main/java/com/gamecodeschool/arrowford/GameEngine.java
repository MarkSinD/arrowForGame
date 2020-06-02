package com.gamecodeschool.arrowford;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class GameEngine extends SurfaceView implements Runnable{

    private ArrowSpec mArrowSpec;
    private Thread mThread = null;
    private GameState mGameState;
    Renderer mRenderer;

    int x;
    int y;
    int StartX;
    int StartY;
    int FinishX;
    int FinishY;

    public GameEngine(Context context, Point size) {
        super(context);
        Log.e("Обьект GameEngine ", "создан");
        mGameState = new GameState();
        mArrowSpec = new ArrowSpec(context, size);
        mRenderer = new Renderer(this, size, context, mArrowSpec);
    }

    @Override
    public void run() {
        while (mGameState.getThreadRunning()) {

            mArrowSpec.move();
            mRenderer.draw(mGameState);

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int i = event.getActionIndex();
        x = (int) event.getX(i);
        y = (int) event.getY(i);

        switch (event.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_UP:
                Log.e("Поднял. ", " " );
                FinishX = x;
                FinishY = y;
                mArrowSpec.spawn(new Point(FinishX, FinishY));
                break;

            case MotionEvent.ACTION_DOWN:
                Log.e("Опустил", " ");
                StartX = x;
                StartY = y;
                break;
        }

        Log.e("StartX = ", " " + StartX);
        Log.e("StartY = ", " " + StartY);
        Log.e("FinishX = ", " " + FinishX);
        Log.e("FinishY = ", " " + FinishY);
        return true;
    }

    public void stopThread() {

        mGameState.stopEverything();
        mGameState.stopThread();
        try {
            mThread.join();
        } catch (InterruptedException e) {
            Log.e("Exception ", "stopThread()" + e.getMessage());
        }
    }

    public void startThread() {
        mGameState.startThread();
        mThread = new Thread(this);
        mThread.start();
    }
}
