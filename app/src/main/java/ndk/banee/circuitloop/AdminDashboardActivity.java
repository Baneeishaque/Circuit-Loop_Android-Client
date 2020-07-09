package ndk.banee.circuitloop;

import android.os.Bundle;

import ndk.utils_android1.ActivityUtils;
import ndk.utils_android1.ActivityWithContexts;
import ndk.utils_android1.ButtonUtils;

public class AdminDashboardActivity extends ActivityWithContexts {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_dashboard_activity);

        ButtonUtils.associateClickAction(currentAppCompatActivity, R.id.buttonRowMaterials, v -> ActivityUtils.startActivityForClass(currentActivityContext, RowMaterialsActivity.class));
    }
}
