package helloandroid.homework2_2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Team> teamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        findViews();
    }

    private void findViews() {
        listView = (ListView) findViewById(R.id.list_view);
        final MyAdapter adapter = new MyAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Team team = (Team) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, Integer.toString(team.getNum()) + ' ' + team.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initViews() {
        teamList = new ArrayList<>();
        teamList.add(new Team(1, R.drawable.p1, "巴爾的摩金鶯"));
        teamList.add(new Team(2, R.drawable.p2, "芝加哥白襪"));
        teamList.add(new Team(3, R.drawable.p3, "洛杉磯天使"));
        teamList.add(new Team(4, R.drawable.p4, "波士頓紅襪"));
        teamList.add(new Team(5, R.drawable.p5, "克里夫蘭印地安人"));
        teamList.add(new Team(6, R.drawable.p6, "奧克蘭運動家"));
        teamList.add(new Team(7, R.drawable.p7, "紐約洋基"));
        teamList.add(new Team(8, R.drawable.p8, "底特律老虎"));
        teamList.add(new Team(9, R.drawable.p9, "西雅圖水手"));
        teamList.add(new Team(10, R.drawable.p10, "坦帕灣光芒"));
    }

    private class MyAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        public MyAdapter(Context context) {
            this.inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            // 顯示幾筆資料
            return teamList.size();
        }

        @Override
        public Object getItem(int position) {
            // 回應資料
            return teamList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            final ViewHolder holder;
            if (convertView == null) {
                convertView = this.inflater.inflate(R.layout.team_listview, parent, false);
                holder = new ViewHolder();
                holder.ivlogo = (ImageView) convertView.findViewById(R.id.ivlogo);
                holder.num = (TextView) convertView.findViewById(R.id.tv_num);
                holder.tvname = (TextView) convertView.findViewById(R.id.tvName);
                // can reuse
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Team team = teamList.get(position);
            holder.ivlogo.setImageResource(team.getLogo());
            holder.tvname.setText(team.getName());
            holder.tvname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, holder.tvname.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
            holder.num.setText(Integer.toString(team.getNum()));
            holder.num.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, holder.num.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
        }

        private class ViewHolder {
            TextView num;
            ImageView ivlogo;
            TextView tvname;
        }
    }
}

