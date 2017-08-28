package david.idv.bmifragmentex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 201t on 2017/8/25.
 */

public class MainFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        final EditText etHeight = (EditText) view.findViewById(R.id.etHeight);
        final EditText etWeight = (EditText) view.findViewById(R.id.etWeight);
        Button btnCancel = (Button) view.findViewById(R.id.btnCancel);
        Button btnSubmit = (Button) view.findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightStr = etHeight.getText().toString();
                String weightStr = etWeight.getText().toString();

                if (heightStr.isEmpty() || weightStr.isEmpty()) {
                    Toast.makeText(getActivity(), getString(R.string.msg_empty_err), Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double height = Double.parseDouble(heightStr) / 100;
                    double weight = Double.parseDouble(weightStr);
                    ResultFragment resultFragment = new ResultFragment();
                    Bundle bundle = new Bundle();
                    bundle.putDouble("height", height);
                    bundle.putDouble("weight", weight);
                    resultFragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.frameLayout, resultFragment, "result")
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .commit();

                } catch (NumberFormatException ne) {
                    Toast.makeText(getActivity(), getString(R.string.msg_data_err), Toast.LENGTH_SHORT).show();
                    return;
                }
            }


        });
        return view;
    }

}