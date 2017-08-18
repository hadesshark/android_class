package idv.david.viewpagerex;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Team> teamList;
    private ViewPager myViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamList = getTeamList();
        myViewPager = (ViewPager) findViewById(R.id.myViewPager);
        TeamAdapter teamAdapter = new TeamAdapter(getSupportFragmentManager(), teamList);
        myViewPager.setAdapter(teamAdapter);
    }

    private List<Team> getTeamList() {
        List<Team> teamList = new ArrayList<>();
        teamList.add(new Team(R.drawable.p1, "巴爾的摩金鶯"));
        teamList.add(new Team(R.drawable.p2, "芝加哥白襪"));
        teamList.add(new Team(R.drawable.p3, "洛杉磯天使"));
        teamList.add(new Team(R.drawable.p4, "波士頓紅襪"));
        teamList.add(new Team(R.drawable.p5, "克里夫蘭印地安人"));
        teamList.add(new Team(R.drawable.p6, "奧克蘭運動家"));
        teamList.add(new Team(R.drawable.p7, "紐約洋基"));
        teamList.add(new Team(R.drawable.p8, "底特律老虎"));
        teamList.add(new Team(R.drawable.p9, "西雅圖水手"));
        teamList.add(new Team(R.drawable.p10, "坦帕灣光芒"));
        return teamList;
    }

    private class TeamAdapter extends FragmentStatePagerAdapter {
        private List<Team> teamList;

        private TeamAdapter(FragmentManager fm, List<Team> teamList) {
            super(fm);
            this.teamList = teamList;
        }

        @Override
        public Fragment getItem(int i) {
            return TeamFragment.newInstance(teamList.get(i));
        }

        @Override
        public int getCount() {
            return teamList.size();
        }
    }

    public void onFirstClick(View view) {
        myViewPager.setCurrentItem(0);
    }

    public void onLastClick(View view) {
        myViewPager.setCurrentItem(teamList.size() - 1);
    }


}
