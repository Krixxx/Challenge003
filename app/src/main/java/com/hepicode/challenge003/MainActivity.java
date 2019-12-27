package com.hepicode.challenge003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView result;
    Button button;
    String selection;
    int itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        result = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

                itemPosition = pos;
                selection = adapterView.getItemAtPosition(pos).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void btnClicked(View view){

        switch (itemPosition) {
            case 0:
                Toast.makeText(this, "Please select option", Toast.LENGTH_SHORT).show();
                break;
            default:
                result.setText(selection);
                break;
        }


    }

    /*
    1. Create a Single Activity A (Launch Activity)
    2. Add a Spinner, TextView and Button widgets to the layout file as show in the screen-shot below
    3. The Spinner is populated from a String-Array in the Strings resources
    4. When an option is selected from the Spinner and the submit button is clicked,
       the option value will be displayed on the TextView
    5. The title of the option must be checked so that it will not be displayed rather it
       will let the use know through a Toast Message that an option should be selected.
     */
}
