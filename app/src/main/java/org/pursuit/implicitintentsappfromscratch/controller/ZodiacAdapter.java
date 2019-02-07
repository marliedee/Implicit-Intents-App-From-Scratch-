package org.pursuit.implicitintentsappfromscratch.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.implicitintentsappfromscratch.R;
import org.pursuit.implicitintentsappfromscratch.model.ZodiacOuter;
import org.pursuit.implicitintentsappfromscratch.model.Zodiacs;
import org.pursuit.implicitintentsappfromscratch.view.ZodiacViewHolder;

import java.util.List;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacViewHolder> {

    public ZodiacAdapter(List<Zodiacs> zodiacsList) {
        this.zodiacsList = zodiacsList;
    }

    private List<Zodiacs> zodiacsList;


    @Override
    public ZodiacViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zodiac_item_view, viewGroup, false);
        return new ZodiacViewHolder(childView);       }


    @Override
    public void onBindViewHolder(@NonNull ZodiacViewHolder zodiacViewHolder, int i) {

        zodiacViewHolder.onBind(zodiacsList.get(i));

    }

    @Override
    public int getItemCount() {
        return zodiacsList.size();
    }
}
