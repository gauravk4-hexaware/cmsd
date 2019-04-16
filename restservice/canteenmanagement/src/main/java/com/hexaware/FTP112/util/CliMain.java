package com.hexaware.FTP112.util;
import java.util.Scanner;
import com.hexaware.FTP112.factory.MenuFactory;
import com.hexaware.FTP112.factory.OrdersFactory;
import com.hexaware.FTP112.factory.WalletFactory;
import com.hexaware.FTP112.factory.VendorFactory;
import com.hexaware.FTP112.model.Vendor;
import com.hexaware.FTP112.model.Menu;
import com.hexaware.FTP112.model.Orders;
import com.hexaware.FTP112.model.Wallet;
import com.hexaware.FTP112.model.Customer;
import com.hexaware.FTP112.model.OrderStatus;
import com.hexaware.FTP112.factory.CustomerFactory;
import com.hexaware.FTP112.model.OrderItems;

//import java.util.Date;
//import java.text.SimpleDateFormat;
import java.util.List;
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
  //private int quantity;
/**
 * mainMenu method  used to display the option we had in the application.
 */
  private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("-----------------------");
    System.out.println("1. Show Menu");
    System.out.println("2. Place Order");
    System.out.println("3. Personal Details");
    System.out.println("4. Vendor Details");
    System.out.println("5. Show pending orders");
    System.out.println("6. Orders History");
    System.out.println("7. tax calculation for vendor");
    System.out.println("8. Exit");

    mainMenuDetails();
  }
/**
 * mainMenuDetails method  process the option selected from main menu.
 */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showFullMenu();
          break;
        case 2:
          placeOrder();
          break;
        case 3:
          showCustomerDetails();
          break;
        case 4:
          showVendorDetails();
          break;
        case 5:
          showPendingOrders();
          break;
        case 6:
          showOrderHistory();
          break;
        case 7:
          taxCalculation();
        case 8:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose from 1 - 8");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }
/**
 * showFullMenu method  display the menu item stored in database.
 */
  private void showFullMenu() {
    List<Menu> menu = MenuFactory.showMenu();
    System.out.println("----------------------------------------------------------"
        + "---------------------------------------------------------------------------------");
    System.out.printf("%5s %20s %20s %20s %20s %20s %20s", "Menu Id",
        "Menu Name", "Menu Calories", "Vendor Id", "Ratings", "Reviews", "Price");
    System.out.println();
    System.out.println("-----------------------------------------------------------"
        + "---------------------------------------------------------------------------------");

    for (Menu menulist : menu) {
      System.out.format("%5s %20s %20s %20s %20s %20s %20s",
          menulist.getMenId(), menulist.getMenItem(), menulist.getMenCalories(),
          menulist.getVenId(), menulist.getRatings(), menulist.getReviews(), menulist.getMenPrice());
      System.out.println();
    }
  }
/**
 * showWalletBalance method  display the menu item stored in database.
 */
  private void placeOrder() {
    System.out.println("Enter your customer ID");
    int cusId = option.nextInt();
    System.out.println("Enter your customer Password");
    String password = option.next();
    try {
      CustomerFactory.authenticateCustomer(cusId, password);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      placeOrder();
    }
    System.out.println("Enter the food ID");
    int menId = option.nextInt();
    try {
      MenuFactory.findByMenuId(menId);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      placeOrder();
    }
    System.out.println("Enter the quantity");
    int qty = option.nextInt();
    System.out.println("Enter the vendor ID");
    int venId = option.nextInt();
    try {
      MenuFactory.getOrderPrice(menId, venId);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      placeOrder();
    }
    double orderPrice = MenuFactory.getOrderPrice(menId, venId);
    double totalOrderPrice = orderPrice * qty;

    List<Wallet> walletList = WalletFactory.showWallet(cusId);

    System.out.println("--------------------------------------------------------------------------");
    System.out.printf("%10s %20s %20s", "Wallet ID", "Wallet Amount", "Wallet Source");
    System.out.println();
    System.out.println("--------------------------------------------------------------------------");
    for (Wallet wallet : walletList) {
      System.out.format("%10d %20s %20s",
          wallet.getWalletId(), wallet.getWalletAmount(), wallet.getWalletSource());
      System.out.println();
    }
    System.out.println("Your total price:" + orderPrice * qty);
    System.out.println("Enter the wallet id of your choice");
    int walletId = option.nextInt();
    try {
      WalletFactory.getWalletBalance(walletId, cusId);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      mainMenu();
    }
    double walAmount = WalletFactory.getWalletBalance(walletId, cusId);
    if (walAmount > totalOrderPrice) {
      Orders newOrder = new Orders(cusId, venId, totalOrderPrice, walletId);
      int orderId = OrdersFactory.setPlaceOrder(newOrder);
      WalletFactory.updateWalletAmount(walAmount - totalOrderPrice, cusId, walletId);
      double vendorWalletAmount = VendorFactory.getVendorBalance(venId);
      VendorFactory.updateVendorWallet(vendorWalletAmount + totalOrderPrice, venId);
      System.out.println("Your order has been placed.");
      System.out.println();
      System.out.println("Detected amount :" + totalOrderPrice);
      System.out.println();
      System.out.println("Updated wallet balance :" + Math.round(walAmount - totalOrderPrice));
      System.out.println();
      OrderItems orderItem = new OrderItems(menId, orderPrice, qty, orderId);
      OrdersFactory.updateOrderItems(orderItem);
      mainMenu();
    } else {
      System.out.println("You have insufficient balance please choose another wallet.");
    }



  }
