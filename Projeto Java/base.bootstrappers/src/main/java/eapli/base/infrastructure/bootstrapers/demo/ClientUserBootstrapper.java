/*
 * Copyright (c) 2013-2021 the original author or authors.
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
package eapli.base.infrastructure.bootstrapers.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eapli.base.clientusermanagement.application.AcceptRefuseSignupFactory;
import eapli.base.clientusermanagement.application.AcceptRefuseSignupRequestController;
import eapli.base.clientusermanagement.domain.SignupRequest;
import eapli.base.infrastructure.bootstrapers.TestDataConstants;
import eapli.base.myclientuser.application.SignupController;
import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;

/**
 *
 * @author Paulo Sousa
 */
public class ClientUserBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            ClientUserBootstrapper.class);

    private final SignupController signupController = new SignupController();
    private final AcceptRefuseSignupRequestController acceptController = AcceptRefuseSignupFactory
            .build();

    @Override
    public boolean execute() {
        signupAndApprove(TestDataConstants.USER_TEST1, "Password1", "John", "Smith",
                "john@smith.com", TestDataConstants.USER_TEST1);
        signupAndApprove("isep959", "Password1", "Carlota", "Smith", "arianasobral26@outlook.pt", "isep959");
        signupAndApprove("isep9", "Password1", "Manuela", "Smith", "manuela@isep.ipp.pt", "isep9");
        signupAndApprove("isep95", "Password1", "Francisco", "Smith", "francisco@isep.ipp.pt", "isep95");
        signupAndApprove("isep99", "Password1", "Pedro", "Smith", "pedro@isep.ipp.pt", "isep99");
        signupAndApprove("isep59", "Password1", "Rita", "Smith", "rita@isep.ipp.pt", "isep59");
        signupAndApprove("isep5", "Password1", "Diogo", "Smith", "locenzo@isep.ipp.pt", "isep5");
        signupAndApprove("isep", "Password1", "Ines", "Smith", "ines@isep.ipp.pt", "isep");
        signupAndApprove("isep0", "Password1", "Luis", "Smith", "busto@isep.ipp.pt", "isep0");
        signupAndApprove("isep1", "Password1", "Daniel", "Smith", "leitao@isep.ipp.pt", "isep1");
        signupAndApprove("isep2", "Password1", "Diogo", "Smith", "diogo@isep.ipp.pt", "isep2");
        signupAndApprove("isep22", "Password1", "Joao Pedro", "Smith", "joaoPedro@gmail.com", "isep22");
        signupAndApprove("isep3", "Password1", "Tiago", "Smith", "tiago@isep.ipp.pt", "isep3");
        return true;
    }

    private SignupRequest signupAndApprove(final String username, final String password,
            final String firstName, final String lastName, final String email,
            final String mecanographicNumber) {
        SignupRequest request = null;
        try {
            request = signupController.signup(username, password, firstName, lastName, email,
                    mecanographicNumber);
            acceptController.acceptSignupRequest(request);
        } catch (final ConcurrencyException | IntegrityViolationException e) {
            // ignoring exception. assuming it is just a primary key violation
            // due to the tentative of inserting a duplicated user
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", username);
            LOGGER.trace("Assuming existing record", e);
        }
        return request;
    }
}
