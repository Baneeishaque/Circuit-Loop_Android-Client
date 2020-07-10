package ndk.banee.circuitloop;

import android.content.Context;
import android.util.AttributeSet;

import androidx.core.content.ContextCompat;

import de.codecrafters.tableview.SortableTableView;
import de.codecrafters.tableview.model.TableColumnWeightModel;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;
import de.codecrafters.tableview.toolkit.SortStateViewProviders;
import de.codecrafters.tableview.toolkit.TableDataRowBackgroundProviders;

/**
 * An extension of the {@link SortableTableView} that handles {@link RawMaterialModel}s.
 */
public class RawMaterialStockSortableTableView extends SortableTableView<RawMaterialModel> {

    private OnRowClickListener onRowClickListener;

    public RawMaterialStockSortableTableView(final Context context) {
        this(context, null);
    }

    public RawMaterialStockSortableTableView(final Context context, final AttributeSet attributes) {

        this(context, attributes, android.R.attr.listViewStyle);
    }

    public RawMaterialStockSortableTableView(final Context context, final AttributeSet attributes, final int styleAttributes) {

        super(context, attributes, styleAttributes);

        final SimpleTableHeaderAdapter simpleTableHeaderAdapter = new SimpleTableHeaderAdapter(context, "#", "Item", "Cur.","Min.");
        simpleTableHeaderAdapter.setTextColor(ContextCompat.getColor(context, R.color.table_header_text));
        setHeaderAdapter(simpleTableHeaderAdapter);

        final int rowColorEven = ContextCompat.getColor(context, R.color.table_data_row_even);
        final int rowColorOdd = ContextCompat.getColor(context, R.color.table_data_row_odd);
        setDataRowBackgroundProvider(TableDataRowBackgroundProviders.alternatingRowColors(rowColorEven, rowColorOdd));
        setHeaderSortStateViewProvider(SortStateViewProviders.brightArrows());

        final TableColumnWeightModel tableColumnWeightModel = new TableColumnWeightModel(4);
        tableColumnWeightModel.setColumnWeight(0, 1);
        tableColumnWeightModel.setColumnWeight(1, 6);
        tableColumnWeightModel.setColumnWeight(2, 2);
        tableColumnWeightModel.setColumnWeight(3, 2);
        setColumnModel(tableColumnWeightModel);

        setColumnComparator(0, RawMaterialComparator.getRawMaterialSerialNumberComparator()) ;
        setColumnComparator(1, RawMaterialComparator.getRawMaterialNameComparator());
        setColumnComparator(2, RawMaterialComparator.getRawMaterialCurrentStockComparator());
        setColumnComparator(3, RawMaterialComparator.getRawMaterialMinimumStockComparator());

        addDataClickListener((rowIndex, clickedData) -> {

            CircuitLoopLogUtils.debug("Clicked On : " + clickedData.toString());
            onRowClickListener.onRowClick(clickedData);
        });
    }

    public void setOnRowClickListener(OnRowClickListener onRowClickListener) {

        this.onRowClickListener = onRowClickListener;
    }

    public interface OnRowClickListener {

        void onRowClick(RawMaterialModel clickedData);
    }
}
