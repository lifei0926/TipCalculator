package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void buttonComputeHandler(View view){
        double checkAmount = 0;
        int  partySize = 0;
        //get check amount from user input
        String cAmount = ((TextView)findViewById(R.id.checkAmountValue)).getText().toString();
        String pSize = ((TextView)findViewById(R.id.partySizeValue)).getText().toString();

        //check whether the input is empty and get check amount from user
        if(!cAmount.isEmpty() && !pSize.isEmpty()) {
            checkAmount = Double.valueOf(((TextView) findViewById(R.id.checkAmountValue)).getText().toString());


            //check whether the input is empty and get party size from user
            if (!pSize.isEmpty())
                partySize = Integer.valueOf(((TextView) findViewById(R.id.partySizeValue)).getText().toString());
                setEditTextWithCheckAmountAndPartySize(checkAmount, partySize);
        }else{
            resetEditText();
            Toast.makeText(getApplicationContext(), "Empty or incorrect value(s)!", Toast.LENGTH_SHORT).show();
        }

    }

    public void resetEditText(){
        ((TextView) findViewById(R.id.fifteenPercentTipValue)).setText("");
        ((TextView) findViewById(R.id.twentyPercentTipValue)).setText("");
        ((TextView) findViewById(R.id.twentyfivePercentTipValue)).setText("");
        ((TextView) findViewById(R.id.fifteenPercentTotalValue)).setText("");
        ((TextView) findViewById(R.id.twentyPercentTotalValue)).setText("");
        ((TextView) findViewById(R.id.twentyfivePercentTotalValue)).setText("");
        ((TextView) findViewById(R.id.partySizeValue)).setText("");
    }

    public void setEditTextWithCheckAmountAndPartySize(double checkamount, int partysize){
        ((TextView) findViewById(R.id.fifteenPercentTipValue)).setText(Integer.toString((int)Math.round(checkamount * 0.15 / partysize)));
        ((TextView) findViewById(R.id.twentyPercentTipValue)).setText(Integer.toString((int)Math.round(checkamount * 0.20 / partysize)));
        ((TextView) findViewById(R.id.twentyfivePercentTipValue)).setText(Integer.toString((int)Math.round(checkamount * 0.25 / partysize)));
        ((TextView) findViewById(R.id.fifteenPercentTotalValue)).setText(Integer.toString((int)Math.round(checkamount * 1.15 / partysize)));
        ((TextView) findViewById(R.id.twentyPercentTotalValue)).setText(Integer.toString((int)Math.round(checkamount * 1.20 / partysize)));
        ((TextView) findViewById(R.id.twentyfivePercentTotalValue)).setText(Integer.toString((int)Math.round(checkamount * 1.25 / partysize)));
    }


}