# ILayoutAnimationController
自定义LayoutAnimationController，可任意定制ViewGroup实例内部子View的动画执行顺序，1行代码就让你的ViewGroup拥有华丽的布局动画！
***
### 截屏GIF：
&emsp;&emsp;![](https://github.com/HuanHaiLiuXin/ILayoutAnimationController/blob/master/Screenshots/ILayoutAnimationController%E5%BD%95%E5%B1%8F.gif)   

### 使用方法：
######方法一：首先创建ILayoutAnimationController实例，然后将此实例作为参数为ViewGroup设置布局动画

- 1：{@link ILayoutAnimationController#generateController(Animation, float, ILayoutAnimationController.IndexAlgorithm)}

- 2：{@link android.view.ViewGroup#setLayoutAnimation(LayoutAnimationController)}

######方法二：1行代码直接搞定,以下两种方法任选

- {@link ILayoutAnimationController#setLayoutAnimation(ViewGroup, int, float, ILayoutAnimationController.IndexAlgorithm)}

- {@link ILayoutAnimationController#setLayoutAnimation(ViewGroup, Animation, float,ILayoutAnimationController.IndexAlgorithm)}

### 示例代码：
```
LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
//两行代码设置布局动画：
ILayoutAnimationController controller = ILayoutAnimationController.generateController(AnimationUtils.loadAnimation(this,R.anim.activity_open_enter),0.8f,ILayoutAnimationController.IndexAlgorithm.INDEXSIMPLEPENDULUM);
ll.setLayoutAnimation(controller);

//一行代码直接搞定：
ILayoutAnimationController.setLayoutAnimation(ll,R.anim.activity_open_enter,0.8f,ILayoutAnimationController.IndexAlgorithm.INDEXSIMPLEPENDULUM);

方法setLayoutAnimation中各参数介绍：
/**
 * 根据传入的动画资源ID、单个子View动画延时、子View动画执行顺序算法枚举值 创建一个新的CustomLayoutAnimationController实例，
 * 将此实例作为参数为viewGroup设置布局动画
 * @param viewGroup
 * @param animResId
 * @param delay
 * @param indexAlgorithm
 */
public static void setLayoutAnimation(@NonNull ViewGroup viewGroup,@AnimRes int animResId, float delay,@Nullable final IndexAlgorithm indexAlgorithm){
    Animation animation = AnimationUtils.loadAnimation(viewGroup.getContext(),animResId);
    setLayoutAnimation(viewGroup,animation,delay,indexAlgorithm);
}
```

### 注意：
- *使用ILayoutAnimationController获取的ILayoutAnimationController实例，调用setOrder(int order)方法无效！*

### 开发者：
- **幻海流心**  
- **Email:**wall0920@163.com  
- **简书:**http://www.jianshu.com/users/5702e6847f31/latest_articles  
- **GitHub:**https://github.com/HuanHaiLiuXin
