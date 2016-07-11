package by.a_ogurtsov.utilsbor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class Vybor_massa_us_n1n2n3_1 extends Activity {

    TextView textview1, textview2, textview3, textview4, textview5, textview6, textview7;
    View.OnClickListener onClL;
    Intent intent;
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.vybor_massa_us_n1n2n3_1);

        textview1 = (TextView)findViewById(R.id.textview1);
        textview2 = (TextView)findViewById(R.id.textview2);
        textview3 = (TextView)findViewById(R.id.textview3);
        textview4 = (TextView)findViewById(R.id.textview4);
        textview5 = (TextView)findViewById(R.id.textview5);
        textview6 = (TextView)findViewById(R.id.textview6);
        textview7 = (TextView)findViewById(R.id.textview7);

        intent = new Intent();
        onClL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.textview1:
                        Log.d(LOG_TAG, "Good2");
                        intent.putExtra("category", "13");
                        setResult(RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.textview2:
                        Log.d(LOG_TAG, "Good3");
                        intent.putExtra("category", "14");
                        setResult(RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.textview3:
                        intent.putExtra("category", "15");
                        setResult(RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.textview4:
                        intent.putExtra("category", "16");
                        setResult(RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.textview5:
                        intent.putExtra("category", "17");
                        setResult(RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.textview6:
                        intent.putExtra("category", "18");
                        setResult(RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.textview7:
                        intent.putExtra("category", "19");
                        setResult(RESULT_OK, intent);
                        finish();
                        break;

                }

            }
        };
        textview1.setOnClickListener(onClL);
        textview2.setOnClickListener(onClL);
        textview3.setOnClickListener(onClL);
        textview4.setOnClickListener(onClL);
        textview5.setOnClickListener(onClL);
        textview6.setOnClickListener(onClL);
        textview7.setOnClickListener(onClL);


    }



}
