package eapli.base.warehouse.domain;


public class WarehousePlantBuilder {

    private WarehousePlant warehousePlant;
    private String description;

    private int length;

    private int width;

    private int square;

    private String unit;

    public WarehousePlantBuilder(){}

    public WarehousePlantBuilder withDescription(final String description) {
        this.description = description;
        return this;
    }

    public WarehousePlantBuilder withLength(final int length) {
        this.length = length;
        return this;
    }

    public WarehousePlantBuilder withWidth(final int width) {
        this.width = width;
        return this;
    }

    public WarehousePlantBuilder withSquare(final int square) {
        this.square = square;
        return this;
    }

    public WarehousePlantBuilder withUnit(final String unit) {
        this.unit = unit;
        return this;
    }

    private WarehousePlant buildWarehousePlant(){
        if(warehousePlant != null)
            return warehousePlant;
        if(description != null && unit != null)
            this.warehousePlant = new WarehousePlant(description, length, width, square, unit);

        return warehousePlant;
    }

    public WarehousePlant buildWarehouse(){
        final WarehousePlant returnPlant = buildWarehousePlant();
        return returnPlant;
    }
}