package com.example.movieandroidapplication.ui;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movieandroidapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg, MovieCoverImg;
    private TextView tv_title, tv_description;
    private FloatingActionButton play_fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        //initiate views
        iniViews();



    }

    void iniViews(){
        //get the data
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imageCover = getIntent().getExtras().getInt("imgCover");

        play_fab = findViewById(R.id.play_fab);

        MovieThumbnailImg = findViewById(R.id.movie_detail_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);

        MovieThumbnailImg.setImageResource(imageResourceId);

        MovieCoverImg = findViewById(R.id.movie_detail_cover);
        Glide.with(this).load(imageCover).into(MovieCoverImg);

        tv_title = findViewById(R.id.movie_detail_title);
        tv_title.setText(movieTitle);
        setTitle(movieTitle);

        tv_description = findViewById(R.id.movie_detail_desc);
        
        //setup animation
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        play_fab.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
    }
}