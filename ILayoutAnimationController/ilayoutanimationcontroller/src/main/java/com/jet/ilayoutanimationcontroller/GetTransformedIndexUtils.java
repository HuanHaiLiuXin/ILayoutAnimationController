package com.jet.ilayoutanimationcontroller;

/**
 *
    与ILayoutAnimationController配合使用的 “ViewGroup实例中子View布局动画执行顺序规则 工具类”
    (⊙o⊙)…，好绕口的名字，具体作用大家一定懂得

    所有方法只针对 正向 和 反向 起作用,没有随机效果
        1:当想设置正向效果 ,使用上半部分方法:
                getTransformedIndex1325476
                getTransformedIndex135246
                getTransformedIndex246135
                getTransformedIndexSimplePendulum
                getTransformedIndexMiddleToEdge
                getTransformedIndex15263748
        2:当想设置反向效果 ,使用下半部分方法:
                getTransformedIndex1325476REVERSE
                getTransformedIndex135246REVERSE
                getTransformedIndex246135REVERSE
                getTransformedIndexSimplePendulumREVERSE
                getTransformedIndexMiddleToEdgeREVERSE
                getTransformedIndex15263748REVERSE
 *
 *
 * 作者:幻海流心
 * GitHub:https://github.com/HuanHaiLiuXin
 * 邮箱:wall0920@163.com
 * 2017/03/09
 */
public final class GetTransformedIndexUtils {
    private GetTransformedIndexUtils() {
        throw new RuntimeException("工具类禁止新建实例");
    }

    /**
     * 先执行第1项 的布局动画,
     * 然后执行第3项 的布局动画,然后执行第2项 的布局动画,
     * 然后执行第5项 的布局动画,然后执行第4项 的布局动画,
     * 然后执行第7项 的布局动画,然后执行第6项 的布局动画---
     * @param count
     * @param index
     * @return
     */
    public static int getTransformedIndex1325476(int count, int index){
        if ((index + 1) % 2 != 0) {
            if (index == 0) {
                return index;
            } else {
                return index - 1;
            }
        } else {
            if (index == count - 1) {
                return index;
            } else {
                return index + 1;
            }
        }
    }

    /**
     * 先执行奇数项 的布局动画,再执行偶数项 的布局动画
     * @param count
     * @param index
     * @return
     */
    public static int getTransformedIndex135246(int count, int index){
        if (index%2==0){
            //1:奇数项
            return index/2;
        }else {
            //2:偶数项
            if(count%2==0){
                //2.1:当总项数是偶数
                return (count/2-1) + (index+1)/2;
            }else {
                //2.2:当总项数是奇数
                return (count/2) + (index+1)/2;
            }
        }
    }

    /**
     * 先执行偶数项 的布局动画,再执行奇数项 的布局动画
     * @param count
     * @param index
     * @return
     */
    public static int getTransformedIndex246135(int count, int index){
        if (index%2!=0){
            //1:偶数项
            return (index+1)/2-1;
        }else{
            //2:奇数项
            return count/2 + index/2;
        }
    }

    /**
     * 先执行第1项 的布局动画,然后执行第N项 的布局动画,
     * 然后执行第2项 的布局动画,然后执行第N-1项 的布局动画,
     * 然后执行第3项 的布局动画,然后执行第N-2项 的布局动画---
     * 最后执行中间项 的布局动画
     *
     * 执行布局动画的项的索引值,其变化规律,类似于'荡秋千',每次运动的最高点的X坐标与X轴中点的偏移量绝对值逐渐减小直至停止运动.
     * 学术名称叫: 单摆 simple pendulum
     *
     * 方法名也可以叫:getTransformedIndex162534 ,更好理解
     * @param count
     * @param index
     * @return
     */
    public static int getTransformedIndexSimplePendulum(int count, int index){
        if (count%2==0){
            //1:当总项数是偶数
            if(index+1<=count/2){
                //1.1:前半部分项
                return index*2;
            }else {
                //1.2:后半部分项
                return 1 + (count-1-index)*2;
            }
        }else{
            //2:当总项数是奇数
            if(index+1<(count+1)/2){
                //2.1:前半部分项
                return index*2;
            }else if(index+1>(count+1)/2){
                //2.2:后半部分项
                return 1 + (count-1-index)*2;
            }else{
                //2.3:中间项
                return count - 1;
            }
        }
    }

