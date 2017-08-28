package david.idv.bmifragmentex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by 201t on 2017/8/25.
 */

public class ResultFragment extends Fragment {
    private TextView tvResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        tvResult = (TextView) view.findViewById(R.id.tvResult);
        Button btnBack = (Button) view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        showResult();
        return view;

    }

    private void showResult() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        Bundle bundle = getArguments();
        double height = bundle.getDouble("height");
        double weight = bundle.getDouble("weight");

        double bmi = weight / Math.pow(height, 2);
        String result = "";
        if (bmi < 18.5) {
            result = "過瘦";
        } else if (bmi >= 24) {
            result = "過胖";
        } else {
            result = "正常";
        }

        String bmiStr = nf.format(bmi);
        StringBuilder sb = new StringBuilder();
        sb.append("BMI: ").append(bmiStr).append("\n").append("結果: ").append(result);

        tvResult.append("\n" + sb.toString());

    }
}
