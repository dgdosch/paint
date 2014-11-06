package ddosch.yahoo.com.paint;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ddosch on 11/4/14.
 */
public class DoodleView extends View {

    Paint paint5;
    Paint paint2;
    Paint erase;
    Paint paintToUse;
    Path path;

    public DoodleView(Context context) {
        super(context);
    }

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint5 = new Paint();
        paint5.setColor(Color.BLUE);
        paint5.setStrokeWidth(10);
        paint5.setStyle(Paint.Style.STROKE);

        paint2 = new Paint();
        paint2.setColor(Color.RED);
        paint2.setStrokeWidth(3);
        paint2.setStyle(Paint.Style.STROKE);

        erase = new Paint();
        erase.setColor(Color.WHITE);
        erase.setStrokeWidth(50);
        erase.setStyle(Paint.Style.STROKE);

        paintToUse = paint5;

        path = new Path();

    }

    public DoodleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawCircle(200, 200, 100, paint5);
        canvas.drawPath(path, paintToUse);
//        canvas.drawPath(path, paint2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(), event.getY());
                postInvalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(), event.getY());
                postInvalidate();
                return true;
            case MotionEvent.ACTION_UP:
                return false;
        }
        return false;
    }

    public void switchPaint(boolean useEraser) {
        paintToUse = useEraser ? erase : paint5;
    }
}
