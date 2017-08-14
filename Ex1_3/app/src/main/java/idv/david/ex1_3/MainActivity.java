package idv.david.ex1_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Team> teamList;
    private Button btnBefore, btnNext;
    private TextView tvName;
    private ImageView ivLogo;

    //teams' index
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
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

        tvName = (TextView) findViewById(R.id.tvName);
        ivLogo = (ImageView) findViewById(R.id.ivLogo);

        //第一次初始化先載入第一筆資料
        tvName.setText(teamList.get(position).getName());
        ivLogo.setImageResource(teamList.get(position).getLogo());


        btnBefore = (Button) findViewById(R.id.btnBefore);
        btnBefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //點擊一次index就減1
                position--;
                if (position < 0) {
                    //當索引值小於0時，即回到該陣列的最後一個索引值
                    position = teamList.size() - 1;
                }
                tvName.setText(teamList.get(position).getName());
                ivLogo.setImageResource(teamList.get(position).getLogo());
            }
        });

        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //點擊一次index就加1
                position++;
                if (position > (teamList.size() - 1)) {
                    //當索引值大於陣列長度時，即回到該陣列的第一個索引值
                    position = 0;
                }
                tvName.setText(teamList.get(position).getName());
                ivLogo.setImageResource(teamList.get(position).getLogo());
            }
        });
    }
}
