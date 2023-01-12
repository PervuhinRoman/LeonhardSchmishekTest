package com.pervuhin_roman.leonhard_schmishek_test;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class QuestionFragment extends Fragment {

    TextView counterField, questionField;
    Button buttonYes, buttonNo;

    ArrayList<String> questions = new ArrayList<>();
    int currentQuestion = 1;

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

    Rules rules = new Rules();

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        counterField = view.findViewById(R.id.counter);
        questionField = view.findViewById(R.id.question);
        buttonYes = view.findViewById(R.id.button_yes);
        buttonNo = view.findViewById(R.id.button_no);

        counterField.setText(currentQuestion + "/88");

        InputStream inputStream = getResources().openRawResource(R.raw.questions);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        String line = null;
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            questions.add(line);
        }

        questionField.setText(questions.get(currentQuestion - 1));

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                rules.checkAnswer(results, currentQuestion, "true");
                if (currentQuestion == 88) {
                    Toast.makeText(getContext(), "End!", Toast.LENGTH_SHORT).show();



                    Bundle args = new Bundle();
                    args.putSerializable("results", results);
                    ResultFragment resultFragment = new ResultFragment();
                    resultFragment.setArguments(args);
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, resultFragment)
                            .commit();
                } else {
                    // обработка ответа на текущий вопрос


                    // вывод следующего вопроса
                    currentQuestion++;
                    questionField.setText(questions.get(currentQuestion - 1));
                    counterField.setText(currentQuestion + "/88");
                }
            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                rules.checkAnswer(results, currentQuestion, "false");
                if (currentQuestion == 88) {
                    Toast.makeText(getContext(), "End!", Toast.LENGTH_SHORT).show();



                    Bundle args = new Bundle();
                    args.putSerializable("results", results);
                    ResultFragment resultFragment = new ResultFragment();
                    resultFragment.setArguments(args);
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, resultFragment)
                            .commit();
                } else {
                    // обработка ответа на текущий вопрос


                    // вывод следующего вопроса
                    currentQuestion++;
                    questionField.setText(questions.get(currentQuestion - 1));
                    counterField.setText(currentQuestion + "/88");
                }
            }
        });

        return view;
    }
}