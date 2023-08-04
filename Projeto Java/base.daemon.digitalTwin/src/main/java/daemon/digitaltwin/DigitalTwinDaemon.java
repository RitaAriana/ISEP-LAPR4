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
package daemon.digitaltwin;

import daemon.digitaltwin.presentation.DigitalTwinProtocolServer;
import digitaltwin.tcpprotocol.server.RequestMessageParser;
import eapli.base.AGV.domain.AGV;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.io.util.Console;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public final class DigitalTwinDaemon {

    private static final int TWIN_PORT = 8891;
    private static final Logger LOGGER = LogManager.getLogger(DigitalTwinDaemon.class);

    /**
     * Avoid instantiation of this class.
     */
    private DigitalTwinDaemon() {
    }

    public static void main(final String[] args) {
        LOGGER.info("Configuring the daemon");

        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(), new PlainTextEncoder());

        var agv = selectAGV();

        LOGGER.info("Starting the server socket");
        final var server = new DigitalTwinProtocolServer(buildServerDependencies(), agv);
        server.start(TWIN_PORT, true);

        LOGGER.info("Exiting the daemon");
        System.exit(0);
    }

    private static RequestMessageParser buildServerDependencies() {
        return new RequestMessageParser();
    }

    private static AGV selectAGV(){
        var agvList = (List<AGV>) PersistenceContext.repositories().agv().findAll();

        System.out.println("\n\n==================\n");
        System.out.println("Please select an AGV:");
        for(int i = 0; i < agvList.size(); i++)
            System.out.printf("%d. AGV with ID %s\n", (i+1), agvList.get(i).getAgvId().getAGVId());

        System.out.println("\n\n==================\n");
        System.out.println("Please insert your option");
        int option = Console.readOption(1, agvList.size(), 0);
        System.out.println("\n\n==================\n");

        return agvList.get(option - 1);
    }
}
