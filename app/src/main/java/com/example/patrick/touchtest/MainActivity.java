package com.example.patrick.touchtest;

import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    VelocityTracker velocityTracker;
    ImageView gesturePicture;
    //GestureDetector gestureDetector;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //alles Touch-Gesten

        final TextView txt1 = (TextView)this.findViewById(R.id.textView);
        final TextView txt2 = (TextView)this.findViewById(R.id.textView2);
        final TextView txt3 = (TextView)this.findViewById(R.id.textView3);
        final TextView txt4 = (TextView)this.findViewById(R.id.textView4);
        final TextView txt5 = (TextView)this.findViewById(R.id.textView5);

        gesturePicture = (ImageView) this.findViewById(R.id.XPicture);

       /*     gesturePicture.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View view) {
                                                      i++;
                                                      Handler handler = new Handler();
                                                      handler.postDelayed(new Runnable() {
                                                          @Override
                                                          public void run() {
                                                              if (i == 1) {
                                                                  txt4.setText("CLICK!!!");
                                                              }
                                                              if (i == 2) {
                                                                  txt5.setText("DOUBLE CLICK!!!");
                                                              }
                                                              i = 0;
                                                          }
                                                      }, 500);
                                                  }

                                              }


            );

*/





            gesturePicture.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    int action = event.getActionMasked();

                    // get pointer index from the event object
                    int pointerIndex = event.getActionIndex();

                    // get pointer ID
                    int pointerId = event.getPointerId(pointerIndex);

                    switch (action) {
                        case MotionEvent.ACTION_DOWN:

                            if (velocityTracker == null) {
                                velocityTracker = VelocityTracker.obtain();
                            } else {
                                velocityTracker.clear();
                            }
                            velocityTracker.addMovement(event);
                            break;

                        case MotionEvent.ACTION_MOVE:
                            velocityTracker.addMovement(event);
                            velocityTracker.computeCurrentVelocity(50, 1000);

                            if (velocityTracker.getXVelocity() < -100)
                                txt1.setText("TOUCHED1!!!");
                            //vorheriges Lied

                            if (velocityTracker.getXVelocity() > 100)
                                txt2.setText("TOUCHED2!!!");
                            //nächstes Lied

                            if (velocityTracker.getYVelocity() < -100)
                                txt3.setText("TOUCHED3!!!");
                            //break;


                            if (velocityTracker.getYVelocity() > 100)
                                break;

                            break;

                        case MotionEvent.ACTION_UP:
                            txt1.setText("DEFAULT");
                            txt2.setText("DEFAULT");
                            txt3.setText("DEFAULT");



                        case MotionEvent.ACTION_DOWN:
                        case MotionEvent.ACTION_POINTER_DOWN: {
                            // TODO use data
                            break;
                        }
                        case MotionEvent.ACTION_MOVE: { // a pointer was moved
                            // TODO use data
                            break;
                        }
                        case MotionEvent.ACTION_UP:
                        case MotionEvent.ACTION_POINTER_UP:
                        case MotionEvent.ACTION_CANCEL: {
                            // TODO use data
                            break;
                        }

                    }



                    return true;

                }




            });



    }

}
