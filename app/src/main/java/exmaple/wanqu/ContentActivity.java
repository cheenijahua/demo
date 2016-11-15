package exmaple.wanqu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContentActivity extends AppCompatActivity implements BaseInterfase, View.OnClickListener {

    private ViewPager pager;

    private LinearLayout[] lines = new LinearLayout[4];
    private ImageView[] imageViews = new ImageView[4];
    private TextView[] textViews = new TextView[4];
    private int[] lineIds = {R.id.line_home,R.id.line_msg,R.id.line_me,R.id.line_more};
    private int[] txtIds = {R.id.home_txt,R.id.msg_txt,R.id.me_txt,R.id.more_txt};
    private int[] imgIds = {R.id.home_img,R.id.msg_img,R.id.me_img,R.id.more_img};
    private List<Fragment> fragments;
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        initView();
        initData();
        initOper();
    }

    @Override
    public void initView() {
        for(int i=0;i<4;i++){
            lines[i] = (LinearLayout) findViewById(lineIds[i]);
            imageViews[i] = (ImageView) findViewById(imgIds[i]);
            textViews[i] = (TextView) findViewById(txtIds[i]);
            lines[i].setOnClickListener(this);
        }
        pager = (ViewPager) findViewById(R.id.pager_view);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                changeView(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void initData() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MyselfFragment());
        fragments.add(new MoreFragment());
        manager = getSupportFragmentManager();
        pager.setAdapter(new MyAdapter(fragments,manager));
    }

    @Override
    public void initOper() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.line_home:
                pager.setCurrentItem(0,false);
                changeView(0);
                break;
            case R.id.line_msg:
                pager.setCurrentItem(1,false);
                changeView(1);
                break;
            case R.id.line_me:
                pager.setCurrentItem(2,false);
                changeView(2);
                break;
            case R.id.line_more:
                pager.setCurrentItem(3,false);
                changeView(3);
                break;
        }
    }
    int[] on = {R.drawable.home_act,R.drawable.message_act,R.drawable.me_act,R.drawable.more_act};
    int[] off = {R.drawable.home,R.drawable.message,R.drawable.me,R.drawable.more};

    private void changeView(int position) {
        for (int j=0; j<4; j++){
            if (j ==position){
                textViews[j].setTextColor(Color.parseColor("#ff8200"));
                imageViews[j].setImageResource(on[j]);
            }else {
                textViews[j].setTextColor(Color.parseColor("#000000"));
                imageViews[j].setImageResource(off[j]);
            }
        }

    }
}
