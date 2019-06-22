package com.brighteststar.asiftamal.csharpaspnetinterviewquestion;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brighteststar.asiftamal.csharpaspnetinterviewquestion.models.CategoryTitle;
import com.brighteststar.asiftamal.csharpaspnetinterviewquestion.models.interviewquestion;

public class DrawerItemCustomAdapter extends ArrayAdapter<CategoryTitle> {

    public DrawerItemCustomAdapter(Context mContext, int layoutResourceId, CategoryTitle[] categoryTitles) {
        super(mContext, layoutResourceId, categoryTitles);
        this.mContext = mContext;
        this.layoutResourceId = layoutResourceId;
        this.categoryTitles = categoryTitles;
    }

    Context mContext;
    int layoutResourceId;
    CategoryTitle categoryTitles[] = null;


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);

        CategoryTitle folder = categoryTitles[position];


        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);

        return listItem;
    }


}
