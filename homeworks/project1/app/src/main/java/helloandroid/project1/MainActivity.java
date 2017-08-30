package helloandroid.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String str[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        RecyclerView recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);

        final List<Team> teamList = new ArrayList<>();
        try {
            str = getAssets().list("bookstore");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String sub_str : str) {
            System.out.println(sub_str);
            teamList.add(new Team(sub_str));
        }

        recyclerview.setAdapter(new TeamAdapter(teamList));
    }

    private class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {
        private List<Team> teamList;

        class ViewHolder extends RecyclerView.ViewHolder {
            private TextView tvName;
            private CardView cardView;

            public ViewHolder(View itemView) {
                super(itemView);
                tvName = (TextView) itemView.findViewById(R.id.tv_name);
                cardView = (CardView) itemView.findViewById(R.id.card_view);
            }
        }

        public TeamAdapter(List<Team> teamList) {
            this.teamList = teamList;
        }

        @Override
        public TeamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reader_card, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TeamAdapter.ViewHolder holder, int position) {
            final Team team = teamList.get(position);
            holder.tvName.setText(team.getStr());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, team.getStr(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return teamList.size();
        }
    }
}
