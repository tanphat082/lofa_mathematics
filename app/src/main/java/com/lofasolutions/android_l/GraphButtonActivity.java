package com.lofasolutions.android_l;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class GraphButtonActivity extends Activity {
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LinearLayout buttonGraph = new LinearLayout(this);
        buttonGraph.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT); // Verbose!

       
        //float[] xvalues = new float[] { -1.0f, 1.0f, 2.0f, 3.0f , 4.0f, 5.0f, 6.0f };
        //float[] yvalues = new float[] { 15.0f, 2.0f, 0.0f, 2.0f, -2.5f, -1.0f , -3.0f };
        
        float[] xvalues = new float[1001];
        float[] yvalues = new float[1001];
        Intent intent = getIntent();
        String calc = intent.getStringExtra("calc");
        PlotMath plotMath = new PlotMath();
        for (int i = 0; i < 1001; i++){
        	double temp = ( -5 + i * .01);
        	xvalues[i] = (float)temp;
//        	yvalues[i] = (float)(Math.sin(temp));
            String newCalc = plotMath.makeExpression(calc, xvalues[i]);
            yvalues[i] = plotMath.getY(newCalc);
            temp = 0;
        }
        
        plot2d graph = new plot2d(this, xvalues, yvalues, 1);

        buttonGraph.addView(graph, lp);

        setContentView(buttonGraph);
        
    }
}