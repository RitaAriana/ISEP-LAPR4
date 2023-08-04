package eapli.base.warehouse.domain;

public class WarehouseBuilder {
    private Long Id;

    private WarehousePlant warehousePlant;

    private Dashboard dashboard;

    public WarehouseBuilder(){}

    public WarehouseBuilder withId(Long Id){
        this.Id = Id;
        return this;
    }

    public WarehouseBuilder withPlant(WarehousePlant warehousePlant){
        this.warehousePlant = warehousePlant;
        return this;
    }

    public WarehouseBuilder withDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
        return this;
    }

    private Warehouse buildWarehouse(){
        return new Warehouse(Id, warehousePlant, dashboard);
    }

    public Warehouse build(){
        return buildWarehouse();
    }

}
