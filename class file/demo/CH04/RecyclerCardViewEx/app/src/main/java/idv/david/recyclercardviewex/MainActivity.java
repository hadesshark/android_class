package idv.david.recyclercardviewex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        /*
            透過LayoutManager的設定可以輕鬆變化RecyclerView的呈現
            以下分別使用LinerLayoutManager與StaggeredGridLayoutManager示範
         */

        //設定每個List是否為固定尺寸
        recyclerView.setHasFixedSize(true);
        //產生一個LinearLayoutManger
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //設定LayoutManager
        recyclerView.setLayoutManager(layoutManager);


//        recyclerView.setLayoutManager(
//                new StaggeredGridLayoutManager(
//                        2, StaggeredGridLayoutManager.HORIZONTAL));
        final List<Team> teamList = new ArrayList<>();
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

        recyclerView.setAdapter(new TeamAdapter(teamList));
    }

    private class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
        private List<Team> teamList;

        public TeamAdapter(List<Team> teamList) {
            this.teamList = teamList;
        }

        //建立ViewHolder，藉由ViewHolder做元件參照
        class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView ivLogo;
            private TextView tvName;

            public ViewHolder(View view) {
                super(view);
                ivLogo = (ImageView) view.findViewById(R.id.ivLogo);
                tvName = (TextView) view.findViewById(R.id.tvName);
            }
        }

        @Override
        public int getItemCount() {
            return teamList.size();
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_team, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            //將資料注入到View裡
            final Team team = teamList.get(position);
            holder.ivLogo.setImageResource(team.getLogo());
            holder.tvName.setText(team.getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, team.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
