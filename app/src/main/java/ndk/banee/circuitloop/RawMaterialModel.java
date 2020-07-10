package ndk.banee.circuitloop;

public class RawMaterialModel {

    int serialNumber;
    String id, name, measurementUnit;
    float currentStock, minimumStock;

    public RawMaterialModel(int serialNumber,String id, String name, String measurementUnit, float currentStock, float minimumStock) {

        this.serialNumber=serialNumber;
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

    public float getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(float currentStock) {
        this.currentStock = currentStock;
    }

    public float getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(float minimumStock) {
        this.minimumStock = minimumStock;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}
