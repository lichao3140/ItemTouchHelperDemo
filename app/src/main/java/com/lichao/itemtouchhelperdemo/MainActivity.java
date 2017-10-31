package com.lichao.itemtouchhelperdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import java.util.List;

public class MainActivity extends Activity implements StartDragListener{

    private RecyclerView recyclerview;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        List<QQMessage> list = DataUtils.init();

        MessageAdapter adapter = new MessageAdapter(list, this);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new MessageItemTouchCallback(adapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerview);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
    }
}
