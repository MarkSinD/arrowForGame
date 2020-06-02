package com.gamecodeschool.arrowford;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Renderer {
    private Canvas mCanvas;
    private ArrowSpec mArrowSpec;
    private SurfaceHolder mSurfaceHolder;
    private Paint mPaint;

    Renderer(SurfaceView sh, Point screenSize, Context context, ArrowSpec arrowSpec){
        Log.e("Обьект Renderer ", "создан");
        mSurfaceHolder = sh.getHolder();
        mPaint = new Paint();
        mArrowSpec = arrowSpec;
    }

    void draw( GameState gs){
        if( mSurfaceHolder.getSurface().isValid()){
            mCanvas = mSurfaceHolder.lockCanvas();

            mArrowSpec.draw(mCanvas,mPaint);

            mSurfaceHolder.unlockCanvasAndPost(mCanvas);
        }
    }
}
