package edu.csulb.android.zooapplication.objects;

import java.io.Serializable;

/**
 * Created by nicolasgirardot on 2/23/17.
 */

public class Animal implements Serializable{
    int mDrawableId;
    String mName;
    String mDescription;

    public Animal(int drawableId, String name, String descrption) {
        this.mDrawableId = drawableId;
        this.mName = name;
        this.mDescription = descrption;
    }

    public int getDrawableId() {
        return mDrawableId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }
}
