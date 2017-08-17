package idv.david.menusex;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    public void findViews() {
        tvResult = (TextView) findViewById(R.id.tvResult);
        registerForContextMenu(tvResult);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String result = "";
        switch (item.getItemId()) {
            case R.id.menuMLB:
                result += getString(R.string.mlb);
                break;
            case R.id.al:
                result += getString(R.string.mlb) + ">>" + getString(R.string.american);
                break;
            case R.id.nl:
                result += getString(R.string.mlb) + ">>" + getString(R.string.national);
                break;
            case R.id.pbl:
                result += getString(R.string.pbl);
                break;
            case R.id.cpbl:
                result += getString(R.string.cpbl);
                break;
            case R.id.exit:
                System.exit(0);
            default:
                return super.onOptionsItemSelected(item);
        }
        tvResult.setText(result);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clear:
                tvResult.setText("");
                break;
            case R.id.yellow:
                tvResult.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.green:
                tvResult.setBackgroundColor(Color.GREEN);
                break;
            case R.id.red:
                tvResult.setBackgroundColor(Color.RED);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void onDeleteClick(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                tvResult.setText(item.getTitle());
                return true;
            }
        });
        popupMenu.show();
    }
}
