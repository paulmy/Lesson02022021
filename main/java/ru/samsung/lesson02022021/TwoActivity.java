package ru.samsung.lesson02022021;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class TwoActivity extends Activity {
    final String[] catNamesArray = new String[]{"Рыжик", "Барсик", "Мурзик", "Мурка", "Васька", "Томасина", "Бобик", "Кристина", "Пушок", "Дымка", "Кузя", "Китти", "Барбос", "Масяня", "Симба"};
    TextView textView1;
    EditText inputword;
    Button btnsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twoactivity_main);
        textView1 = findViewById(R.id.textview1);
        inputword = findViewById(R.id.inputword);
        btnsearch = findViewById(R.id.btnsearch);

        //textView1.setText(OutputCat(catNamesArray));
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("");
                try {
                    String inputs = inputword.getText().toString();
                    List<String> words = searchFromStart(catNamesArray, inputs);
                    for (String w : words)
                        textView1.append(w + "\n");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Пустое поле ввода", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    public static ArrayList<String> searchFromStart(String[] inputArray, String searchText) {
        ArrayList<String> outputArray = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (searchText.compareToIgnoreCase(inputArray[i]
                    .substring(0, searchText.length())) == 0) {
                outputArray.add(inputArray[i]);
            }
        }
        return outputArray;
    }

    String OutputCat(String[] cat) {
        String res = "";
        for (String s : cat) {
            res = res + s + "\n";
        }
        return res;
    }
}
