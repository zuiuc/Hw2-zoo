package com.qi_zhao.hw2_zoo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class AnimalArrayAdaptor extends ArrayAdapter<Animal> {
    private final List<Animal> animals;

    public AnimalArrayAdaptor(Context context, int resource, List<Animal> animals) {
        super(context, resource, animals);
        this.animals = animals;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_row, null);

        TextView textView = (TextView) row.findViewById(R.id.label);
        textView.setText(animals.get(position).getName());

        try {
            ImageView imageView = (ImageView) row.findViewById(R.id.icon);
            Drawable filename = animals.get(position).getFilename();

            ContextCompat.getDrawable(context, R.drawable.filename);
            imageView.setImageResource(filename);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return row;
    }
}