/**
 * showCustomerDetails method  display the menu item stored in database.
 */
  private void showCustomerDetails() {
    System.out.println("Enter your customer ID");
    int cusId = option.nextInt();
    System.out.println("Enter your customer Password");
    String password = option.next();
    try {
      CustomerFactory.authenticateCustomer(cusId, password);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      mainMenu();
    }
    List<Customer> customerList = CustomerFactory.showCustomer(cusId);
    double amount = WalletFactory.fetchtotalAmount(cusId);
    System.out.println("-----------------------------------------"
        + "------------------------------------------------------");
    System.out.printf("%10s %20s %25s %20s %15s", "Customer ID", "Customer Name", "Customer Phone Number", "Customer Username", "Wallet Balance");
    System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------------");


    for (Customer customer : customerList) {
      System.out.format("%10d %20s %25s %20s %15s",
                         customer.getCusId(), customer.getCusName(), customer.getCusPhoneNo(), customer.getCusUserName(), amount);
      System.out.println();

    }
  }
/**
 * showVendorDetails method  display the vendor details stored in database.
 */
  private void showVendorDetails() {
    System.out.println("Enter your vendor ID");
    int venId = option.nextInt();
    List<Vendor> vendorList = VendorFactory.showVendor(venId);
    System.out.println("--------------------------------------------------------------------------------------------------");
    System.out.printf("%10s %20s %20s %20s %20s", "Vendor Id", "Vendor Name", "Vendor Phone", "Vendor Username", "Vendor Balance");
    System.out.println();
    System.out.println("--------------------------------------------------------------------------------------------------");

    for (Vendor vendor : vendorList) {
      System.out.format("%10d %20s %20s %20s %20s",
                vendor.getVenId(), vendor.getVenName(), vendor.getVenPhoneNo(), vendor.getVenUsername(), vendor.getVenBalance());
      System.out.println();
    }
  }
