package idv.david.fragmentex;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAddClick(View view) {
        // FragmentManager專門用來管理Fragment
        FragmentManager manager = getSupportFragmentManager();
        // FragmentTransaction用來附加、移除、取代Fragment，最後要呼叫commit()方法以確定執行
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = manager.findFragmentById(R.id.frameLayout);
        if (fragment == null) {
            String title = "Dynamic_Fragment A";
            DynamicFragment fragmentA = new DynamicFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            fragmentA.setArguments(bundle);
            transaction.add(R.id.frameLayout, fragmentA, TAG);
            transaction.commit();
        } else {
            showToast("fragment exists");
        }
    }

    public void onReplaceClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        String title = "Dynamic_Fragment B";
        DynamicFragment fragmentB = new DynamicFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragmentB.setArguments(bundle);

        transaction.replace(R.id.frameLayout, fragmentB, TAG);
        transaction.commit();
    }

    public void onAttachClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = manager.findFragmentById(R.id.frameLayout);
        if (fragment == null) {
            showToast("fragment doesn't exists");
        } else {
            if (fragment.isDetached()) {
                transaction.attach(fragment);
                transaction.commit();
            } else {
                showToast("fragment attached");
            }
        }
    }

    public void onDetachClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = manager.findFragmentByTag(TAG);
        if (fragment == null) {
            showToast("fragment doesn't exists");
        } else {
            if (!fragment.isDetached()) {
                transaction.detach(fragment);
                transaction.commit();
            } else {
                showToast("fragment detached");
            }
        }
    }

    public void onRemoveClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = manager.findFragmentByTag(TAG);
        if (fragment != null) {
            transaction.remove(fragment);
            transaction.commit();
        } else {
            showToast("fragment doesn't exists");
        }
    }

    public void onFinishClick(View view) {
        finish();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
