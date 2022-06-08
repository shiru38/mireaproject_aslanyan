package ru.mirea.aslanyan.mireaproject.ui.history;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.mirea.aslanyan.mireaproject.R;

public class viewHolder extends RecyclerView.ViewHolder {

    TextView txtName;

    public viewHolder(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.text);
    }
}