/**
 * showOrderHistory method  display the menu item stored in database.
 */
  private void showPendingOrders() {
    System.out.println("Enter The Vendor ID");
    int vendorId = option.nextInt();
    System.out.println("Enter your password");
    String vendorPassword = option.next();
    try {
      VendorFactory.authenticateVendor(vendorId, vendorPassword);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      mainMenu();
    }
    List<OrderItems> pendingList = OrdersFactory.showPendingOrders(vendorId);
    System.out.println("----------------------------------------------------"
        + "-------------------------------------------------------------------------");
    System.out.printf("%10s %20s %20s %20s %20s %20s", "Order Item Id", "Menu Id",
        "Menu price", "Order Status", "Order quantity", "Order id");
    System.out.println();
    System.out.println("----------------------------------------------------"
        + "-------------------------------------------------------------------------");
    for (OrderItems orderItems : pendingList) {
      System.out.format("%10d %20d %20s %20s %20d %20d",
          orderItems.getOrderItemId(), orderItems.getMenId(), orderItems.getPrice(),
          orderItems.getStatus(), orderItems.getQuantity(), orderItems.getOrderId());
      System.out.println();
    }
    System.out.println("Enter the order Item ID");
    int orderItemId = option.nextInt();
    try {
      OrdersFactory.showPendingOrdId(orderItemId);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      mainMenu();
    }
    System.out.println("Enter the desired status :\n1. Accepted\n2. Denied\n3. Exit");
    int status = option.nextInt();
    if (status == 1) {
      OrdersFactory.updateStatus(orderItemId, OrderStatus.ACCEPTED);
    } else if (status == 2) {
      OrdersFactory.updateStatus(orderItemId, OrderStatus.DENIED);
      double price = OrdersFactory.getPrice(vendorId, orderItemId);
      VendorFactory.updateRefund(price, vendorId);
      int customerId = OrdersFactory.getCustomerId(vendorId, orderItemId);
      int walletId = OrdersFactory.getWalletId(orderItemId);
      WalletFactory.refundAmount(price, customerId, walletId);
      OrdersFactory.updateTotalPrice(price, orderItemId);
    } else {
      mainMenu();
    }

  }

  private void showOrderHistory() {
    System.out.println("Order history:\n1. Customer\n2. Vendor");
    int choice = option.nextInt();
    if (choice == 1) {
      System.out.println("Enter The Customer ID");
      int customerId = option.nextInt();
      System.out.println("Enter your customer Password");
      String password = option.next();
      try {
        CustomerFactory.authenticateCustomer(customerId, password);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        mainMenu();
      }
      List<Orders> cusHistory = OrdersFactory.showCustomerHistory(customerId);
      System.out.println("-----------------------------------------------------------"
                         + "------------------------------------------------------------------------------");
      System.out.printf("%5s %13s %13s %20s %24s %20s %18s %15s", "Order ID",
                "Customer ID", "Vendor ID", "Order Date", "Total order Price",
                "Order Status", "Order Comments", "Wallet ID");
      System.out.println();
      System.out.println("------------------------------------------------------------"
                         + "------------------------------------------------------------------------------");

      for (Orders customerHistory : cusHistory) {
        System.out.format("%5s %10s %13s %30s %15s %20s %15s %17s",
                  customerHistory.getOrderId(), customerHistory.getCusId(),
                  customerHistory.getVenId(), customerHistory.getOrderDate(),
                  customerHistory.getTotalOrderPrice(), customerHistory.getOrderStatus(),
                  customerHistory.getOrderComments(), customerHistory.getWalId());
        System.out.println();
      }
    } else if (choice == 2) {
      System.out.println("Enter The Vendor ID");
      int vendorId = option.nextInt();
      System.out.println("Enter your password");
      String vendorPassword = option.next();
      try {
        VendorFactory.authenticateVendor(vendorId, vendorPassword);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
        mainMenu();
      }
      List<Orders> vendorHistory = OrdersFactory.showVendorHistory(vendorId);
      System.out.println("---------------------------------------------------------------"
                      + "----------------------------------------------------------------------");
      System.out.printf(" %5s %13s %13s %20s %24s %20s %18s %15s", "Order Id",
              "Customer ID", "Vendor ID", "Order Date", "Total order Price",
              "Order Status", "Order Comments", "Wallet ID");
      System.out.println();
      System.out.println("----------------------------------------------------------------"
                       + "----------------------------------------------------------------------------");
      for (Orders venHistory : vendorHistory) {
        System.out.format(" %5s %10s %13s %30s %15s %20s %15s %17s",
                venHistory.getOrderId(), venHistory.getCusId(), venHistory.getVenId(),
                venHistory.getOrderDate(), venHistory.getTotalOrderPrice(), venHistory.getOrderStatus(),
                venHistory.getOrderComments(), venHistory.getWalId());
        System.out.println();
      }
    }
  }

  private void taxCalculation() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the Vendor Id");
    int venId = scanner.nextInt();
    System.out.println("Enter the Vendor Password");
    String venPassword = scanner.next();
    try {
      VendorFactory.authenticateVendor(venId, venPassword);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      mainMenu();
    }
    System.out.println("Enter month");
    int month = scanner.nextInt();
    if (month <= 12 && month >= 1) {
      List<Orders> vendorHistoryByDate = OrdersFactory.taxCalculation(venId, month);
      System.out.println("LIST OF ALL THE ORDERS IN THAT SPECIFIC MONTH");
      System.out.println("---------------------------------------------------------------"
                      + "----------------------------------------------------------------------");
      System.out.printf(" %5s %13s %13s %20s %24s %20s %18s %15s", "Order Id",
              "Customer ID", "Vendor ID", "Order Date", "Total order Price",
              "Order Status", "Order Comments", "Wallet ID");
      System.out.println();
      System.out.println("----------------------------------------------------------------"
                       + "----------------------------------------------------------------------------");
      for (Orders venHistory : vendorHistoryByDate) {
        System.out.format(" %5s %10s %13s %30s %15s %20s %15s %17s",
                venHistory.getOrderId(), venHistory.getCusId(), venHistory.getVenId(),
                venHistory.getOrderDate(), venHistory.getTotalOrderPrice(), venHistory.getOrderStatus(),
                venHistory.getOrderComments(), venHistory.getWalId());
        System.out.println();
      }
      double sum = 0;
      for (Orders index : vendorHistoryByDate) {
        sum = sum + index.getTotalOrderPrice();
      }
      System.out.println("sum = " + sum);
      double gst = (sum * 5) / 100;
      System.out.println("gst = " + sum + " * 5 % = " + gst);
      double stateTax = gst / 2;
      System.out.println("stateTax = " + sum + " * 2.5 % = " + stateTax);
      double centralTax = gst / 2;
      System.out.println("centralTax = " + sum + " * 2.5 % = " + centralTax);
    } else {
      System.out.println("enter a valid month");
    }

  }

/**
 * main method  is the basic entry point for the application.
 * @param args used to get the user input.
 */

  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
