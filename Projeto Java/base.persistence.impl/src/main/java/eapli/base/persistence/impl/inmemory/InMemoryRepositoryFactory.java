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
package eapli.base.persistence.impl.inmemory;

import eapli.base.AGV.repositories.AGVRepository;
import eapli.base.AGV.repositories.AGVTaskRepository;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.clientmanagement.repositories.ClientRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;

import eapli.base.ordermanagement.repository.OrderRepository;
import eapli.base.productmanagement.repository.ProductRepository;
import eapli.base.shoppingcarmanagement.repository.ShopCarItemRepository;
import eapli.base.shoppingcarmanagement.repository.ShoppingCarRepository;
import eapli.base.surveymanagement.repository.AnswerRepository;
import eapli.base.surveymanagement.repository.SurveyRepository;
import eapli.base.warehouse.repositories.*;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory{

    static {
        // only needed because of the in memory persistence
        new BaseBootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public ClientUserRepository clientUsers(final TransactionalContext tx) {

        return new InMemoryClientUserRepository();
    }

    @Override
    public ClientUserRepository clientUsers() {
        return clientUsers(null);
    }

    @Override
    public ClientRepository client() {
        return new InMemoryClientRepository();
    }

    @Override
    public AnswerRepository answers() {
        return new InMemoryAnswerRepository();
    }

    @Override
    public ShoppingCarRepository shoppingCar() {
        return new InMemoryShoppingCarRepository();
    }

    @Override
    public ShopCarItemRepository shoppingCarItem() {
        return new InMemoryShopCarItemRepository();
    }

    @Override
    public ProductRepository products() {
        return new  InMemoryProductRepository();
    }

    @Override
    public SurveyRepository surveys() {
        return new InMemorySurveyRepository();
    }

    @Override
    public OrderRepository orders() {
        return new InMemoryOrderRepository();
    }

    @Override
    public OrderRepository orders(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public CategoryRepository category() {
        return new InMemoryCategoryRepository();
    }

    @Override
    public AGVDockRepository dock(){return new InMemoryAGVDockRepository();}

    @Override
    public AGVTaskRepository agvTask(){return new InMemoryAGVTaskRepository();}

    @Override
    public AisleRepository aisle(){return new InMemoryAisleRepository();}

    @Override
    public LineRepository line(){return new InMemoryLineRepository();}

    @Override
    public ShelfRepository shelf(){return new InMemoryShelfRepository();}

    @Override
    public BinRepository bin(){return new InMemoryBinRepository();}

    @Override
    public WarehousePlantRepository plant(){return new InMemoryPlantRepository();}

    @Override
    public WarehouseRepository warehouse(){return new InMemoryWarehouseRepository();}

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public AGVRepository agv() {
        return new InMemoryAGVRepository();
    }

    @Override
    public AGVRepository agv(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

}
