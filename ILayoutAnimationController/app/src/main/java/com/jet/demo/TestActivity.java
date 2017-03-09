package com.jet.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.jet.ilayoutanimationcontroller.ILayoutAnimationController;

public class TestActivity extends AppCompatActivity {
    private LinearLayout ll = null;
    private int indexBgColor = 0;
    private int[] colors = new int[]{
            Constant.color_flyme_blue_green,
            Constant.color_flyme_blue_sky,
            Constant.color_flyme_green,
            Constant.color_flyme_orange,
            Constant.color_flyme_red_bright,
            Constant.color_cn_dingxiang,
            Constant.color_cn_dailan,
            Constant.color_cn_xiangyabai,
            Constant.color_cn_zhuqing,
            Constant.color_cn_haitanghong,
            Constant.color_cn_zitan,
            Constant.color_cn_fei
    };
    //
    private int index = 0;
    private int indexAlgorithmsIndex = 0;
    private ILayoutAnimationController.IndexAlgorithm[] indexAlgorithms = new ILayoutAnimationController.IndexAlgorithm[]{
            ILayoutAnimationController.IndexAlgorithm.INDEX1325476,
            ILayoutAnimationController.IndexAlgorithm.INDEX135246,
            ILayoutAnimationController.IndexAlgorithm.INDEX246135,
            ILayoutAnimationController.IndexAlgorithm.INDEXSIMPLEPENDULUM,
            ILayoutAnimationController.IndexAlgorithm.MIDDLETOEDGE,
            ILayoutAnimationController.IndexAlgorithm.INDEX15263748,
            ILayoutAnimationController.IndexAlgorithm.INDEX1325476REVERSE,
            ILayoutAnimationController.IndexAlgorithm.INDEX135246REVERSE,
            ILayoutAnimationController.IndexAlgorithm.INDEX246135REVERSE,
            ILayoutAnimationController.IndexAlgorithm.INDEXSIMPLEPENDULUMREVERSE,
            ILayoutAnimationController.IndexAlgorithm.INDEXMIDDLETOEDGEREVERSE,
            ILayoutAnimationController.IndexAlgorithm.INDEX15263748REVERSE
    };
    private int animsIndex = 0;
    private int[] anims = new int[]{
            R.anim.activity_open_enter,
            R.anim.dialog_enter,
            R.anim.push_down_in,
            R.anim.dock_left_enter,
            R.anim.dock_right_enter
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        index = getIntent().getIntExtra("index",index);
        indexBgColor = index%colors.length;
        indexAlgorithmsIndex = index%indexAlgorithms.length;
        animsIndex = index%anims.length;
        setContentView(R.layout.activity_main);
        ll = (LinearLayout) findViewById(R.id.ll);
        for(int i=0;i<ll.getChildCount();i++){
            ll.getChildAt(i).setBackgroundColor(colors[indexBgColor]);
        }
//        ILayoutAnimationController controller = ILayoutAnimationController.generateController(AnimationUtils.loadAnimation(this,anims[animsIndex]),0.8f,indexAlgorithms[indexAlgorithmsIndex]);
//        ll.setLayoutAnimation(controller);
        ILayoutAnimationController.setLayoutAnimation(ll,anims[animsIndex],0.8f,indexAlgorithms[indexAlgorithmsIndex]);
    }
}
