package jamesno.hw1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
/**
 * Created by James No on 5/14/2017.
 */

public class titleAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {
    private List<Post> itemList;
    private Context context;

    public titleAdapter(Context context, List<Post> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.songTitle.setText("Song Title: " + itemList.get(position).getSongTitle());
        holder.songYear.setText("Song Year: " + itemList.get(position).getSongYear());
        holder.songAuthor.setText("Song Author: " + itemList.get(position).getSongAuthor());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}