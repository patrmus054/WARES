package com.example.wares;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<User> mData;
    private LayoutInflater mInflater;

    private final static String TAG = RecyclerAdapter.class.getSimpleName();

    public RecyclerAdapter(Context context, List<User> data){
        this.mData = data;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder");
        View view = mInflater.inflate(R.layout.list_item, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        Log.d(TAG, "onBindViewHolder" + i);

        User user = mData.get(i);
        myViewHolder.setData(user, i);

    }

    @Override
    public int getItemCount() {return mData.size();}

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imgThumb, imgDelete, imgAdd;
        int position;
        User current;

        public MyViewHolder(View itemView) {

            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            imgThumb = (ImageView) itemView.findViewById(R.id.img_row);
            imgDelete = (ImageView) itemView.findViewById(R.id.img_row_delete);
            imgAdd = (ImageView) itemView.findViewById(R.id.img_row_add);
        }
        public void setData(User current, int position){
            this.title.setText(current.getName());
            this.imgThumb.setImageResource(R.drawable.thumb_1_0);
            this.position = position;
            this.current = current;
        }
    }
}
