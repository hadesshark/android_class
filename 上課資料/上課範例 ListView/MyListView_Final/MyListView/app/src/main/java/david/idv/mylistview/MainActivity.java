package david.idv.mylistview;

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
        initList();
        findViews();
    }

    private void initList() {
        teamList = new ArrayList<>();
        teamList.add(new Team(R.drawable.p1, "第一隊"));
        teamList.add(new Team(R.drawable.p2, "第二隊"));
        teamList.add(new Team(R.drawable.p3, "第三隊"));
        teamList.add(new Team(R.drawable.p4, "第四隊"));
        teamList.add(new Team(R.drawable.p5, "第五隊"));
        teamList.add(new Team(R.drawable.p6, "第六隊"));
        teamList.add(new Team(R.drawable.p7, "第七隊"));
        teamList.add(new Team(R.drawable.p8, "第八隊"));
        teamList.add(new Team(R.drawable.p9, "第九隊"));
        teamList.add(new Team(R.drawable.p10, "第十隊"));
    }

    private void findViews() {
        listView = (ListView)findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Team team = (Team)parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, team.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class MyAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        public MyAdapter(Context context) {
           inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return teamList.size();
        }

        @Override
        public Object getItem(int position) {
            return teamList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // version 1
//            View view = inflater.inflate(R.layout.team_listview, parent, false);
//            ImageView ivLogo = (ImageView)view.findViewById(R.id.ivLogo);
//            TextView tvName = (TextView)view.findViewById(R.id.tvName);
//            Team team = teamList.get(position);
//            ivLogo.setImageResource(team.getLogo());
//            tvName.setText(team.getName());

            // version 2 (解決layout重複載入問題)
//            if (convertView == null) {
//                convertView = inflater.inflate(R.layout.team_listview, parent, false);
//            }
//            ImageView ivLogo = (ImageView)convertView.findViewById(R.id.ivLogo);
//            TextView tvName = (TextView)convertView.findViewById(R.id.tvName);
//            Team team = teamList.get(position);
//            ivLogo.setImageResource(team.getLogo());
//            tvName.setText(team.getName());

            // version 3 (解決layout重複載入問題與元件重複findViewById)
            ViewHolder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.team_listview, parent, false);
                holder = new ViewHolder();
                holder.ivLogo = (ImageView)convertView.findViewById(R.id.ivLogo);
                holder.tvName = (TextView)convertView.findViewById(R.id.tvName);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder)convertView.getTag();
            }

            Team team = teamList.get(position);
            holder.ivLogo.setImageResource(team.getLogo());
            holder.tvName.setText(team.getName());
            return convertView;
        }

        private class ViewHolder {
            ImageView ivLogo;
            TextView tvName;
        }


    }


}
