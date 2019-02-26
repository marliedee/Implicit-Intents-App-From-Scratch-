package org.pursuit.implicitintentsappfromscratch;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView sign;
    private TextView date;
    private Button button;
    private static final String ADDRESS = "https://www.astrology.com/horoscope/daily/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();

        sign = findViewById(R.id.zodiac_sign);
        imageView = findViewById(R.id.zodiac_image);
        date = findViewById(R.id.zodiac_date);
        button = findViewById(R.id.zodiac_button);


        final String nameZodiac = intent.getStringExtra("name");
        String dateZodiac = intent.getStringExtra("date");
        Picasso.get().load(intent.getStringExtra("image")).into(imageView);



        sign.setText(nameZodiac);
        date.setText(dateZodiac);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(ADDRESS+ nameZodiac + ".html");
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent2);
            }
        });
    }
}
