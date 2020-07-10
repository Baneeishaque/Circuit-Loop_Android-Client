package ndk.banee.circuitloop;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.core.util.Pair;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

import ndk.utils_android1.ActivityWithContexts;
import ndk.utils_android1.ExceptionUtils;
import ndk.utils_android16.Float_Utils;
import ndk.utils_android3.HttpApiSelectTask3;
import ndk.utils_android3.HttpApiSelectTaskWrapper3;

public class RawMaterialStockActivity extends ActivityWithContexts {

    private RawMaterialStockSortableTableView rawMaterialStockSortableTableView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raw_material_stock);

        rawMaterialStockSortableTableView = findViewById(R.id.tableView);
        progressBar = findViewById(R.id.progressBar);

        Bundle intentExtras = getIntent().getExtras();

        if (intentExtras == null) {

            setTitle("Row Materials - Stock");
            getSalesSchemeSerialCount("");

        } else {

            if (Objects.requireNonNull(intentExtras.getString("variant")).equals("belowMinimum")) {

                setTitle("Row Materials - Below Minimum");
                getSalesSchemeSerialCount("belowMinimum");

            } else if (Objects.requireNonNull(intentExtras.getString("variant")).equals("ouOf")) {

                setTitle("Row Materials - Outage");
                getSalesSchemeSerialCount("ouOf");
            }
        }
    }

    private void getSalesSchemeSerialCount(String variant) {

        HttpApiSelectTask3.AsyncResponseJSONArray httpApiGetDbSelectTaskResponseHandler = jsonArray -> {

            ArrayList<RawMaterialModel> rawMaterials = new ArrayList<>();
            for (int i = 1; i < jsonArray.length(); i++) {

                try {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    switch (variant) {

                        case "":
                            rawMaterials.add(new RawMaterialModel(i, jsonObject.getString("id"), jsonObject.getString("name"), jsonObject.getString("measurement_unit"), Float_Utils.roundOff_to_two_positions(jsonObject.getString("current_stock")), Float_Utils.roundOff_to_two_positions(jsonObject.getString("minimum_stock"))));
                            break;

                        case "belowMinimum":
                            if (Float_Utils.roundOff_to_two_positions(jsonObject.getString("current_stock")) < Float_Utils.roundOff_to_two_positions(jsonObject.getString("minimum_stock"))) {

                                rawMaterials.add(new RawMaterialModel(i, jsonObject.getString("id"), jsonObject.getString("name"), jsonObject.getString("measurement_unit"), Float_Utils.roundOff_to_two_positions(jsonObject.getString("current_stock")), Float_Utils.roundOff_to_two_positions(jsonObject.getString("minimum_stock"))));
                            }
                            break;

                        case "outOf":
                            if (Float_Utils.roundOff_to_two_positions(jsonObject.getString("current_stock")) == 0.00) {

                                rawMaterials.add(new RawMaterialModel(i, jsonObject.getString("id"), jsonObject.getString("name"), jsonObject.getString("measurement_unit"), Float_Utils.roundOff_to_two_positions(jsonObject.getString("current_stock")), Float_Utils.roundOff_to_two_positions(jsonObject.getString("minimum_stock"))));
                            }
                    }

                } catch (JSONException exception) {

                    ExceptionUtils.handleExceptionOnGui(getApplicationContext(), ApplicationSpecification.applicationName, exception);
                }
            }

            if (rawMaterialStockSortableTableView != null) {

                final RawMaterialStockTableAdapter rawMaterialStockTableAdapter = new RawMaterialStockTableAdapter(getApplicationContext(), rawMaterials, rawMaterialStockSortableTableView);
                rawMaterialStockSortableTableView.setDataAdapter(rawMaterialStockTableAdapter);
            }
        };
        HttpApiSelectTaskWrapper3.execute(CircuitLoopApiUtils.getHttApi(CircuitLoopApiConstants.selectRawMaterials), currentActivityContext, progressBar, rawMaterialStockSortableTableView, ApplicationSpecification.applicationName, new Pair[]{}, httpApiGetDbSelectTaskResponseHandler);
    }
}
