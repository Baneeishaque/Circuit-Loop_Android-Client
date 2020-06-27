package ndk.banee.circuitloop;

import android.os.Bundle;
import android.view.View;

import ndk.utils_android1.ActivityWithContexts;
import ndk.utils_android1.ButtonUtils;

public class RowMaterialsActivity extends ActivityWithContexts {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_materials_activity);
        setTitle("Row Materials");

        ButtonUtils.associateClickAction(currentAppCompatActivity, R.id.buttonRowMaterialList, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ButtonUtils.associateClickAction(currentAppCompatActivity, R.id.buttonRowMaterialStock, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ButtonUtils.associateClickAction(currentAppCompatActivity, R.id.buttonOutOfStock, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ButtonUtils.associateClickAction(currentAppCompatActivity, R.id.buttonBelowMinimumStock, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
