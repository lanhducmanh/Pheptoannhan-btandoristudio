package com.example.baiandroi;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần
        EditText inputNumber1 = findViewById(R.id.inputNumber1);
        EditText inputNumber2 = findViewById(R.id.inputNumber2);
        Button calculateButton = findViewById(R.id.calculateButton);
        TextView resultText = findViewById(R.id.resultText);

        // Xử lý sự kiện
        calculateButton.setOnClickListener(v -> {
            String number1Str = inputNumber1.getText().toString().trim();
            String number2Str = inputNumber2.getText().toString().trim();

            if (!number1Str.isEmpty() && !number2Str.isEmpty()) {
                try {
                    int number1 = Integer.parseInt(number1Str);
                    int number2 = Integer.parseInt(number2Str);
                    int result = number1 * number2;

                    resultText.setText(getString(R.string.result_text, result));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, R.string.enter_valid_number, Toast.LENGTH_SHORT).show();
                    resultText.setText(R.string.error_invalid_input);
                }
            } else {
                Toast.makeText(MainActivity.this, R.string.enter_two_numbers, Toast.LENGTH_SHORT).show();
                resultText.setText(R.string.error_missing_numbers);
            }
        });
    }
}
