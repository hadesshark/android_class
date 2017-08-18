package idv.david.flexiblefragmentex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainFragment extends ListFragment {
    private boolean isDual;
    private int position;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 將所有球隊名字取出放進一個ArrayList集合裡
        ArrayList<String> teamNames = new ArrayList<>();
        for (MyTeam.Team team : MyTeam.TEAMS) {
            teamNames.add(team.getName());
        }

        setListAdapter(new ArrayAdapter<>(getActivity(), R.layout.fragment_main, teamNames));
        View infoFrameLayout = getActivity().findViewById(R.id.info);
        /*
            isDual為true條件：
            1. 透過findViewById有取得framelayout物件 (若是讀取activity_main(port)就沒有framelayout)
            2. 此framelayout是否可以被看見，沒有被隱藏起來
         */
        isDual = infoFrameLayout != null && infoFrameLayout.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
        }

        if (isDual) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showInfo();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("position", position);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        this.position = position;
        showInfo();
    }

    private void showInfo() {
        if (isDual) {
            InfoFragment infoFragment = (InfoFragment) getFragmentManager().findFragmentById(R.id.info);
            if (infoFragment == null || infoFragment.getPosition() != position) {
                infoFragment = new InfoFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("position", position);
                infoFragment.setArguments(bundle);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.info, infoFragment);
                //加入過場動畫
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }
        } else {
            //無法同時顯示兩個fragment情況下，就需要產生InfoActivity，再將InfoFragment依附上去
            Intent intent = new Intent(getActivity(), InfoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
