package com.awesome.rajdroid.quiztech;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            // Handle the about action
        }  else if (id == R.id.nav_share) {

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * The number of correct answers
     */
    int score = 0;

    /**
     * This method is called when the end test button is clicked.
     */
    public void end_Test(View view) {

        //Called question checking methods
        question_1();
        question_2();
        question_3();
        question_4();
        question_5();
        question_6();
        question_7();
        question_8();
        question_9();
        question_10();

        // Display the test result on the screen
        String test_result = createTestResult(score);
        displayResult(test_result);

        // Disabled "End Test" button after clicking on it.
        Button endTestButton = findViewById(R.id.end_test_button);
        endTestButton.setEnabled(false);
    }

    /**
     * Create summary of the test result.
     *
     * @param score of the counting of right answers
     * @return text of the test result
     */
    private String createTestResult(int score) {
        String test_result= getString(R.string.test_result_score) + score;
        return test_result;
    }

    /**
     * This method counter correct answers in question 1
     */
    private void question_1() {
        RadioGroup answers = findViewById(R.id.question_1);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.answer_1_3_rb:
                findViewById(R.id.answer_1_3_rb);
                increment_score();
                break;
            default:
                findViewById(R.id.answer_1_1_rb);
                findViewById(R.id.answer_1_2_rb);
                findViewById(R.id.answer_1_4_rb);
        }
        this.onDestroy();
    }

    private void question_2() {
        RadioGroup answers = findViewById(R.id.question_2);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.answer_2_2_rb:
                findViewById(R.id.answer_2_2_rb);
                increment_score();
                break;
            default:
                findViewById(R.id.answer_2_1_rb);
                findViewById(R.id.answer_2_3_rb);
                findViewById(R.id.answer_2_4_rb);
        }
    }

    private void question_3() {
        RadioGroup answers = findViewById(R.id.question_3);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.answer_3_1_rb:
                findViewById(R.id.answer_3_1_rb);
                increment_score();
                break;
            default:
                findViewById(R.id.answer_3_2_rb);
                findViewById(R.id.answer_3_3_rb);
                findViewById(R.id.answer_3_4_rb);
        }
    }

    private void question_4() {
        RadioGroup answers = findViewById(R.id.question_4);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.answer_4_2_rb:
                findViewById(R.id.answer_4_2_rb);
                increment_score();
                break;
            default:
                findViewById(R.id.answer_4_1_rb);
                findViewById(R.id.answer_4_3_rb);
                findViewById(R.id.answer_4_4_rb);
        }
    }

    private void question_5() {
        RadioGroup answers = findViewById(R.id.question_5);
        switch (answers.getCheckedRadioButtonId()) {
            case R.id.answer_5_4_rb:
                findViewById(R.id.answer_5_4_rb);
                increment_score();
                break;
            default:
                findViewById(R.id.answer_5_1_rb);
                findViewById(R.id.answer_5_2_rb);
                findViewById(R.id.answer_5_3_rb);
        }
    }

    public void question_6() {
        // Figure out if the user chose "Mouse" answer
        CheckBox MouseCheckBox = findViewById(R.id.mouse_checkbox);
        boolean hasMouse = MouseCheckBox.isChecked();

        // Figure out if the user chose "Keyboard" answer
        CheckBox KeyboardCheckBox = findViewById(R.id.keyboard_checkbox);
        boolean hasKeyboard = KeyboardCheckBox.isChecked();

        // Figure out if the user chose "Monitor" answer
        CheckBox MonitorCheckBox = findViewById(R.id.monitor_checkbox);
        boolean hasMonitor = MonitorCheckBox.isChecked();

        // Figure out if the user chose "Joystick" answer
        CheckBox JoystickCheckBox = findViewById(R.id.joystick_checkbox);
        boolean hasJoystick = JoystickCheckBox.isChecked();

        if (hasMouse && hasKeyboard && !hasMonitor && hasJoystick){
            increment_score();
        }
    }

    public void question_7() {
        // Figure out if the user chose "GoogleChrome" answer
        CheckBox GoogleChromeCheckBox = findViewById(R.id.google_chrome_checkbox);
        boolean hasGoogleChrome = GoogleChromeCheckBox.isChecked();

        // Figure out if the user chose "Windows" answer
        CheckBox WindowsCheckBox = findViewById(R.id.windows_checkbox);
        boolean hasWindows = WindowsCheckBox.isChecked();

        // Figure out if the user chose "MozillaFirefox" answer
        CheckBox MozillaFirefoxCheckBox = findViewById(R.id.mozilla_firefox_checkbox);
        boolean hasMozillaFirefox = MozillaFirefoxCheckBox.isChecked();

        // Figure out if the user chose "Yahoo" answer
        CheckBox YahooCheckBox = findViewById(R.id.yahoo_checkbox);
        boolean hasYahoo = YahooCheckBox.isChecked();

        if (hasGoogleChrome && !hasWindows && hasMozillaFirefox && hasYahoo) {
                    increment_score();
        }
    }

    public void question_8() {
        // Figure out if the user chose "Pixel" answer
        CheckBox PixelCheckBox = findViewById(R.id.pixel_checkbox);
        boolean hasPixel = PixelCheckBox.isChecked();

        // Figure out if the user chose "Duo" answer
        CheckBox DuoCheckBox = findViewById(R.id.duo_checkbox);
        boolean hasDuo = DuoCheckBox.isChecked();

        // Figure out if the user chose "IOS" answer
        CheckBox IOSCheckBox = findViewById(R.id.ios_checkbox);
        boolean hasIOS = IOSCheckBox.isChecked();

        // Figure out if the user chose "Linux" answer
        CheckBox LinuxCheckBox = findViewById(R.id.linux_checkbox);
        boolean hasLinux = LinuxCheckBox.isChecked();

        if (hasPixel && hasDuo && !hasIOS && !hasLinux) {
            increment_score();
        }
    }

    public void question_9() {
        // Figure out if the user chose "Xperia" answer
        CheckBox XperiaCheckBox = findViewById(R.id.xperia_checkbox);
        boolean hasXperia = XperiaCheckBox.isChecked();

        // Figure out if the user chose "Bravia" answer
        CheckBox BraviaCheckBox = findViewById(R.id.bravia_checkbox);
        boolean hasBravia = BraviaCheckBox.isChecked();

        // Figure out if the user chose "Vaio" answer
        CheckBox VaioCheckBox = findViewById(R.id.vaio_checkbox);
        boolean hasVaio = VaioCheckBox.isChecked();

        // Figure out if the user chose "PLayStation" answer
        CheckBox PlayStationCheckBox = findViewById(R.id.play_station_checkbox);
        boolean hasPlayStastion = PlayStationCheckBox.isChecked();

        if (hasXperia && hasBravia && hasVaio && hasPlayStastion) {
            increment_score();
        }
    }

    public void question_10() {
        // Figure out if the user choose "Android Studio" answer for EditText.
        EditText answerForQuestion1 = findViewById(R.id.question_edit_text);
        if (answerForQuestion1.getText().toString().equals(getString(R.string.answer_10))) {
            increment_score();
        }
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayResult(String result) {
        TextView testResultTextView = findViewById(R.id.test_result_text_view);
        testResultTextView.setText(result);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(result);
        final TextView input = new TextView(this);
        alert.setView(input);
        alert.show();
    }

    /**
     * This method is called when user selected the correct answer.
     * Added +1 to score for each correct answer
     */
    private void increment_score() {
        score = ++score;
    }

}