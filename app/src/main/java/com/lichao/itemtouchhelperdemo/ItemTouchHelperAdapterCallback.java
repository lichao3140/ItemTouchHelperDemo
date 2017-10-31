package com.lichao.itemtouchhelperdemo;

/**
 * Created by Administrator on 2017-10-31.
 */

public interface ItemTouchHelperAdapterCallback {
    /**
     * 当拖拽的时候回调
     * @param fromPosition
     * @param toPosition
     * @return
     */
    boolean onItemMove(int fromPosition, int toPosition);

    /**
     * 当侧滑删除动作的时候回调
     * @param adapterPosition
     */
    void onItemSwiped(int adapterPosition);
}
