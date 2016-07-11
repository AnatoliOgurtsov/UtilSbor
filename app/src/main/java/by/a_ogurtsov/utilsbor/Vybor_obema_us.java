package by.a_ogurtsov.utilsbor;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
/*import android.support.v7.app.ActionBarActivity;*/
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class Vybor_obema_us extends Activity {
    TextView textview1, textview2, textview3, textview4, textview5;
    OnClickListener onClL;
    Intent intent;
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.vybor_obema_us);
        textview1 = (TextView)findViewById(R.id.textview1);
        textview2 = (TextView)findViewById(R.id.textview2);
        textview3 = (TextView)findViewById(R.id.textview3);
        textview4 = (TextView)findViewById(R.id.textview4);
        textview5 = (TextView)findViewById(R.id.textview5);
        intent = new Intent();
        onClL = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.textview1:
                        Log.d(LOG_TAG, "Good2");
                        intent.putExtra("category", "2");
                        setResult(RESULT_OK, intent);
                        finish();
                    break;
                    case R.id.textview2:
                        Log.d(LOG_TAG, "Good3");
                        intent.putExtra("category", "3");
                        setResult(RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.textview3:
                        intent.putExtra("category", "4");
                        setResult(RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.textview4:
                        intent.putExtra("category", "5");
                        setResult(RESULT_OK, intent);
                        finish();
                        break;
                    case R.id.textview5:
                        intent.putExtra("category", "6");
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


    }



}
