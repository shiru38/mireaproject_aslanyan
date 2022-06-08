package ru.mirea.aslanyan.mireaproject.ui.player;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import ru.mirea.aslanyan.mireaproject.R;

public class playerFragment extends Fragment {

    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ConstraintLayout ll = (ConstraintLayout)inflater.inflate(R.layout.fragment_music_player, container, false);

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.music);

        Button playButton = (Button) ll.findViewById(R.id.button); // Start music
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        Button pauseButton = (Button) ll.findViewById(R.id.button2); // Pause music
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
        return ll;
    }
}
