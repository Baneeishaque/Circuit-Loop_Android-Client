package ndk.banee.circuitloop;

import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ndk.utils_android1.ActivityUtils1;
import ndk.utils_android16.Float_Utils;
import ndk.utils_android9.activities.RecyclerViewWithToolbarAndProgressBarActivity;

public class RawMaterialListActivity extends RecyclerViewWithToolbarAndProgressBarActivity {

    ArrayList<RawMaterialModel> rawMaterials = new ArrayList<>();
    RawMaterialRecyclerViewAdaptor rawMaterialRecyclerViewAdaptor = new RawMaterialRecyclerViewAdaptor(rawMaterials);

    @Override
    public String configureApplicationName() {

        return ApplicationSpecification.applicationName;
    }

    @Override
    public String configureFetchUrl() {

        return CircuitLoopApiUtils.getHttApi(CircuitLoopApiConstants.selectRawMaterials);
    }

    @Override
    public void processJsonObjectInFetchedJsonArray(int i, JSONObject jsonObject) {

        try {
            rawMaterials.add(new RawMaterialModel(i,jsonObject.getString("id"), jsonObject.getString("name"), jsonObject.getString("measurement_unit"), Float_Utils.roundOff_to_two_positions(jsonObject.getString("current_stock")), Float_Utils.roundOff_to_two_positions(jsonObject.getString("minimum_stock"))));

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

            ActivityUtils1.startActivityForClassWithFinish(currentActivityContext, RawMaterialInsertionActivity.class);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
