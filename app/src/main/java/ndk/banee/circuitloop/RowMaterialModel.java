package ndk.banee.circuitloop;

public class RowMaterialModel {

    String id,name,measurementUnit,currentStock,minimumStock;

    public RowMaterialModel(String id, String name, String measurementUnit, String currentStock, String minimumStock) {

        this.id = id;
        this.name = name;
        this.measurementUnit = measurementUnit;
        this.currentStock = currentStock;
        this.minimumStock = minimumStock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public String getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(String currentStock) {
        this.currentStock = currentStock;
    }

    public String getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(String minimumStock) {
        this.minimumStock = minimumStock;
    }
}
