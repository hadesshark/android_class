package helloandroid.hw_03;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static helloandroid.hw_03.R.id.iview;


public class MainActivity extends AppCompatActivity {

    private Button btn_next;
    private Button btn_pre;
    private TextView tv_name;
    private ImageView iv_view;
    private TypedArray images;
    private String[] str_names;
    private int images_num = 0;
//    private View_Setting v_setting = new View_Setting();

//        private Button.OnClickListener listener = new Button.OnClickListener() {
//
//        @Override
//        public void onClick(View view) {
//            switch (view.getId()) {
//                case R.id.btn_next:
//                    images_num += 1;
//                    if (images_num >= images.length()) {
//                        images_num = 0;
//                    }
//                    iv_view.setImageResource(images.getResourceId(images_num, -1));
//                    break;
//                case R.id.btn_pre:
//                    images_num -= 1;
//                    if (images_num < 0) {
//                        images_num = 9;
//                    }
//                    iv_view.setImageResource(images.getResourceId(images_num, -1));
//                    break;
//            }
//        }
//    };

//    public class View_Setting {
//        String[] str_names;
//        TypedArray images;
//
//        public void setting(int value) {
//            iv_view.setImageResource(images.getResourceId(value, -1));
//            tv_name.setText(str_names[value]);
//        }
//
//        public void set_name(String[] str) {
//            this.str_names = str;
//        }
//
//        public void set_images(TypedArray t_array) {
//            this.images = t_array;
//        }
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        btn_next = (Button) findViewById(R.id.btn_next);
        btn_pre = (Button) findViewById(R.id.btn_pre);
        iv_view = (ImageView) findViewById(iview);
        tv_name = (TextView) findViewById(R.id.tv_name);
        images = getResources().obtainTypedArray(R.array.imgs);
        str_names = getResources().getStringArray(R.array.name_string);

//        v_setting.set_name(getResources().getStringArray(R.array.name_string));
//        v_setting.set_images(getResources().obtainTypedArray(R.array.imgs));


//        btn_next.setOnClickListener(listener);
//        btn_pre.setOnClickListener(listener);
    }

    private void view_setting(int value) {
        iv_view.setImageResource(images.getResourceId(value, -1));
        tv_name.setText(str_names[value]);
    }

    public void btn_click(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                images_num += 1;
                if (images_num >= images.length()) {
                    images_num = 0;
                }
//                v_setting.setting(images_num);
                view_setting(images_num);
                break;
            case R.id.btn_pre:
                images_num -= 1;
                if (images_num < 0) {
                    images_num = 9;
                }
//                v_setting.setting(images_num);
                view_setting(images_num);
                break;
        }
    }
}
