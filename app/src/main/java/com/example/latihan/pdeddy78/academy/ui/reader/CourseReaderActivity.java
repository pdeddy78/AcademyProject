package com.example.latihan.pdeddy78.academy.ui.reader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.latihan.pdeddy78.academy.R;

public class CourseReaderActivity extends AppCompatActivity {

    public static final String EXTRA_COURSE_ID = "extra_course_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_reader);
    }
}
