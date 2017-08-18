package idv.david.activitylifecycleex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ActivityLifeCycleEx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // error
        Log.e(TAG, "This is onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        // warning
        Log.w(TAG, "This is onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // debug
        Log.d(TAG, "This is onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        // info
        Log.i(TAG, "This is onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // verbose
        Log.wtf(TAG, "This is onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "This is onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "This is onDestroy");
    }

}
