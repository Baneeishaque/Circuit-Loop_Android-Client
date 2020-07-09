package ndk.banee.circuitloop;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;

import androidx.core.util.Pair;

import java.util.ArrayList;

import ndk.utils_android1.ActivityWithContexts;
import ndk.utils_android16.Spinner_Utils;
import ndk.utils_android16.ValidationUtils;
import ndk.utils_android16.network_task.RestInsertTaskWrapper;

public class RawMaterialInsertionActivity extends ActivityWithContexts {

    private ProgressBar progressBar;
    private ScrollView scrollView;

    private EditText editTextRawMaterialName;
    private Spinner spinnerRawMaterialMeasurementUnit;
    private EditText editTextRawMaterialInitialStock;
    private EditText editTextRawMaterialMinimumStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_row_material_insertion);

        scrollView = findViewById(R.id.scrollView);
        progressBar = findViewById(R.id.progressBar);

        editTextRawMaterialName = findViewById(R.id.editTextRawMaterialName);
        spinnerRawMaterialMeasurementUnit = findViewById(R.id.spinnerRawMaterialMeasurementUnit);
        editTextRawMaterialInitialStock = findViewById(R.id.editTextRawMaterialInitialStock);
        editTextRawMaterialMinimumStock = findViewById(R.id.editTextRawMaterialMinimumStock);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        ArrayList<String> measurementUnits=new ArrayList<>();
        measurementUnits.add("Nos");
        measurementUnits.add("Kgs");
        measurementUnits.add("Lts");
        Spinner_Utils.attach_items_to_simple_spinner(currentActivityContext, spinnerRawMaterialMeasurementUnit, measurementUnits);

        buttonSubmit.setOnClickListener(v -> validateInsertionForm());
    }

    private void validateInsertionForm() {

        ValidationUtils.resetErrors(new EditText[]{editTextRawMaterialName, editTextRawMaterialInitialStock, editTextRawMaterialMinimumStock});

        ArrayList<org.javatuples.Pair<EditText, String>> editTextErrorPairs = new ArrayList<>();
        editTextErrorPairs.add(org.javatuples.Pair.with(editTextRawMaterialName, "Enter Raw Material Name..."));
        editTextErrorPairs.add(org.javatuples.Pair.with(editTextRawMaterialInitialStock, "Enter Raw Material Initial Stock..."));
        editTextErrorPairs.add(org.javatuples.Pair.with(editTextRawMaterialMinimumStock, "Enter Raw Material Minimum Stock..."));

        org.javatuples.Pair<Boolean, EditText> validationResult = ValidationUtils.nonEmptyCheckEditTextPairs(editTextErrorPairs);
        if (validationResult.getValue0()) {

            editTextErrorPairs.remove(0);
            validationResult = ValidationUtils.nonZeroCheckEditTextPairs(editTextErrorPairs);
            if (validationResult.getValue0()) {

                executeHttpPostDbInsertionRequest();

            } else {

                validationResult.getValue1().requestFocus();
            }
        } else {

            validationResult.getValue1().requestFocus();
        }

    }

    private void executeHttpPostDbInsertionRequest() {

        RestInsertTaskWrapper.execute(currentActivityContext, CircuitLoopApiUtils.getHttApi(CircuitLoopApiConstants.insertRawMaterial), currentAppCompatActivity, progressBar, scrollView, ApplicationSpecification.APPLICATION_NAME, new Pair[]{new Pair<>("raw_material_name", editTextRawMaterialName.getText().toString()), new Pair<>("raw_material_measurement_unit", spinnerRawMaterialMeasurementUnit.getSelectedItem().toString()), new Pair<>("raw_material_current_stock", editTextRawMaterialInitialStock.getText().toString()), new Pair<>("raw_material_minimum_stock", editTextRawMaterialMinimumStock.getText().toString())}, editTextRawMaterialName, RawMaterialListActivity.class);
    }
}
