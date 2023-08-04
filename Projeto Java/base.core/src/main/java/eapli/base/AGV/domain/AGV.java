package eapli.base.AGV.domain;

import eapli.base.AGV.modules.ControlSystem;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.warehouse.domain.AGVDock;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AGV implements AggregateRoot<AGVId> {

    @EmbeddedId
    private AGVId agvId;

    private int speed;

    @OneToOne
    private AGVDock agvDock;

    @Embedded
    private Range range;

    @Embedded
    private MaxWeightCapacity maxWeightCapacity;

    @Embedded
    private MaxVolumeCapacity maxVolumeCapacity;

    @Embedded
    private Model model;

    @Embedded
    private BriefDescription briefDescription;

    @Embedded
    private AGVPosition position;

    @Embedded
    private AGVStatus agvStatus;

    @Embedded
    private AGVBattery battery;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "agv_id")
    private List<AGVTask> agvTask;

    @Transient
    private List<Sensor> sensorList;

    @Transient
    private ControlSystem controlSystem;


    public AGV(){}

    public AGV(final AGVId agvId, final BriefDescription briefDescription, final Model model, final MaxWeightCapacity maxWeightCapacity, final MaxVolumeCapacity maxVolumeCapacity, final Range range, final AGVPosition position, final AGVDock agvDock, final  AGVStatus agvStatus){
        this.agvId = agvId;
        this.range = range;
        this.maxWeightCapacity = maxWeightCapacity;
        this.maxVolumeCapacity = maxVolumeCapacity;
        this.model = model;
        this.briefDescription = briefDescription;
        this.position = position;
        this.agvDock = agvDock;
        this.agvStatus = agvStatus;
        this.agvTask = new ArrayList<>();
        this.battery = new AGVBattery(100);
        this.speed = 0;
    }

    @Override
    public boolean sameAs(Object other) {
        if(other == null) return false;
        if(this == other) return true;

       AGV newObj = ((AGV) other);

        return agvId == newObj.agvId && range == newObj.range && maxWeightCapacity == newObj.maxWeightCapacity && maxVolumeCapacity == newObj.maxVolumeCapacity
                && model == newObj.model && briefDescription == newObj.briefDescription && position == newObj.position && agvDock == newObj.agvDock && agvTask == newObj.agvTask;
    }

    public AGVDock agvDock() {
        return agvDock;
    }

    @Override
    public AGVId identity() {
        return agvId;
    }

    public AGVId getAgvId() {
        return agvId;
    }

    public AGVDock getAgvDock() {
        return agvDock;
    }

    public Range getRange() {
        return range;
    }

    public MaxWeightCapacity getMaxWeightCapacity() {
        return maxWeightCapacity;
    }

    public MaxVolumeCapacity getMaxVolumeCapacity() {
        return maxVolumeCapacity;
    }

    public Model getModel() {
        return model;
    }

    public BriefDescription getBriefDescription() {
        return briefDescription;
    }

    public AGVPosition getPosition() {
        return position;
    }

    public AGVStatus getAgvStatus() {
        return agvStatus;
    }

    public List<AGVTask> getAgvTask(){ return agvTask; }

    public AGVPosition getAgvPosition(){
        return position;
    }

    private AGVTask getTaskByDescription(String description){
        for (AGVTask task : agvTask){
            if (task.getDescription().equals(description)) return task;
        }

        return null;
    }

    public boolean addOrdersToATask(String description, ProductOrder order) {

        boolean flag = true;

        AGVTask agvTask = getTaskByDescription(description);

        if (agvTask != null){
            if ((agvTask.getTotalWeight() + order.getOrderWeight().getWeight()) <=  maxWeightCapacity.getMaxWeightCapacity() && (agvTask.getTotalVolume() + order.getOrderVolume().getVolume()) <= maxVolumeCapacity.getMaxVolumeCapacity()){
                agvTask.addMoreOrders(order);
                agvTask.incrementVolume(order.getOrderVolume().getVolume());
                agvTask.incrementWeight(order.getOrderWeight().getWeight());
            }
            else{
                flag = false;
            }
        }


        return flag;

    }

    public void changeStatusOfAGVForOccupied(){
        this.agvStatus.changeStatusOfAGVForOccupied();
    }

    public void changeStatusOfAGVForFree(){
        this.agvStatus.changeStatusOfAGVForFree();
    }

    public void changeStatusOfAGVForCharging(){
        this.agvStatus.changeStatusOfAGVForCharging();
    }

    public void changeStatusOfAGVForMaintenance(){
        this.agvStatus.changeStatusOfAGVForMaintenance();
    }

    public void changeStatusOfAGVForGivenOrder(){
        this.agvStatus.changeStatusOfAGVForGivenOrder();
    }

    public void assignATaskForAGV(AGVTask task){
        this.agvTask.add(task);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void changeAGVId(AGVId id){this.agvId=id;}

    public void activateSensors(){
        if(sensorList == null)
            this.sensorList = Sensor.getSensors(this);
        for(Sensor sensor : sensorList)
            sensor.start();
    }

    public List<Sensor> getSensors(){
        return sensorList;
    }

    public void activateControlSystem(){
        this.controlSystem = new ControlSystem(this);
        Thread csThread = controlSystem.getControlSystemThread();
        csThread.start();
    }

    public void deactivateSensors(){
        for(var sensor : sensorList)
            sensor.deactivate();
    }

    public AGVBattery getBattery() {
        return battery;
    }


    public void updateAGVPosition(String agvPosition){
        this.position.setAgvPosition(agvPosition);
    }

}