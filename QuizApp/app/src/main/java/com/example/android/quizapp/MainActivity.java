package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.IInterface;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This stores the code for what happens when the user clicks the button for their quiz results, beginning with storing the answers, calculating them through the calculateScore method, and then displaying the final score as a Toast. Toasts are conditional based on the score achieved.
     *
     * @param view
     */
    public void getResults(View view) {

        //These are the stored booleans for radio button questions 1, 3, and 4
        RadioButton radioButtonCorrectAnswer1 = (RadioButton) findViewById(R.id.radiobutton_correct_1);
        boolean correctAnswerRadioButton1 = radioButtonCorrectAnswer1.isChecked();

        RadioButton radioButtonCorrectAnswer3 = (RadioButton) findViewById(R.id.radiobutton_correct_3);
        boolean correctAnswerRadioButton3 = radioButtonCorrectAnswer3.isChecked();

        RadioButton radioButtonCorrectAnswer4 = (RadioButton) findViewById(R.id.radiobutton_correct_4);
        boolean correctAnswerRadioButton4 = radioButtonCorrectAnswer4.isChecked();

        //This stores the user's entry in question 5
        EditText editTextAnswer5 = (EditText) findViewById(R.id.editText_answer_5);
        String usersTextAnswer5 = editTextAnswer5.getText().toString();

        //Correct and wrong answer variables for question 2
        CheckBox checkCorrectAnswer2a = (CheckBox) findViewById(R.id.check_correct_2a);
        boolean correctAnswerCheck2a = checkCorrectAnswer2a.isChecked();

        CheckBox checkCorrectAnswer2b = (CheckBox) findViewById(R.id.check_correct_2b);
        boolean correctAnswerCheck2b = checkCorrectAnswer2b.isChecked();

        CheckBox checkCorrectAnswer2c = (CheckBox) findViewById(R.id.check_correct_2c);
        boolean correctAnswerCheck2c = checkCorrectAnswer2c.isChecked();

        CheckBox checkIncorrectAnswer2a = (CheckBox) findViewById(R.id.check_incorrect_2a);
        boolean incorrectAnswerCheck2a = checkIncorrectAnswer2a.isChecked();

        CheckBox checkIncorrectAnswer2b = (CheckBox) findViewById(R.id.check_incorrect_2b);
        boolean incorrectAnswerCheck2b = checkIncorrectAnswer2b.isChecked();

        //Correct and wrong answer variables for question 6
        CheckBox checkCorrectAnswer6a = (CheckBox) findViewById(R.id.check_correct_6a);
        boolean correctAnswerCheck6a = checkCorrectAnswer6a.isChecked();

        CheckBox checkCorrectAnswer6b = (CheckBox) findViewById(R.id.check_correct_6b);
        boolean correctAnswerCheck6b = checkCorrectAnswer6b.isChecked();

        CheckBox checkIncorrectAnswer6a = (CheckBox) findViewById(R.id.check_incorrect_6a);
        boolean incorrectAnswerCheck6a = checkIncorrectAnswer6a.isChecked();

        CheckBox checkIncorrectAnswer6b = (CheckBox) findViewById(R.id.check_incorrect_6b);
        boolean incorrectAnswerCheck6b = checkIncorrectAnswer6b.isChecked();

        CheckBox checkIncorrectAnswer6c = (CheckBox) findViewById(R.id.check_incorrect_6c);
        boolean incorrectAnswerCheck6c = checkIncorrectAnswer6c.isChecked();

        //This references the calculateScore method and stores the total
        int score = calculateScore(correctAnswerRadioButton1, correctAnswerCheck2a, incorrectAnswerCheck2a, correctAnswerCheck2b, incorrectAnswerCheck2b, correctAnswerCheck2c, correctAnswerRadioButton3, correctAnswerRadioButton4, usersTextAnswer5, correctAnswerCheck6a, incorrectAnswerCheck6a, correctAnswerCheck6b, incorrectAnswerCheck6b, incorrectAnswerCheck6c);

        //These are the toasts that gives the user their final score based on the total score
        if (score == 6) {
            Toast.makeText(this, "Your final score is " + score + " out of 6. You're a true Hololive fan!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (score == 5) {
            Toast.makeText(this, "Your final score is " + score + " out of 6. You almost got this!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Your final score is " + score + " out of 6. Go watch some more Hololive!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method calculates the user's score using the answer key below:
     *
     * @param correctAnswerRadioButton1  is Cover Corp, radio button
     * @param correctAnswerCheck2a is Inugami Korone, checkbox
     * @param incorrectAnswerCheck2a   is Tsukino Mito, checkbox
     * @param correctAnswerCheck2b is Sakura Miko, checkbox
     * @param incorrectAnswerCheck2b   is Hanabatake Chaika, checkbox
     * @param correctAnswerCheck2c is Uruha Rushia, checkbox
     * @param correctAnswerRadioButton3  is Deadbeats, radio button
     * @param correctAnswerRadioButton4  is Seiso, radio button
     * @param userTextAnswer5     is Amelia Watson, EditText, String
     * @param correctAnswerCheck6a is YouTube, checkbox
     * @param incorrectAnswerCheck6a   is Nico Nico Douga, checkbox
     * @param correctAnswerCheck6b is Bilibili, checkbox
     * @param incorrectAnswerCheck6b   is Twitch, checkbox
     * @param incorrectAnswerCheck6c   is DLive, checkbox
     * @return
     */
    private int calculateScore(boolean correctAnswerRadioButton1, boolean correctAnswerCheck2a,
                               boolean incorrectAnswerCheck2a, boolean correctAnswerCheck2b, boolean incorrectAnswerCheck2b,
                               boolean correctAnswerCheck2c, boolean correctAnswerRadioButton3, boolean correctAnswerRadioButton4, String userTextAnswer5,
                               boolean correctAnswerCheck6a, boolean incorrectAnswerCheck6a, boolean correctAnswerCheck6b,
                               boolean incorrectAnswerCheck6b, boolean incorrectAnswerCheck6c) {
        int score = 0;

        if (correctAnswerRadioButton1) {
            score = score + 1;
        }

        if (correctAnswerCheck2a && correctAnswerCheck2b && correctAnswerCheck2c && !incorrectAnswerCheck2a && !incorrectAnswerCheck2b) {
            score = score + 1;
        }

        if (correctAnswerRadioButton3) {
            score = score + 1;
        }

        if (correctAnswerRadioButton4) {
            score = score + 1;
        }

        

        if (userTextAnswer5.compareTo("Amelia Watson") == 0) {
            score = score + 1;
        }

        if (correctAnswerCheck6a && correctAnswerCheck6b && !incorrectAnswerCheck6a && !incorrectAnswerCheck6b && !incorrectAnswerCheck6c) {
            score = score + 1;
        }
        return score;
    }
}