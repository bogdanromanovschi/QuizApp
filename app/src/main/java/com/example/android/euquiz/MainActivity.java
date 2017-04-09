package com.example.android.euquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //static final String Current_Score = "stored_score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }


    /**
     * This method calculates the total score by evaluating each individual question.
     * It displays a toast with the final score and a message to the participant.
     */
    public void getScore (View view) {
        int score=0;
        boolean checkAllOptions = true;
        // Evaluate question 1
        RadioGroup question1RadioGroup = (RadioGroup) findViewById(R.id.q1_radiogroup);
        if (question1RadioGroup.getCheckedRadioButtonId() == R.id.eu28_radio_button) {
            score += 1;
        }
        // Evaluate question 2
        EditText question2Text = (EditText) findViewById(R.id.q2_answer);
        String question2Answer = question2Text.getText().toString().trim().toUpperCase();
        if (question2Answer.equals("CROATIA") ) {
            score += 1;
        }
        // Evaluate question 3
        checkAllOptions = true;
        CheckBox question3option1 = (CheckBox) findViewById(R.id.q3_option1);
        if (!question3option1.isChecked()) {checkAllOptions = false;}
        CheckBox question3option2 = (CheckBox) findViewById(R.id.q3_option2);
        if (!question3option2.isChecked()) {checkAllOptions = false;}
        CheckBox question3option3 = (CheckBox) findViewById(R.id.q3_option3);
        if (!question3option3.isChecked()) {checkAllOptions = false;}
        CheckBox question3option4 = (CheckBox) findViewById(R.id.q3_option4);
        if (!question3option4.isChecked()) {checkAllOptions = false;}
        if (checkAllOptions) {
            score +=1;
        }
        // Evaluate question 4
        RadioGroup question4RadioGroup = (RadioGroup) findViewById(R.id.q4_radiogroup);
        if (question4RadioGroup.getCheckedRadioButtonId() == R.id.q4_3_button) {
            score += 1;
        }
        // Evaluate question 5
        RadioGroup question5RadioGroup = (RadioGroup) findViewById(R.id.q5_radio_group);
        if (question5RadioGroup.getCheckedRadioButtonId() == R.id.q5_2_button) {
            score += 1;
        }
        // Evaluate question 6
        checkAllOptions = true;
        CheckBox question6option1 = (CheckBox) findViewById(R.id.q6_option1);
        if (question6option1.isChecked()) {checkAllOptions = false;}
        CheckBox question6option2 = (CheckBox) findViewById(R.id.q6_option2);
        if (!question6option2.isChecked()) {checkAllOptions = false;}
        CheckBox question6option3 = (CheckBox) findViewById(R.id.q6_option3);
        if (!question6option3.isChecked()) {checkAllOptions = false;}
        CheckBox question6option4 = (CheckBox) findViewById(R.id.q6_option4);
        if (question6option4.isChecked()) {checkAllOptions = false;}
        if (checkAllOptions) {
            score +=1;
        }
        // Evaluate question 7
        checkAllOptions = true;
        CheckBox question7option1 = (CheckBox) findViewById(R.id.q7_option1);
        if (!question7option1.isChecked()) {checkAllOptions = false;}
        CheckBox question7option2 = (CheckBox) findViewById(R.id.q7_option2);
        if (!question7option2.isChecked()) {checkAllOptions = false;}
        CheckBox question7option3 = (CheckBox) findViewById(R.id.q7_option3);
        if (!question7option3.isChecked()) {checkAllOptions = false;}
        CheckBox question7option4 = (CheckBox) findViewById(R.id.q7_option4);
        if (!question7option4.isChecked()) {checkAllOptions = false;}
        if (checkAllOptions) {
            score +=1;
        }
        //Prepare the text for the Toast message
        // (A) Prepare the message to include the name provided by the participant and punctuation
        // or in case no name was provided, include punctuation only.
        String userName;
        EditText providedName = (EditText) findViewById(R.id.participant_name);
        userName = providedName.getText().toString().trim();
        if (!userName.equals("") ) {
            userName =", "+ userName + "!";
        } else {userName = "!";}
        // (B) Define the messages for each score range
        String scoreMessage ="";
        if (score == 7) {
            scoreMessage = getString(R.string.sevenanswers, userName);
        } else {
            if (score>=5) {
                scoreMessage = getString(R.string.fiveanswers, userName, score);
            } else {
                if (score >= 2) {
                    scoreMessage = getString(R.string.twoanswers, userName, score);
                                    } else {
                    if (score==1) {
                        scoreMessage = getString(R.string.oneanswer, userName);
                    } else {
                        scoreMessage = getString(R.string.noanswer, userName);
                    }
                }
            }
        }
        // (C) Display the Toast
        Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();

        //  Debugging code lines
        //        Log.i("Main activity", "Current score is " + score);
        //        Log.i("Main activity", "User name is " + userName);
        //        Log.i("Main activity", "User message is " + scoreMessage);
    }

    public void showAnswers (View view) {
        RadioGroup question1RadioGroup = (RadioGroup) findViewById(R.id.q1_radiogroup);
        question1RadioGroup.check(R.id.eu28_radio_button);
        EditText question2Text = (EditText) findViewById(R.id.q2_answer);
        question2Text.setText("Croatia");
        CheckBox question3option1 = (CheckBox) findViewById(R.id.q3_option1);
        question3option1.setChecked(true);
        CheckBox question3option2 = (CheckBox) findViewById(R.id.q3_option2);
        question3option2.setChecked(true);
        CheckBox question3option3 = (CheckBox) findViewById(R.id.q3_option3);
        question3option3.setChecked(true);
        CheckBox question3option4 = (CheckBox) findViewById(R.id.q3_option4);
        question3option4.setChecked(true);
        RadioGroup question4RadioGroup = (RadioGroup) findViewById(R.id.q4_radiogroup);
        question4RadioGroup.check(R.id.q4_3_button);
        RadioGroup question5RadioGroup = (RadioGroup) findViewById(R.id.q5_radio_group);
        question5RadioGroup.check(R.id.q5_2_button);
        CheckBox question6option1 = (CheckBox) findViewById(R.id.q6_option1);
        question6option1.setChecked(false);
        CheckBox question6option2 = (CheckBox) findViewById(R.id.q6_option2);
        question6option2.setChecked(true);
        CheckBox question6option3 = (CheckBox) findViewById(R.id.q6_option3);
        question6option3.setChecked(true);
        CheckBox question6option4 = (CheckBox) findViewById(R.id.q6_option4);
        question6option4.setChecked(false);
        CheckBox question7option1 = (CheckBox) findViewById(R.id.q7_option1);
        question7option1.setChecked(true);
        CheckBox question7option2 = (CheckBox) findViewById(R.id.q7_option2);
        question7option2.setChecked(true);
        CheckBox question7option3 = (CheckBox) findViewById(R.id.q7_option3);
        question7option3.setChecked(true);
        CheckBox question7option4 = (CheckBox) findViewById(R.id.q7_option4);
        question7option4.setChecked(true);
    }

    public void resetForm (View view) {
        RadioGroup question1RadioGroup = (RadioGroup) findViewById(R.id.q1_radiogroup);
        question1RadioGroup.clearCheck();
        EditText question2Text = (EditText) findViewById(R.id.q2_answer);
        question2Text.setText("");
        CheckBox question3option1 = (CheckBox) findViewById(R.id.q3_option1);
        question3option1.setChecked(false);
        CheckBox question3option2 = (CheckBox) findViewById(R.id.q3_option2);
        question3option2.setChecked(false);
        CheckBox question3option3 = (CheckBox) findViewById(R.id.q3_option3);
        question3option3.setChecked(false);
        CheckBox question3option4 = (CheckBox) findViewById(R.id.q3_option4);
        question3option4.setChecked(false);
        RadioGroup question4RadioGroup = (RadioGroup) findViewById(R.id.q4_radiogroup);
        question4RadioGroup.clearCheck();
        RadioGroup question5RadioGroup = (RadioGroup) findViewById(R.id.q5_radio_group);
        question5RadioGroup.clearCheck();
        CheckBox question6option1 = (CheckBox) findViewById(R.id.q6_option1);
        question6option1.setChecked(false);
        CheckBox question6option2 = (CheckBox) findViewById(R.id.q6_option2);
        question6option2.setChecked(false);
        CheckBox question6option3 = (CheckBox) findViewById(R.id.q6_option3);
        question6option3.setChecked(false);
        CheckBox question6option4 = (CheckBox) findViewById(R.id.q6_option4);
        question6option4.setChecked(false);
        CheckBox question7option1 = (CheckBox) findViewById(R.id.q7_option1);
        question7option1.setChecked(false);
        CheckBox question7option2 = (CheckBox) findViewById(R.id.q7_option2);
        question7option2.setChecked(false);
        CheckBox question7option3 = (CheckBox) findViewById(R.id.q7_option3);
        question7option3.setChecked(false);
        CheckBox question7option4 = (CheckBox) findViewById(R.id.q7_option4);
        question7option4.setChecked(false);
    }

}
