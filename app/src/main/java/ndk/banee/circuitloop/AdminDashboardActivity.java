package ndk.banee.circuitloop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_dashboard_activity);
        setTitle("Admin Home");

        Button buttonRowMaterials = findViewById(R.id.buttonRowMaterials);
        buttonRowMaterials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(AdminDashboardActivity.this, RowMaterialsActivity.class));
            }
        });
    }
}
