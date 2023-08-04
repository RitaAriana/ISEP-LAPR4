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
package digitaltwin.tcpprotocol.server;

import eapli.base.AGV.application.CallAGVManagerController;
import eapli.framework.util.Utility;

/**
 * The message parser for the Digital Twin.
 *
 * @author Francisco Redol
 */
@Utility
public class RequestMessageParser {

    public RequestMessageParser(){}

    /**
     * Parse and build the request.
     *
     * @param receivedArray from the Protocol Server
     *
     * @return the processed request
     */
    public DigitalTwinProtocolRequest parse(final byte[] receivedArray, final String extraInfo) {
        DigitalTwinProtocolRequest request = new UnknownRequest(receivedArray);

        if (CallAGVManagerController.DASHBOARD_REQUEST == receivedArray[1])
            request = callAGVInfoRequest(receivedArray, extraInfo);

        return request;
    }

    private DigitalTwinProtocolRequest callAGVInfoRequest(final byte[] receivedArray, String extraInfo) {
        DigitalTwinProtocolRequest request;

        if (receivedArray.length != 4)
            request = new BadRequest(receivedArray, "Wrong number of parameters");
        else
            request = new GetAGVInfoRequest(receivedArray, extraInfo);

        return request;
    }

}