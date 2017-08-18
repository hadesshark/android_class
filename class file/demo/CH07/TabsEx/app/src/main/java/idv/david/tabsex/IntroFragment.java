package idv.david.tabsex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class IntroFragment extends Fragment {
    private List<Intro> introList;

    public IntroFragment() {
        introList = new ArrayList<>();
        introList.add(new Intro("Boston RedSox", "波士頓紅襪", R.drawable.p4));
        introList.add(new Intro("New York Yankees", "紐約洋基", R.drawable.p7));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        recyclerView.setAdapter(new IntroAdapter(inflater));
        return view;
    }


    private class IntroAdapter extends RecyclerView.Adapter<IntroAdapter.ViewHolder> {
        private LayoutInflater inflater;

        public IntroAdapter(LayoutInflater inflater) {
            this.inflater = inflater;
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvName, tvTitle;
            ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);
                tvName = (TextView) itemView.findViewById(R.id.tvName);
                tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
                imageView = (ImageView) itemView.findViewById(R.id.imageView);
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = inflater.inflate(R.layout.card_intro, parent, false);
            ViewHolder viewHolder = new ViewHolder(itemView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
            final Intro intro = introList.get(position);
            viewHolder.tvName.setText(intro.getName());
            viewHolder.tvTitle.setText(intro.getCName());
            viewHolder.imageView.setImageResource(intro.getImageId());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), IntroDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("intro", intro);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }


        @Override
        public int getItemCount() {
            return introList.size();
        }
    }
}
