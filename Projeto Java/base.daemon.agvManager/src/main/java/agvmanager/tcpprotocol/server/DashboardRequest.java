package agvmanager.tcpprotocol.server;

import eapli.base.AGV.application.CallDigitalTwinController;

import java.io.IOException;

public class DashboardRequest extends AGVManagerProtocolRequest{

    private final String agvId;

    /*public DashboardRequest(String agvId, byte[] array) {
        super(new CallDigitalTwinController(), array);
        this.agvId = agvId;
    }*/

    public DashboardRequest(final byte[] receivedArray, final String extraInfo){
        super(new CallDigitalTwinController(),receivedArray);
        this.agvId = extraInfo;
    }

    @Override
    public String execute() {

        try {
            return buildResponse(agvId);
        } catch (final Exception e) {
            // we should be careful about exposing the Exception to the outside!
            return buildServerError(e.getMessage());
        }
    }

    public String buildResponse(final String agvId) throws IOException {
        String info = null;
        try{
            callTwinController.connectDaemon(8891);
            info = callTwinController.getAGVInfo(agvId);
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            callTwinController.closeConnection();
        }
        return info;
    }
}
