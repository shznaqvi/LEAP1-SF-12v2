

package edu.aku.hassannaqvi.leap1sf_12v2.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.leap1sf_12v2.R;
import edu.aku.hassannaqvi.leap1sf_12v2.contracts.FormsContract;
import edu.aku.hassannaqvi.leap1sf_12v2.core.DatabaseHelper;
import edu.aku.hassannaqvi.leap1sf_12v2.core.MainApp;

public class SectionAActivity extends Activity {

    private static final String TAG = SectionAActivity.class.getSimpleName();

    @BindView(R.id.activity_section_a)
    ScrollView activitySectionA;
    @BindView(R.id.studyID)
    EditText studyID;
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


                startActivity(new Intent(this, MainActivity.class));

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
                Intent endSec = new Intent(this, MainActivity.class);
                startActivity(endSec);
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        long updcount = db.addForm(MainApp.fc);

        MainApp.fc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.fc.set_UID(
                    (MainApp.fc.getDeviceID() + MainApp.fc.get_ID()));
            db.updateFormID();

        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for this Section", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        MainApp.fc = new FormsContract();

        MainApp.fc.setUsername(MainApp.username);
        MainApp.fc.setDevicetagID(sharedPref.getString("tagName", null));
        MainApp.fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.fc.setFormDate((DateFormat.format("dd-MM-yyyy HH:mm", new Date())).toString());
        //MainApp.fc.setTagId(sharedPref.getString("tagName", ""));

        MainApp.fc.setStudyID(studyID.getText().toString());

        JSONObject sa = new JSONObject();
        sa.put("sf01", sf01a.isChecked() ? "1" : sf01b.isChecked() ? "2" : sf01c.isChecked() ? "3" : sf01d.isChecked() ? "4" : sf01e.isChecked() ? "5" : "0");
        sa.put("sf02a", sf02aa.isChecked() ? "1" : sf02ab.isChecked() ? "2" : sf02ac.isChecked() ? "3" : "0");
        sa.put("sf02b", sf02ba.isChecked() ? "1" : sf02bb.isChecked() ? "2" : sf02bc.isChecked() ? "3" : "0");
        sa.put("sf03a", sf03aa.isChecked() ? "1" : sf03ab.isChecked() ? "2" : sf03ac.isChecked() ? "3" : sf03ad.isChecked() ? "4" : sf03ae.isChecked() ? "5" : "0");
        sa.put("sf03b", sf03ba.isChecked() ? "1" : sf03bb.isChecked() ? "2" : sf03bc.isChecked() ? "3" : sf03bd.isChecked() ? "4" : sf03be.isChecked() ? "5" : "0");
        sa.put("sf04a", sf04aa.isChecked() ? "1" : sf04ab.isChecked() ? "2" : sf04ac.isChecked() ? "3" : sf04ad.isChecked() ? "4" : sf04ae.isChecked() ? "5" : "0");
        sa.put("sf04b", sf04ba.isChecked() ? "1" : sf04bb.isChecked() ? "2" : sf04bc.isChecked() ? "3" : sf04bd.isChecked() ? "4" : sf04be.isChecked() ? "5" : "0");
        sa.put("sf05", sf05a.isChecked() ? "1" : sf05b.isChecked() ? "2" : sf05c.isChecked() ? "3" : sf05d.isChecked() ? "4" : sf05e.isChecked() ? "5" : "0");
        sa.put("sf06a", sf06aa.isChecked() ? "1" : sf06ab.isChecked() ? "2" : sf06ac.isChecked() ? "3" : sf06ad.isChecked() ? "4" : sf06ae.isChecked() ? "5" : "0");
        sa.put("sf06b", sf06ba.isChecked() ? "1" : sf06bb.isChecked() ? "2" : sf06bc.isChecked() ? "3" : sf06bd.isChecked() ? "4" : sf06be.isChecked() ? "5" : "0");
        sa.put("sf06c", sf06ca.isChecked() ? "1" : sf06cb.isChecked() ? "2" : sf06cc.isChecked() ? "3" : sf06cd.isChecked() ? "4" : sf06ce.isChecked() ? "5" : "0");
        sa.put("sf07", sf07a.isChecked() ? "1" : sf07b.isChecked() ? "2" : sf07c.isChecked() ? "3" : sf07d.isChecked() ? "4" : sf07e.isChecked() ? "5" : "0");


        setGPS();

