package ru.mirea.aslanyan.mireaproject.ui.history;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.getbase.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import ru.mirea.aslanyan.mireaproject.R;

public class historyFragment extends Fragment {

    RecyclerView rv;
    String strCatName;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout ll = (LinearLayout)inflater.inflate(R.layout.fragment_stories, null);
        FloatingActionButton fab1 = ll.findViewById(R.id.fab_action1);

        final EditText editText = ll.findViewById(R.id.editText);

        rv = ll.findViewById(R.id.rv);
        List<String> name = new ArrayList<>();

        editText.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View view, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    strCatName = editText.getText().toString();
                    return true;
                }
                return false;
            }
        });
        ((FloatingActionButton)ll.findViewById(R.id.fab_action1)).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                if(editText.getText().toString().length() != 0)
                {
                    name.add(strCatName);
                }
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                MyAdapter adapter = new MyAdapter(getActivity(),name);
                rv.setAdapter(adapter);
            }
        });

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyAdapter adapter = new MyAdapter(getActivity(),name);
        rv.setAdapter(adapter);
        return ll;
    }
}