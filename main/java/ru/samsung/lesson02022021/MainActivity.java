package ru.samsung.lesson02022021;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button, buttonsort, buttondel, buttonsearch, buttonnext;
    TextView textView;
    String[] s = new String[10];
    int[] a = new int[10];
    Integer[] a1 = new Integer[10];
    ArrayList<Person> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.buttonadd);
        buttonsort = findViewById(R.id.buttonsort);
        buttondel = findViewById(R.id.buttondel);
        buttonsearch = findViewById(R.id.buttonsearch);
        buttonnext = findViewById(R.id.buttonnext);
        textView = findViewById(R.id.textview);

        list.add(new Person());

        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateMassiv(a1);

                textView.setText(editText.getText().toString());
                /*try {
                    String[] user = editText.getText().toString().split(" ");
                    list.add(new Person(user[0], Integer.parseInt(user[1]), user[2]));
                    editText.setText("");
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Пустое поле ввода",Toast.LENGTH_SHORT).show();
                }*/
                outputMas(a1);
                //textView.setText("");
                // outputList();

            }
        });
        buttonsort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Arrays.sort(a1, new LastDigitComp());
                Arrays.sort(a1);
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
                outputList();

            }
        });
        buttonsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int k = Integer.parseInt(editText.getText().toString());
                    Arrays.sort(a1);
                    int ind = Arrays.binarySearch(a1, k);
                    textView.setText("Индекс элемента равен " + ind);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Пустое поле ввода", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    void outputList(List list) {

        for (int i = 0; i < list.size(); i++) {
            textView.append(list.get(i) + " " + i + "\n");
        }
    }
    void outputList() {
        for (int i = 0; i < list.size(); i++) {
            textView.append(list.get(i) + " " + i + "\n");
        }
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

    void outputMas(Integer[] a) {
        for (int str : a) {
            textView.append(" " + str);
        }
    }
    void outputMas(String[] a) {
        for (String str : a) {
            textView.append(str+"\n");
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