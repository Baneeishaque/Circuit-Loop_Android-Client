package ndk.banee.circuitloop;

import android.os.Bundle;
import android.view.View;

import ndk.utils_android1.ActivityUtils1;
import ndk.utils_android1.ActivityWithContexts;
import ndk.utils_android1.ButtonUtils;

public class AdminDashboardActivity extends ActivityWithContexts {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_dashboard_activity);
        setTitle("Admin Home");

        ButtonUtils.associateClickAction(currentAppCompatActivity, R.id.buttonRowMaterials, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActivityUtils1.startActivity(currentActivityContext, RowMaterialsActivity.class);
            }
        });
    }
}
