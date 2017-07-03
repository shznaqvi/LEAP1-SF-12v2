

package edu.aku.hassannaqvi.leap1sf_12v2.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.leap1sf_12v2.R;
import edu.aku.hassannaqvi.leap1sf_12v2.core.DatabaseHelper;

public class SectionAActivity extends Activity {

    private static final String TAG = SectionAActivity.class.getSimpleName();

    @BindView(R.id.activity_section_a)
    ScrollView activitySectionA;
    @BindView(R.id.sf01)
    RadioGroup sf01;
    @BindView(R.id.sf01a)
    RadioButton sf01a;
    @BindView(R.id.sf01b)
    RadioButton sf01b;
    @BindView(R.id.sf01c)
    RadioButton sf01c;
    @BindView(R.id.sf01d)
    RadioButton sf01d;
    @BindView(R.id.sf01e)
    RadioButton sf01e;
    @BindView(R.id.sf02a)
    RadioGroup sf02a;
    @BindView(R.id.sf02aa)
    RadioButton sf02aa;
    @BindView(R.id.sf02ab)
    RadioButton sf02ab;
    @BindView(R.id.sf02ac)
    RadioButton sf02ac;
    @BindView(R.id.sf02b)
    RadioGroup sf02b;
    @BindView(R.id.sf02ba)
    RadioButton sf02ba;
    @BindView(R.id.sf02bb)
    RadioButton sf02bb;
    @BindView(R.id.sf02bc)
    RadioButton sf02bc;
    @BindView(R.id.sf03a)
    RadioGroup sf03a;
    @BindView(R.id.sf03aa)
    RadioButton sf03aa;
    @BindView(R.id.sf03ab)
    RadioButton sf03ab;
    @BindView(R.id.sf03ac)
    RadioButton sf03ac;
    @BindView(R.id.sf03ad)
    RadioButton sf03ad;
    @BindView(R.id.sf03ae)
    RadioButton sf03ae;
    @BindView(R.id.sf03b)
    RadioGroup sf03b;
    @BindView(R.id.sf03ba)
    RadioButton sf03ba;
    @BindView(R.id.sf03bb)
    RadioButton sf03bb;
    @BindView(R.id.sf03bc)
    RadioButton sf03bc;
    @BindView(R.id.sf03bd)
    RadioButton sf03bd;
    @BindView(R.id.sf03be)
    RadioButton sf03be;
    @BindView(R.id.sf04a)
    RadioGroup sf04a;
    @BindView(R.id.sf04aa)
    RadioButton sf04aa;
    @BindView(R.id.sf04ab)
    RadioButton sf04ab;
    @BindView(R.id.sf04ac)
    RadioButton sf04ac;
    @BindView(R.id.sf04ad)
    RadioButton sf04ad;
    @BindView(R.id.sf04ae)
    RadioButton sf04ae;
    @BindView(R.id.sf04b)
    RadioGroup sf04b;
    @BindView(R.id.sf04ba)
    RadioButton sf04ba;
    @BindView(R.id.sf04bb)
    RadioButton sf04bb;
    @BindView(R.id.sf04bc)
    RadioButton sf04bc;
    @BindView(R.id.sf04bd)
    RadioButton sf04bd;
    @BindView(R.id.sf04be)
    RadioButton sf04be;
    @BindView(R.id.sf05)
    RadioGroup sf05;
    @BindView(R.id.sf05a)
    RadioButton sf05a;
    @BindView(R.id.sf05b)
    RadioButton sf05b;
    @BindView(R.id.sf05c)
    RadioButton sf05c;
    @BindView(R.id.sf05d)
    RadioButton sf05d;
    @BindView(R.id.sf05e)
    RadioButton sf05e;
    @BindView(R.id.sf06a)
    RadioGroup sf06a;
    @BindView(R.id.sf06aa)
    RadioButton sf06aa;
    @BindView(R.id.sf06ab)
    RadioButton sf06ab;
    @BindView(R.id.sf06ac)
    RadioButton sf06ac;
    @BindView(R.id.sf06ad)
    RadioButton sf06ad;
    @BindView(R.id.sf06ae)
    RadioButton sf06ae;
    @BindView(R.id.sf06b)
    RadioGroup sf06b;
    @BindView(R.id.sf06ba)
    RadioButton sf06ba;
    @BindView(R.id.sf06bb)
    RadioButton sf06bb;
    @BindView(R.id.sf06bc)
    RadioButton sf06bc;
    @BindView(R.id.sf06bd)
    RadioButton sf06bd;
    @BindView(R.id.sf06be)
    RadioButton sf06be;
    @BindView(R.id.sf06c)
    RadioGroup sf06c;
    @BindView(R.id.sf06ca)
    RadioButton sf06ca;
    @BindView(R.id.sf06cb)
    RadioButton sf06cb;
    @BindView(R.id.sf06cc)
    RadioButton sf06cc;
    @BindView(R.id.sf06cd)
    RadioButton sf06cd;
    @BindView(R.id.sf06ce)
    RadioButton sf06ce;
    @BindView(R.id.sf07)
    RadioGroup sf07;
    @BindView(R.id.sf07a)
    RadioButton sf07a;
    @BindView(R.id.sf07b)
    RadioButton sf07b;
    @BindView(R.id.sf07c)
    RadioButton sf07c;
    @BindView(R.id.sf07d)
    RadioButton sf07d;
    @BindView(R.id.sf07e)
    RadioButton sf07e;
    @BindView(R.id.fldGrpbtn)
    LinearLayout fldGrpbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_a);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnNext)
    void onBtnNextClick() {
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Next Section", Toast.LENGTH_SHORT).show();

                finish();

                Intent endSec = new Intent(this, EndingActivity.class);
                startActivity(endSec);

/*
                startActivity(new Intent(this, SectionBActivity.class));
*/
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }


    @OnClick(R.id.btnEnd)
    void onBtnEndClick() {
        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();

        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                Toast.makeText(this, "Starting Form Ending Section", Toast.LENGTH_SHORT).show();
                Intent endSec = new Intent(this, EndingActivity.class);
                endSec.putExtra("complete", false);
                startActivity(endSec);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

     /*   long updcount = db.addForm(AppMain.fc);

        AppMain.fc.setID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            AppMain.fc.setUID(
                    (AppMain.fc.getDeviceID() + AppMain.fc.getID()));
            db.updateFormID();
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
        }*/
        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for this Section", Toast.LENGTH_SHORT).show();

//        AppMain.VillageName = cravillage.getText().toString();

      /*  SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        AppMain.fc = new FormsContract();

        AppMain.fc.setUserName(AppMain.username);
        AppMain.fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        AppMain.fc.setHhDT((DateFormat.format("dd-MM-yyyy HH:mm",new Date())).toString());

//        AppMain.fc.setTehsil(AppMain.tehsilCode);
//        AppMain.fc.sethFacility(AppMain.hfCode);
//        AppMain.fc.setLhwCode(AppMain.lhwCode);
//        AppMain.fc.setUccode(getAllUCs.get(crauc.getSelectedItem().toString()));
//        AppMain.fc.setVillagename(AppMain.VillageName);
//        AppMain.fc.setChildId(cra03.getText().toString());

       // AppMain.fc.setTagId(sharedPref.getString("tagName", ""));
        JSONObject sa = new JSONObject();


        setGPS();

        AppMain.fc.setsA(String.valueOf(sa));
        */

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }



  /*  public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);

//        String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String dt = GPSPref.getString("Time", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            AppMain.fc.setGpsLat(GPSPref.getString("Latitude", "0"));
            AppMain.fc.setGpsLng(GPSPref.getString("Longitude", "0"));
            AppMain.fc.setGpsAcc(GPSPref.getString("Accuracy", "0"));
//            AppMain.fc.setGpsTime(GPSPref.getString(date, "0")); // Timestamp is converted to date above
            AppMain.fc.setGpsTime(date); // Timestamp is converted to date above

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }
*/

    public boolean ValidateForm() {


        return true;
    }


}
