package com.lichao.itemtouchhelperdemo;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

/**
 * Created by Administrator on 2017-10-31.
 */

public class MessageItemTouchCallback extends ItemTouchHelper.Callback {

    private static final String TAG = "ItemTouchCallback";
    private ItemTouchHelperAdapterCallback adapterCallback;

    public MessageItemTouchCallback(ItemTouchHelperAdapterCallback adapterCallback) {
        this.adapterCallback = adapterCallback;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //callback回调监听哪些动作？---判断方向
        //makeMovementFlags(UP | DOWN, LEFT);
        int dragFlags = ItemTouchHelper.UP|ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        // 监听滑动（水平方向、垂直方向）
        //让数据集合中的两个数据进行位置交换
        //同时还要刷新RecyclerView
        adapterCallback.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        // 滑动删除的动作的时候回调
        //1.删除数据集合里面的position位置的数据
        //2.刷新adapter
        adapterCallback.onItemSwiped(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        Log.d(TAG, "onChildDraw");
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override
    public float getSwipeEscapeVelocity(float defaultValue) {
        return 5f;
    }

    //滑动消失的距离，当滑动小于这个值的时候会删除这个item，否则不会视为删除
    @Override
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return 0.1f;
    }

    //设置手指离开后ViewHolder的动画时间
    @Override
    public long getAnimationDuration(RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        return 100;
    }

    //网格型RecyclerView
    @Override
    public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
        return 0.9f;
    }

    //返回值决定是否有滑动操作
    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }
}
