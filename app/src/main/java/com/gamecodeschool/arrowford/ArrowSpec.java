package com.gamecodeschool.arrowford;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;

public class ArrowSpec {

    private Bitmap mBitmap;
    private static final String bitmapName = "arrow";
    private Point mLocation;
    private float mSpeed;
    private int mObjectHeight;
    private int mObjectWidth;

    ArrowSpec(Context c, Point screenSize){
        mObjectHeight = screenSize.y / 5;
        mObjectWidth = screenSize.x / 5;
        mSpeed = 4;
        mLocation = new Point();

        int resID = c.getResources().getIdentifier(bitmapName, "drawable", c.getPackageName());
        mBitmap = BitmapFactory.decodeResource(c.getResources(), resID);
        mBitmap = Bitmap.createScaledBitmap(mBitmap, mObjectWidth, mObjectHeight, false);
        Log.e("Обьект ArrowSpec ", "создан");
    }

    public void spawn(Point startPoint){
        mLocation.x = startPoint.x;
        mLocation.y = startPoint.y;
    }

    public void draw(Canvas canvas, Paint paint){
        canvas.drawColor(Color.argb(255, 222,16,16));
        canvas.drawBitmap(mBitmap, mLocation.x, mLocation.y, paint);
    }

    public void move(){
        mLocation.x += mSpeed;
    }
}
