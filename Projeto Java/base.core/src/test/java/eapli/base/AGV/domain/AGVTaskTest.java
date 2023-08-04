package eapli.base.AGV.domain;

import eapli.base.categorymanagement.domain.AlphanumericCode;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.Description;
import eapli.base.categorymanagement.domain.SuperCategory;
import eapli.base.clientmanagement.domain.*;
import eapli.base.ordermanagement.domain.Address;
import eapli.base.ordermanagement.domain.OrderItem;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.domain.Shipment;
import eapli.base.productmanagement.domain.*;
import eapli.base.warehouse.domain.AGVDock;
import eapli.framework.general.domain.model.Money;
import eapli.framework.time.util.Calendars;
import  org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AGVTaskTest {

    private static final Name CLIENT_NAME = Name.valueOf("Rita Ariana","de Castro Ribeiro e Pereira Sobral");
    private static final Email CLIENT_EMAIL = Email.valueOf("arianasobral26@outlook.pt");
    private static final VAT CLIENT_VAT = VAT.valueOf("PT999999999");
    private static final PhoneNumber CLIENT_PHONE_NUMBER = PhoneNumber.valueOf("+351939213522");
    private static final PostalAddress CLIENT_POSTAL_ADDRESS = PostalAddress.valueOf("Rua do Ouro","353","4505-102","Aveiro","Portugal");
    private static final AGVId ID = new AGVId("12345678");
    private static final BriefDescription DESCRIPTION = new BriefDescription("abcdefg");
    private static final MaxWeightCapacity WEIGHT = new MaxWeightCapacity(300.00);
    private static final MaxVolumeCapacity VOLUME = new MaxVolumeCapacity(600.00);
    private static final Model MODEL = new Model("2.1.1.1");
    private static final Range RANGE = new Range(5.0);
    private static final AGVPosition POSITION = new AGVPosition("s");
    private static final AGVDock DOCK = new AGVDock();
    private static final AGVStatus STATUS = new AGVStatus(AGVStatus.Status.FREE);
    private static final Address ADDRESS = new Address("Rua 10", "25", "4535-334", "Aveiro", "Portugal");
    private static Calendar DATE = null;
    private static final UniqueInternalCode uniqueInternalCode = new UniqueInternalCode("123ab4");
    private static final ShortDescription shortDescription = new ShortDescription("frigorífico eficiente");
    private static final ExtendedDescription extendedDescription = new ExtendedDescription("frigorífico eficiente e moderno");
    private static final TechnicalDescription technicalDescription = new TechnicalDescription("frigorífico moderno");
    private static final Barcode barcode = new Barcode("123456789123");
    private static final Money priceWithout = Money.euros(15);
    private static final Money priceWith = Money.euros(16);
    private static final BrandName brandName = new BrandName("Samsung");
    private static final Category category = new Category(new AlphanumericCode("12254bg"),new Description("Eletrodomésticos Modernos Eficientes"),new SuperCategory("Eletrodomésticos Eficientes"));
    private static final Reference reference = new Reference("yh65");
    private  static final Set<Photo> photos = new HashSet<>();


    static {
        try {
            DATE = Calendars.fromDate(new SimpleDateFormat("yyyy/mm/dd").parse("2022/05/28"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private Set<PostalAddress> postalAddresses = new HashSet<>();

    private Client buildClient() {
        postalAddresses.add(CLIENT_POSTAL_ADDRESS);
        return new ClientBuilder().named(CLIENT_NAME).withEmail(CLIENT_EMAIL).withVAT(CLIENT_VAT).withPhoneNumber(CLIENT_PHONE_NUMBER).withAddresses(postalAddresses).build();
    }

    private AGV buildAGV(){
        return new AGVBuilder().withId(ID).withBriefDescription(DESCRIPTION).withMaxWeightCapacity(WEIGHT).withMaxVolumeCapacity(VOLUME).withModel(MODEL).withRange(RANGE).withPosition(POSITION).withAGVDock(DOCK).withAGVStatus(STATUS).build();
    }

    private Product createProduct(double weight, double volume){
        Photo photo = new Photo("frigorífico.jpg");
        photos.add(photo);

        return new Product(category,uniqueInternalCode,shortDescription,extendedDescription,technicalDescription,barcode,brandName,reference,priceWithout,priceWith,weight,volume,photos,1L,1L,1L);
    }

    private ProductOrder buildProductOrder(Client client, List<OrderItem> orderItems){
        return new ProductOrder(client, ADDRESS, ADDRESS, Shipment.BLUE, ProductOrder.Payment.PAYPAL, ProductOrder.SourceChannel.EMAIL, DATE, orderItems);
    }

    private List<OrderItem> transformProduct(List<Product> products){
        List<OrderItem> orderItems = new ArrayList<>();
        for (Product p : products){
            orderItems.add(new OrderItem(1, p));
        }
        return  orderItems;
    }

    @Test
    void tryToAddOrdersUntilExtrapolatingTheAGVVolumeLimit() {

        AGV agv = buildAGV();

        agv.assignATaskForAGV(new AGVTask("Description"));

        Client client = buildClient();

        Product p = createProduct(5, 100);
        Product p1 = createProduct(50, 10000);
        Product p2 = createProduct(47, 10000);

        List<Product> products = new ArrayList<>();
        products.add(p);
        products.add(p1);
        products.add(p2);

        List<OrderItem> productOrders = transformProduct(products);

        ProductOrder productOrder = buildProductOrder(client, productOrders);

        boolean result = agv.addOrdersToATask("Description", productOrder);

        assertFalse(result);
    }

    @Test
    void tryToAddOrdersUntilTheAGVVolumeLimit() {

        AGV agv = buildAGV();

        agv.assignATaskForAGV(new AGVTask("Description"));

        Client client = buildClient();

        Product p = createProduct(5, 200);
        Product p1 = createProduct(50, 200);
        Product p2 = createProduct(47, 200);

        List<Product> products = new ArrayList<>();
        products.add(p);
        products.add(p1);
        products.add(p2);

        List<OrderItem> productOrders = transformProduct(products);

        ProductOrder productOrder = buildProductOrder(client, productOrders);

        boolean result = agv.addOrdersToATask("Description", productOrder);

        assertTrue(result);
    }

    @Test
    void tryToAddOrdersUntilExtrapolatingTheAGVWeightLimit() {

        AGV agv = buildAGV();

        agv.assignATaskForAGV(new AGVTask("Description"));

        Client client = buildClient();

        Product p = createProduct(200, 5);
        Product p1 = createProduct(100, 5);
        Product p2 = createProduct(150, 5);

        List<Product> products = new ArrayList<>();
        products.add(p);
        products.add(p1);
        products.add(p2);

        List<OrderItem> productOrders = transformProduct(products);

        ProductOrder productOrder = buildProductOrder(client, productOrders);

        boolean result = agv.addOrdersToATask("Description", productOrder);

        assertFalse(result);
    }

    @Test
    void tryToAddOrdersUntilTheAGVWeightLimit() {

        AGV agv = buildAGV();

        agv.assignATaskForAGV(new AGVTask("Description"));

        Client client = buildClient();

        Product p = createProduct(100, 5);
        Product p1 = createProduct(100, 5);
        Product p2 = createProduct(100, 5);

        List<Product> products = new ArrayList<>();
        products.add(p);
        products.add(p1);
        products.add(p2);

        List<OrderItem> productOrders = transformProduct(products);

        ProductOrder productOrder = buildProductOrder(client, productOrders);

        boolean result = agv.addOrdersToATask("Description", productOrder);

        assertTrue(result);
    }

    @Test
    void tryToAddOrdersUntilExtrapolatingTheAGVWeightLimitAndVolumeLimit() {

        AGV agv = buildAGV();

        agv.assignATaskForAGV(new AGVTask("Description"));

        Client client = buildClient();

        Product p = createProduct(200, 500);
        Product p1 = createProduct(100, 200);
        Product p2 = createProduct(150, 150);

        List<Product> products = new ArrayList<>();
        products.add(p);
        products.add(p1);
        products.add(p2);

        List<OrderItem> productOrders = transformProduct(products);

        ProductOrder productOrder = buildProductOrder(client, productOrders);

        boolean result = agv.addOrdersToATask("Description", productOrder);

        assertFalse(result);
    }

    @Test
    void tryToAddOrdersUntilTheAGVWeightLimitAndVolumeLimit() {

        AGV agv = buildAGV();

        agv.assignATaskForAGV(new AGVTask("Description"));

        Client client = buildClient();

        Product p = createProduct(100, 200);
        Product p1 = createProduct(100, 200);
        Product p2 = createProduct(100, 200);

        List<Product> products = new ArrayList<>();
        products.add(p);
        products.add(p1);
        products.add(p2);

        List<OrderItem> productOrders = transformProduct(products);

        ProductOrder productOrder = buildProductOrder(client, productOrders);

        boolean result = agv.addOrdersToATask("Description", productOrder);

        assertTrue(result);
    }



}