    /**
     * 先执行中间项 的布局动画,然后依次向边缘扩展执行
     *      中间项/(第一中间项+第二中间项) ==> 中间项-1 ==> 中间项+1 ==> 中间项-2 == >中间项+2 --- 第一项 和 最后一项
     * 最后执行 第一项 和 最后一项 的布局动画
     * @param count
     * @param index
     * @return
     */
    public static int getTransformedIndexMiddleToEdge(int count, int index){
        if (count%2==0){
            //1:当总项数是偶数
            if(index+1 == count/2){
                //1.1:第一中间项
                return 0;
            }else if(index+1 == count/2+1){
                //1.2:第二中间项
                return 1;
            }else if(index+1 < count/2){
                //1.3:前半部分项
                return (count/2 - (index + 1))*2;
            }else{
                //1.4:后半部分项
                return 1 + ((index+1)-(count/2+1))*2;
            }
        }else{
            //2:当总项数是奇数
            if (index+1 == (count+1)/2){
                //2.1:中间项
                return 0;
            }else if(index+1 < (count+1)/2){
                //2.1:前半部分项
                return (count-1-1) - index*2;
            }else{
                //2.2:后半部分项
                return (count-1) - (count-1-index)*2;
            }
        }
    }

    /**
     * 将所有项分成 前后均等 或 前=后-1 的两部分,
     * 先执行 前半部分第1项 的布局动画,然后执行 后半部分第1项 的布局动画,
     * 再执行 前半部分第2项 的布局动画,然后执行 后半部分第2项 的布局动画---
     * 直至全部项的布局动画都执行完毕
     * @param count
     * @param index
     * @return
     */
    public static int getTransformedIndex15263748(int count, int index){
        if (count%2==0){
            //1:当总项数是偶数
            if(index+1<=count/2){
                //1.1:前半部分项
                return index*2;
            }else{
                //1.2:后半部分项
                return (count-1) - ((count-1)-index)*2;
            }
        }else{
            //2:当总项数是奇数
            if (index+1<(count+1)/2){
                //2.1:前半部分项
                return index*2;
            }else if (index == count-1){
                //2.2:后半部分项最后一项
                return index;
            }else {
                //2.3:后半部分项 和 前半部分一一对应的部分
                return 1 + (index-((count+1)/2-1))*2;
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * getTransformedIndex1325476的倒序
     */
    public static int getTransformedIndex1325476REVERSE(int count, int index){
        return (count-1) - getTransformedIndex1325476(count, index);
    }

    /**
     * getTransformedIndex135246的倒序
     */
    public static int getTransformedIndex135246REVERSE(int count, int index){
        return (count-1) - getTransformedIndex135246(count, index);
    }

    /**
     * getTransformedIndex246135的倒序
     */
    public static int getTransformedIndex246135REVERSE(int count, int index){
        return (count-1) - getTransformedIndex246135(count, index);
    }

    /**
     * getTransformedIndexSimplePendulum的倒序
     */
    public static int getTransformedIndexSimplePendulumREVERSE(int count, int index){
        return (count-1) - getTransformedIndexSimplePendulum(count, index);
    }

    /**
     * getTransformedIndexMiddleToEdge的倒序
     */
    public static int getTransformedIndexMiddleToEdgeREVERSE(int count, int index){
        return (count-1) - getTransformedIndexMiddleToEdge(count, index);
    }

    /**
     * getTransformedIndex15263748的倒序
     */
    public static int getTransformedIndex15263748REVERSE(int count, int index){
        return (count-1) - getTransformedIndex15263748(count, index);
    }
}