package ru.mirea.aslanyan.mireaproject.ui.history;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import ru.mirea.aslanyan.mireaproject.R;

public class MyAdapter extends RecyclerView.Adapter<viewHolder> {

    Context c;
    List<String> mdata;

    public MyAdapter(Context c, List<String> mdata) {
        this.c = c;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.list_item, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.txtName.setText(mdata.get(position));
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }
}