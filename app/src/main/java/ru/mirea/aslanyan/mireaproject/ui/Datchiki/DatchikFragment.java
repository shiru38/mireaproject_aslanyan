package ru.mirea.aslanyan.mireaproject.ui.Datchiki;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.mirea.aslanyan.mireaproject.R;

public class DatchikFragment extends Fragment implements SensorEventListener{
    private Activity mActivity;
    private TextView geomagneticTextView;
    private TextView gameRotationTextView;
    private TextView gravityTextView;
    private SensorManager sensorManager;
    private Sensor gameRotation;
    private Sensor gravity;
    private Sensor geomagnetic;

    public DatchikFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorManager = (SensorManager) this.getActivity().getSystemService(Context.SENSOR_SERVICE);

        gameRotation =  sensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);
        gravity =  sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        geomagnetic = sensorManager.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_datchik, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gameRotationTextView = getView().findViewById(R.id.gameRotationTextView);
        gravityTextView = getView().findViewById(R.id.gravityTextView);
        geomagneticTextView = getView().findViewById(R.id.geomagneticTextView);

        sensorManager.registerListener(this, geomagnetic,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gameRotation,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gravity,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR){
            float valueLight = event.values[0];
            geomagneticTextView.setText("Geomagnetic is: "+ valueLight);
        }
        if (event.sensor.getType() == Sensor.TYPE_GAME_ROTATION_VECTOR){
            float valueRotation = event.values[0];
            gameRotationTextView.setText("Game rotation: " + valueRotation);
        }
        if (event.sensor.getType() == Sensor.TYPE_GRAVITY){
            float valueGravity = event.values[0];
            gravityTextView.setText("Gravity: "+ valueGravity);
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}