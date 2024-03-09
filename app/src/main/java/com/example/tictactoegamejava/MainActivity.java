package com.example.tictactoegamejava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    int flag = 0;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init(); // Call init method to initialize buttons
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void check(View view) {
        String b1 = btn1.getText().toString();
        String b2 = btn2.getText().toString();
        String b3 = btn3.getText().toString();
        String b4 = btn4.getText().toString();
        String b5 = btn5.getText().toString();
        String b6 = btn6.getText().toString();
        String b7 = btn7.getText().toString();
        String b8 = btn8.getText().toString();
        String b9 = btn9.getText().toString();
        Button currentButton = (Button) view;
        counter++;
        if (flag == 0) {
            currentButton.setText("X");
            flag = 1;

        } else {
            currentButton.setText("0");
            flag = 0;
        }


        // Check for a win condition after the fifth move
        if (counter > 4) {
            if (!b1.isEmpty() && b1.equals(b2) && b2.equals(b3)) {
                announceWinner(b1);
            } else if (!b4.isEmpty() && b4.equals(b5) && b5.equals(b6)) {
                announceWinner(b4);
            } else if (!b7.isEmpty() && b7.equals(b8) && b8.equals(b9)) {
                announceWinner(b7);
            } else if (!b1.isEmpty() && b1.equals(b4) && b4.equals(b7)) {
                announceWinner(b1);
            } else if (!b2.isEmpty() && b2.equals(b5) && b5.equals(b8)) {
                announceWinner(b2);
            } else if (!b3.isEmpty() && b3.equals(b6) && b6.equals(b9)) {
                announceWinner(b3);
            } else if (!b1.isEmpty() && b1.equals(b5) && b5.equals(b9)) {
                announceWinner(b1);
            } else if (!b3.isEmpty() && b3.equals(b5) && b5.equals(b7)) {
                announceWinner(b3);
            }
        }

        // Check for a draw
        if (counter == 9) {
            announceDraw();
        }


    }


    private void announceWinner(String winner) {
        String text = "The winner is " + winner;
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        // Announce the winner (X or 0)
        // You can display a message, show a dialog, or perform any other action here
    }

    private void announceDraw() {
        // Announce draw
        // You can display a message, show a dialog, or perform any other action here
    }

}
