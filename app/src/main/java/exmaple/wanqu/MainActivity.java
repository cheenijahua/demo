package exmaple.wanqu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import exmaple.wanqu.utils.ConnectionUtils;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    AlphaAnimation alpha;
    private boolean HaveNet = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.well_img);
        img.setImageResource(R.drawable.wellcome2);
        alpha = new AlphaAnimation(0.1f,1.0f);
        alpha.setDuration(5000);
        img.startAnimation(alpha);
        alpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                HaveNet = ConnectionUtils.isConnection(MainActivity.this);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(HaveNet){
                    Toast.makeText(MainActivity.this, "网络连接正常，正在获取数据", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,ContentActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "没有网络，请检查网络设置", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

}
