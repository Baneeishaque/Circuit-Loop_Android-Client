package ndk.banee.circuitloop;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ndk.utils_android9.activities.RecyclerViewWithToolbarAndProgressBarActivity;

public class RawMaterialListActivity extends RecyclerViewWithToolbarAndProgressBarActivity {

    ArrayList<RowMaterialModel> rowMaterials = new ArrayList<>();
    RawMaterialRecyclerViewAdaptor rawMaterialRecyclerViewAdaptor = new RawMaterialRecyclerViewAdaptor(rowMaterials);

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
            rowMaterials.add(new RowMaterialModel(jsonObject.getString("id"), jsonObject.getString("name"), jsonObject.getString("measurement_unit"), jsonObject.getString("current_stock"), jsonObject.getString("minimum_stock")));

        } catch (JSONException e) {

            CircuitLoopExceptionUtils.handleExceptionOnGui(getApplicationContext(), e);
        }
    }

    @Override
    public void prepareRecyclerView() {

        recyclerView.setAdapter(rawMaterialRecyclerViewAdaptor);
    }
}