        MainApp.fc.setsA(String.valueOf(sa));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }


    public void setGPS() {
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

            MainApp.fc.setGpsLat(GPSPref.getString("Latitude", "0"));
            MainApp.fc.setGpsLng(GPSPref.getString("Longitude", "0"));
            MainApp.fc.setGpsAcc(GPSPref.getString("Accuracy", "0"));
//            AppMain.fc.setGpsTime(GPSPref.getString(date, "0")); // Timestamp is converted to date above
            MainApp.fc.setGpsDT(date); // Timestamp is converted to date above

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }

    public boolean ValidateForm() {

        if (studyID.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.studyID), Toast.LENGTH_SHORT).show();
            studyID.setError("This data is required");
            Log.d(TAG, " studyID :empty ");
            return false;
        } else {
            studyID.setError(null);
        }
        if (Double.valueOf(studyID.getText().toString()) == 0) {
            Toast.makeText(this, "ERROR(invalid): " + getString(R.string.studyID), Toast.LENGTH_SHORT).show();
            studyID.setError("Invalid: Data cannot be Zero");
            Log.i(TAG, "studyID: Invalid data is 0");
            return false;
        } else {
            studyID.setError(null);
        }

        // =================== sf01 ====================
        if (sf01.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (empty)" + getString(R.string.sf01), Toast.LENGTH_SHORT).show();
            sf01e.setError("this data is required");
            Log.d(TAG, "sf01 : not selected ");
            return false;
        } else {
            sf01e.setError(null);
        }

        // =================== sf02a ====================
        if (sf02a.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (empty)" + getString(R.string.sf02a), Toast.LENGTH_SHORT).show();
            sf02ac.setError("this data is required");
            Log.d(TAG, "sf02a : not selected ");
            return false;
        } else {
            sf02ac.setError(null);
        }

        // =================== sf02b ====================
        if (sf02b.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (empty)" + getString(R.string.sf02b), Toast.LENGTH_SHORT).show();
            sf02bc.setError("this data is required");
            Log.d(TAG, "sf02b : not selected ");
            return false;
        } else {
            sf02bc.setError(null);
        }

        // =================== sf03a ====================
        if (sf03a.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (empty)" + getString(R.string.sf03a), Toast.LENGTH_SHORT).show();
            sf03ae.setError("this data is required");
            Log.d(TAG, "sf03a : not selected ");
            return false;
        } else {
            sf03ae.setError(null);
        }

        // =================== sf03b ====================
        if (sf03b.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (empty)" + getString(R.string.sf03b), Toast.LENGTH_SHORT).show();
            sf03be.setError("this data is required");
            Log.d(TAG, "sf03b : not selected ");
            return false;
        } else {
            sf03be.setError(null);
        }

        // =================== sf04a ====================
        if (sf04a.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (empty)" + getString(R.string.sf04a), Toast.LENGTH_SHORT).show();
            sf04ae.setError("this data is required");
            Log.d(TAG, "sf04a : not selected ");
            return false;
        } else {
            sf04ae.setError(null);
        }


        // =================== sf04b ====================
        if (sf04b.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (empty)" + getString(R.string.sf04b), Toast.LENGTH_SHORT).show();
            sf04be.setError("this data is required");
            Log.d(TAG, "sf04b : not selected ");
            return false;
        } else {
            sf04be.setError(null);
        }

        // =================== sf05 ====================
        if (sf05.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (empty)" + getString(R.string.sf05), Toast.LENGTH_SHORT).show();
            sf05e.setError("this data is required");
            Log.d(TAG, "sf05 : not selected ");
            return false;
        } else {
            sf05e.setError(null);
        }

        // =================== sf06a ====================
        if (sf06a.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (empty)" + getString(R.string.sf06a), Toast.LENGTH_SHORT).show();
            sf06ae.setError("this data is required");
            Log.d(TAG, "sf06a : not selected ");
            return false;
        } else {
            sf06ae.setError(null);
        }

        // =================== sf06b ====================
        if (sf06b.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (empty)" + getString(R.string.sf06b), Toast.LENGTH_SHORT).show();
            sf06be.setError("this data is required");
            Log.d(TAG, "sf06b : not selected ");
            return false;
        } else {
            sf06be.setError(null);
        }

        // =================== sf06c ====================
        if (sf06c.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (empty)" + getString(R.string.sf06c), Toast.LENGTH_SHORT).show();
            sf06ce.setError("this data is required");
            Log.d(TAG, "sf06c : not selected ");
            return false;
        } else {
            sf06ce.setError(null);
        }

        // =================== sf07 ====================
        if (sf07.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "ERROR (empty)" + getString(R.string.sf07), Toast.LENGTH_SHORT).show();
            sf07e.setError("this data is required");
            Log.d(TAG, "sf07 : not selected ");
            return false;
        } else {
            sf07e.setError(null);
        }

        return true;
    }


}
