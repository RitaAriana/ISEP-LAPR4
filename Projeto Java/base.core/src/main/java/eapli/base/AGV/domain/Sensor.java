package eapli.base.AGV.domain;

import eapli.base.AGV.modules.WarehouseMovement;

import java.util.ArrayList;
import java.util.List;

public class Sensor extends Thread{

    private final AGV agv;

    private int[][] warehouseMatrix;

    private int x;

    private int y;

    private final int orientation; // 1-CIMA 2-DIREITA 3-BAIXO 4-ESQUERDA

    private int control; //0-ok, 1-para, 2-abranda

    private boolean deactivate;

    private Sensor(final AGV agv, final int orientation){
        this.agv = agv;
        this.orientation = orientation;
        this.deactivate = false;
    }
    public static List<Sensor> getSensors(final AGV agv){
        var sensorList = new ArrayList<Sensor>();
        for(int i = 0; i < 4; i++){
            sensorList.add(new Sensor(agv, i));
            sensorList.add(new Sensor(agv, i));
        }
        return sensorList;
    }

    private void updatePosicao(final String posicao){
        warehouseMatrix = WarehouseMovement.getWarehouseMovement().getGrid();
        var array = posicao.split(",");
        this.x = Integer.parseInt(array[0]);
        this.y = Integer.parseInt(array[1]);
    }

    public void run(){
        while (!deactivate) {
            synchronized (this) {
                updatePosicao(agv.getAgvPosition().getAgvPosition());
                switch (orientation) {
                    case 0:
                        if (isValid(x - 1, y, warehouseMatrix) && warehouseMatrix[x - 1][y] == 2)
                            control = 2;
                        else if (isValid(x - 2, y, warehouseMatrix) && warehouseMatrix[x - 2][y] == 2)
                            control = 1;
                        else
                            control = 0;
                        break;
                    case 1:
                        if (isValid(x, y + 1, warehouseMatrix) && warehouseMatrix[x][y + 1] == 2)
                            control = 2;
                        else if (isValid(x, y + 2, warehouseMatrix) && warehouseMatrix[x][y + 2] == 2)
                            control = 1;
                        else
                            control = 0;
                        break;
                    case 2:
                        if (isValid(x + 1, y, warehouseMatrix) && warehouseMatrix[x + 1][y] == 2)
                            control = 2;
                        else if (isValid(x + 2, y, warehouseMatrix) && warehouseMatrix[x + 2][y] == 2)
                            control = 1;
                        else
                            control = 0;
                        break;
                    case 3:
                        if (isValid(x, y - 1, warehouseMatrix) && warehouseMatrix[x][y - 1] == 2)
                            control = 2;
                        else if (isValid(x, y - 2, warehouseMatrix) && warehouseMatrix[x][y - 2] == 2)
                            control = 1;
                        else
                            control = 0;
                        break;
                }

                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("There was a problem related to the sensors");
                }
                control = 0;
            }
        }
    }

    private static boolean isValid(int x, int y, int[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }

    public int getControl(){
        return control;
    }

    public void disableLock(){
        synchronized (this) {
            this.notify();
        }
    }

    public void deactivate(){
        disableLock();
        deactivate = true;
    }
}