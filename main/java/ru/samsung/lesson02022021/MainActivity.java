package ru.samsung.lesson02022021;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button, buttonsort, buttondel;
    TextView textView;
    String[] s = new String[10];
    int[] a = new int[10];
    Integer[] a1 = new Integer[10];
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.buttonadd);
        buttonsort = findViewById(R.id.buttonsort);
        buttondel = findViewById(R.id.buttondel);
        textView = findViewById(R.id.textview);
        list.add("dfgdfhg");



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // CreateMassiv(a1);

                // textView.setText(editText.getText().toString());
                list.add(editText.getText().toString());
                textView.setText("");
               /* for (Object a : list) {
                    textView.append(a + " " + list.indexOf(a) + "\n");
                }*/
                for (int i = 0; i < list.size(); i++) {
                    textView.append(list.get(i) + " " + i + "\n");
                }


            }
        });
        buttonsort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(a1, new LastDigitComp());
                textView.append("\nSort\n");
                for (int str : a1) {
                    textView.append(" " + str);
                }
            }
        });
        buttondel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                if (list.contains(s) && list.size() > 0 && list.indexOf(s) > -1) {
                    list.remove(s);
                } else {
                    int i = Integer.parseInt(s);
                    list.remove(i);
                }
                textView.setText("");
                for (int i = 0; i < list.size(); i++) {
                    textView.append(list.get(i) + " " + i + "\n");
                }

            }
        });

    }

    void CreateMassiv(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
        }

    }

    void CreateMassiv(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
        }

    }

    void outputMas(int[] a) {
        for (int str : a) {
            textView.append(" " + str);
        }
    }
}

class LastDigitComp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {

        if (o1 % 10 < o2 % 10)
            return -1;
        else if (o1 % 10 > o2 % 10)
            return 1;
        else
            return 0;
    }
}