package com.pervuhin_roman.leonhard_schmishek_test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResultFragment extends Fragment {

    TextView resultsField;

    HashMap<String, Integer> results = new HashMap<>() {{
        put("Гипертимность", 0);
        put("Дистимность", 0);
        put("Циклотимность", 0);
        put("Возбудимость", 0);
        put("Застревание", 0);
        put("Эмотивность", 0);
        put("Экзальтированность", 0);
        put("Тревожность", 0);
        put("Педантичность", 0);
        put("Демонстративность", 0);
    }};

    String resultsLine = "";

    public ResultFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        results = (HashMap<String, Integer>) getArguments().getSerializable("results");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        resultsField = view.findViewById(R.id.results);

        ArrayList<HashMap.Entry> entries = new ArrayList<>(results.entrySet());
        for (HashMap.Entry entry : entries) {
            resultsLine+=(entry.getKey() + ": " + entry.getValue() + "\n");
        }

        resultsField.setText(resultsLine);

        return view;
    }
}