package com.gmail.yudhapratama539.belajarlayout.Pertemuan8;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import com.gmail.yudhapratama539.belajarlayout.R;

public class Pertemuan8Activity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertemuan8);

        textView = findViewById(R.id.tv_show);

        mDetector = new GestureDetectorCompat(this,this);

        mDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + motionEvent.toString());
        textView.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Log.d(DEBUG_TAG, "onDoubleTap: " + motionEvent.toString());
        textView.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        Log.d(DEBUG_TAG, "onDoubleTapEvent: " + motionEvent.toString());
        textView.setText("onDoubleTapEvent");
        return true;

    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        Log.d(DEBUG_TAG,"onDown: " + motionEvent.toString());
        textView.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        Log.d(DEBUG_TAG, "onShowPress: " + motionEvent.toString());
        textView.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Log.d(DEBUG_TAG, "onSingleTapUp: " + motionEvent.toString());
        textView.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Log.d(DEBUG_TAG, "onScroll: " + motionEvent.toString() + motionEvent1.toString());
        textView.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Log.d(DEBUG_TAG, "onLongPress: " + motionEvent.toString());
        textView.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        Log.d(DEBUG_TAG, "onFling: " + motionEvent.toString() + motionEvent1.toString());
        textView.setText("onFling");
        return true;
    }
}
