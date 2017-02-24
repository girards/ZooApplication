package edu.csulb.android.zooapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.csulb.android.zooapplication.R;
import edu.csulb.android.zooapplication.objects.Animal;

/**
 * Created by nicolasgirardot on 2/23/17.
 */

public class AnimalListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<Animal> mAnimals;
    private LayoutInflater mInflater;

    public AnimalListViewAdapter(Context context, List<Animal> animals) {
        this.mContext = context;
        this.mAnimals = animals;
        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return mAnimals.size();
    }

    @Override
    public Animal getItem(int position) {
        return mAnimals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View rowView = mInflater.inflate(R.layout.animal_element_view, parent, false);
        Animal currentAnimal = getItem(position);


        TextView animalNameTextView = (TextView) rowView.findViewById(R.id.animal_name);
        ImageView animalPictureView= (ImageView) rowView.findViewById(R.id.animal_picture);

        animalNameTextView.setText(currentAnimal.getName());
        animalPictureView.setImageResource(currentAnimal.getDrawableId());
        return rowView;
    }
}
