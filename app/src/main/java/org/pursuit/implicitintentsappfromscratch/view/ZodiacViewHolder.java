package org.pursuit.implicitintentsappfromscratch.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.implicitintentsappfromscratch.DisplayActivity;
import org.pursuit.implicitintentsappfromscratch.R;
import org.pursuit.implicitintentsappfromscratch.model.Zodiacs;

public class ZodiacViewHolder extends RecyclerView.ViewHolder {
    TextView zodiacNameTextView;
    TextView zodiacDateTextView;

    public ZodiacViewHolder(@NonNull View itemView) {
        super(itemView);
        zodiacNameTextView = itemView.findViewById(R.id.name_text_view);
        zodiacDateTextView = itemView.findViewById(R.id.date_text_view);
    }

    public void onBind(final Zodiacs zodiacs){
        zodiacNameTextView.setText(zodiacs.getName());
        zodiacDateTextView.setText(zodiacs.getNumber());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (itemView.getContext(), DisplayActivity.class);
                intent.putExtra("name", zodiacs.getName());
                intent.putExtra("date",zodiacs.getNumber());
                intent.putExtra("image", zodiacs.getImage());
                itemView.getContext().startActivity(intent);
            }
        });
    }
}
