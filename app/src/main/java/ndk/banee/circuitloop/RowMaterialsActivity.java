package ndk.banee.circuitloop;

import android.os.Bundle;

import ndk.utils_android1.ActivityUtils;
import ndk.utils_android1.ActivityWithContexts;
import ndk.utils_android1.ButtonUtils;

public class RowMaterialsActivity extends ActivityWithContexts {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_materials_activity);
        setTitle("Row Materials");

        ButtonUtils.associateClickAction(currentAppCompatActivity, R.id.buttonRowMaterialList, v -> {

            ActivityUtils.startActivityForClass(currentActivityContext, RawMaterialListActivity.class);
        });

        ButtonUtils.associateClickAction(currentAppCompatActivity, R.id.buttonRowMaterialStock, v -> {

        });

        ButtonUtils.associateClickAction(currentAppCompatActivity, R.id.buttonOutOfStock, v -> {

        });

        ButtonUtils.associateClickAction(currentAppCompatActivity, R.id.buttonBelowMinimumStock, v -> {

        });
    }
}
