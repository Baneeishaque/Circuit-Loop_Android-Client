package ndk.banee.circuitloop;

import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ndk.utils_android1.ActivityUtils;
import ndk.utils_android9.activities.RecyclerViewWithToolbarAndProgressBarActivity;

public class RawMaterialListActivity extends RecyclerViewWithToolbarAndProgressBarActivity {

    ArrayList<RawMaterialModel> rawMaterials = new ArrayList<>();
    RawMaterialRecyclerViewAdaptor rawMaterialRecyclerViewAdaptor = new RawMaterialRecyclerViewAdaptor(rawMaterials);

    @Override
    public String configureApplicationName() {

        return ApplicationSpecification.APPLICATION_NAME;
    }

    @Override
    public String configureFetchUrl() {

        return CircuitLoopApiUtils.getHttApi(CircuitLoopApiConstants.selectRawMaterials);
    }

    @Override
    public void processJsonObjectInFetchedJsonArray(JSONObject jsonObject) {

        try {
            rawMaterials.add(new RawMaterialModel(jsonObject.getString("id"), jsonObject.getString("name"), jsonObject.getString("measurement_unit"), jsonObject.getString("current_stock"), jsonObject.getString("minimum_stock")));

        } catch (JSONException e) {

            CircuitLoopExceptionUtils.handleExceptionOnGui(getApplicationContext(), e);
        }
    }

    @Override
    public void prepareRecyclerView() {

        recyclerView.setAdapter(rawMaterialRecyclerViewAdaptor);
    }

    @Override
    public boolean configureSearchAction(String searchKey) {

        ArrayList<RawMaterialModel> filterList = new ArrayList<>();

        if (searchKey.length() > 0) {

            for (int i = 0; i < rawMaterials.size(); i++) {

                if (rawMaterials.get(i).getName().toLowerCase().contains(searchKey.toLowerCase())) {

                    filterList.add(rawMaterials.get(i));
                    rawMaterialRecyclerViewAdaptor.updateList(filterList);
                }
            }
        } else {

            rawMaterialRecyclerViewAdaptor.updateList(rawMaterials);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_insert, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_insert) {

            ActivityUtils.startActivityForClassWithFinish(currentActivityContext, RawMaterialInsertionActivity.class);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
