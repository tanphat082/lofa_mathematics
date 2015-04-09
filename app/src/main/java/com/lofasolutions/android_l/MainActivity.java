package com.lofasolutions.android_l;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    TextView textView;
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonCos,buttonDevide;
    String calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.fx);

        button0 = (Button) findViewById(R.id.btn_0);
        button0.setOnClickListener(this);
        button1 = (Button) findViewById(R.id.btn_1);
        button1.setOnClickListener(this);
        button2 = (Button) findViewById(R.id.btn_2);
        button2.setOnClickListener(this);
        button3 = (Button) findViewById(R.id.btn_3);
        button3.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.btn_4);
        button4.setOnClickListener(this);
        button5 = (Button) findViewById(R.id.btn_5);
        button5.setOnClickListener(this);
        button6 = (Button) findViewById(R.id.btn_6);
        button6.setOnClickListener(this);
        button7 = (Button) findViewById(R.id.btn_7);
        button7.setOnClickListener(this);
        button8 = (Button) findViewById(R.id.btn_8);
        button8.setOnClickListener(this);
        button9 = (Button) findViewById(R.id.btn_9);
        button9.setOnClickListener(this);
        buttonCos = (Button) findViewById(R.id.btn_cos);
        buttonCos.setOnClickListener(this);
    }

//    public void onClickBtn0 (View v) {
//        addtext("0");
//    }
    @Override
    public void onClick(View v) {
    switch (v.getId()) {
        case R.id.btn_0:
            addtext("0");
            break;
        case R.id.btn_1:
            addtext("1");
            break;
        case R.id.btn_2:
            addtext("2");
            break;
        case R.id.btn_3:
            addtext("3");
            break;
        case R.id.btn_4:
            addtext("4");
            break;
        case R.id.btn_5:
            addtext("5");
            break;
        case R.id.btn_6:
            addtext("6");
            break;
        case R.id.btn_7:
            addtext("7");
            break;
        case R.id.btn_8:
            addtext("8");
            break;
        case R.id.btn_9:
            addtext("9");
            break;
        case R.id.btn_cos:
            addtext("cos(");
            break;
        case R.id.btn_devide:
            addtext("/");
            break;
        default:
//            resId = R.raw.a;
            break;
        }
    }

    public void addtext(String text) {
        int length = text.length();
        calc = textView.getText().toString();
        calc += text;
        textView.setText(calc);
    }




  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
