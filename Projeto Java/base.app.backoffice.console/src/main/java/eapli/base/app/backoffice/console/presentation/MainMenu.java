/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.console.presentation;

import eapli.base.Application;
import eapli.base.app.backoffice.console.categorymanagement.CreateCategoriaUI;
import eapli.base.app.backoffice.console.clientmanagement.RegisterClientUI;
import eapli.base.app.backoffice.console.ordermanagement.ForceOrderPrepUI;
import eapli.base.app.backoffice.console.ordermanagement.RegisterClientOrderUI;
import eapli.base.app.backoffice.console.ordermanagement.ViewOrdersSentToCustomerUI;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.console.presentation.authz.ImportJsonUI;
import eapli.base.app.backoffice.console.presentation.authz.ListUsersAction;
import eapli.base.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eapli.base.app.backoffice.console.productmanagement.ListProductUi;
import eapli.base.app.backoffice.console.productmanagement.RegisterProductUI;
import eapli.base.app.backoffice.console.surveymanagement.NewQuestionnaireUI;
import eapli.base.app.backoffice.console.surveymanagement.ObterRelatorioEstatisticoUI;
import eapli.base.app.backoffice.console.taskManagement.TaskManagementUI;
import eapli.base.app.backoffice.console.warehouseEmployeeManagement.ConfigureAGVUI;
import eapli.base.app.backoffice.console.warehouseEmployeeManagement.DashboardUI;
import eapli.base.app.backoffice.console.warehouseEmployeeManagement.ListOrderBeingPreparedByAGVUI;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    // SETTINGS
    private static final int SET_KITCHEN_ALERT_LIMIT_OPTION = 1;


    // SALES CLERK
    private static final int REGISTER_CLIENT = 1;
    private static final int CREATE_CATEGORY = 2;
    private static final int REGISTER_CLIENT_ORDER = 3;
    private static final int REGISTER_PRODUCT = 4;
    private static final int CREATE_CATALOG = 5;
    private static final int ORDERS_DISPATCHED_FOR_COSTUMER = 6;

    //WAREHOUSE EMPLOYEE
    private static final int AGV_CONFIGURATION = 1;
    private static final int IMPORT_JSONFILE = 2;
    private static final int LIST_ORDERS = 3;
    private static final int FORCE_ORDERS_PREPARATION = 4;
    private static final int CALL_FIFO = 5;
    private static final int DASHBOARD = 6;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int CONFIGURE_OPTION = 3;
    private static final int SETTINGS_OPTION = 4;

    // SALES MANAGER
    private static final int CREATE_NEW_QUESTIONNAIRE = 1;
    private static final int REPORT = 2;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.SALES_CLERK)) {
            final Menu usersMenu = buildSalesClerkMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.WAREHOUSE_EMPLOYEE)) {
            final Menu usersMenu = buildWarehouseEmployeeMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);

            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);

        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.SALES_MANAGER)) {
            final Menu usersMenu = buildSalesManagerMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }


    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildSalesClerkMenu() {
        final Menu menu = new Menu("Sales Clerk >");

        menu.addItem(REGISTER_CLIENT, "Register a Client", new RegisterClientUI()::show);
        menu.addItem(CREATE_CATEGORY, "Create a Category", new CreateCategoriaUI()::show);
        menu.addItem(REGISTER_CLIENT_ORDER, "Register a Client Order", new RegisterClientOrderUI()::show);
        menu.addItem(REGISTER_PRODUCT, "Register a Product", new RegisterProductUI()::show);
        menu.addItem(CREATE_CATALOG, "Create a catalog:", new ListProductUi()::show);
        menu.addItem(ORDERS_DISPATCHED_FOR_COSTUMER, "View Order Dispatched for Costumer:", new ViewOrdersSentToCustomerUI()::show);
        return menu;
    }

    private Menu buildWarehouseEmployeeMenu() {
        final Menu menu = new Menu("Warehouse Employee >");

        menu.addItem(AGV_CONFIGURATION, "AGV Configuration", new ConfigureAGVUI()::show);
        menu.addItem(IMPORT_JSONFILE, "Import a Warehouse's Info", new ImportJsonUI()::show);
        menu.addItem(LIST_ORDERS, "List Orders being prepared by an AGV", new ListOrderBeingPreparedByAGVUI()::show);
        menu.addItem(FORCE_ORDERS_PREPARATION, "Force Order Preparation", new ForceOrderPrepUI()::show);
        menu.addItem(CALL_FIFO, "Call FIFO", new TaskManagementUI()::show);
        menu.addItem(DASHBOARD, "Dashboard", new DashboardUI()::show);


        return menu;
    }

    private Menu buildSalesManagerMenu() {
        final Menu menu = new Menu("Sales Manager >");

        menu.addItem(CREATE_NEW_QUESTIONNAIRE, "Create New Questionnaire", new NewQuestionnaireUI()::show);
        menu.addItem(REPORT, "Get a statistical report", new ObterRelatorioEstatisticoUI()::show);

        return menu;
    }


}
