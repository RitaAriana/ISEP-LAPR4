/*
 * Copyright (c) 2013-2022 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package agvmanager.tcpprotocol.server;

import eapli.base.AGV.application.CallAGVManagerController;
import eapli.framework.csv.util.CsvLineMarshaler;
import eapli.framework.util.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;

/**
 * The message parser for the Booking protocol.
 *
 * @author Paulo Gandra Sousa 01/06/2020
 */
@Utility
public class RequestMessageParser {

    private static final Logger LOGGER = LogManager.getLogger(RequestMessageParser.class);

    public RequestMessageParser() {}

    /**
     * Parse and build the request
     * @param receivedArray
     * @param extraInfo
     * @return
     */
    public AGVManagerProtocolRequest parse(final byte[] receivedArray, final String extraInfo) {

        AGVManagerProtocolRequest request;
        if (receivedArray.length != 4) {
            request = new ErrorInRequest(receivedArray, "Wrong number of parameters");

        } else if (receivedArray[2]==0 && receivedArray[3]==0) {
            request = new ErrorInRequest(receivedArray, "File name must be Pointed");

        } else {
            request = new DashboardRequest(receivedArray,extraInfo);
        }


        // as a fallback make sure we return unknown
        request = null;

        if (CallAGVManagerController.CALL_FIFO == receivedArray[1])
            request = callTaskAssignment(receivedArray, extraInfo);

        if (CallAGVManagerController.DASHBOARD_REQUEST == receivedArray[1])
            request = callAGVInfo(receivedArray, extraInfo);

        return request;
    }

    private AGVManagerProtocolRequest callTaskAssignment(final byte[] receivedArray, String extraInfo) {
        AGVManagerProtocolRequest request;

        if (receivedArray.length != 4) {
            request = new BadRequest(receivedArray, "Wrong number of parameters");
        } else{
            request = new AssignTasksRequest(receivedArray,extraInfo);
        }
        return request;
    }


    private AGVManagerProtocolRequest callAGVInfo(final byte[] receivedArray, String extraInfo) {
        AGVManagerProtocolRequest request;
        if (receivedArray.length != 4) {
            request = new ErrorInRequest(receivedArray, "Wrong number of parameters");
        } else {
            request = new DashboardRequest(receivedArray, extraInfo);
        }

        return request;
    }
}