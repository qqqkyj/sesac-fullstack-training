package com.shop.manager;

import com.shop.model.Order;
import com.shop.model.Product;

import java.util.ArrayList;
import java.util.Arrays;

// 상품과 주문을 통합 관리하는 클래스
public class ShopManager {
    private Product[] products;  // 상품 배열 (크기 50)
    private int productCount;    // 현재 등록된 상품 수
    private Order[] orders;      // 주문 배열 (크기 50)
    private int orderCount;      // 현재 주문 수

    public ShopManager() {
        products = new Product[50];
        productCount = 0;
        orders = new Order[50];
        orderCount = 0;
    }

    // 상품 관리
    public void addProduct(Product product){
        if(productCount < products.length){
            products[productCount++] = product;
            System.out.println("[상품 등록] " + product.getName() + " - " + product.getPrice() + "원");
        }
        else
            throw new IllegalArgumentException("상품을 더이상 추가할 수 없습니다.");
    }

    public Product findProductById(String id){
        for(int i = 0; i < productCount; i++){
            if(products[i].getId().equals(id))
                return products[i];
        }
        return null;
    }

    public Product[] searchProductsByName(String keyword){
        Product[] productArr = new Product[productCount];
        int index = 0;
        for(int i = 0; i < productCount; i++){
            if(products[i].getName().toLowerCase().contains(keyword.toLowerCase()))
                productArr[index++] = products[i];
        }
        return Arrays.copyOfRange(productArr, 0, index);
    }

    public Product[] searchProductsByCategory(String category){
        Product[] productArr = new Product[productCount];
        int index = 0;
        for(int i = 0; i < productCount; i++){
            if(products[i].getCategory().equalsIgnoreCase(category))
                productArr[index++] = products[i];
        }
        return Arrays.copyOfRange(productArr, 0, index);
    }

    public void printAllProducts(){
        for(int i = 0; i < productCount; i++){
            System.out.println((i+1) + ". [" + products[i].getId() + "] " + products[i].getName() + " - " + products[i].getPrice() + "원 (재고: " + products[i].getStock() + "개)");
        }
    }

    // 주문 관리
    public Order createOrder(){
        Order order = new Order();
        System.out.println("[주문 생성] " + order.getOrderId());
        return order;
    }

    public void addOrderItem(Order order, String productId, int quantity){
        Product product = findProductById(productId);
        if(product == null)
            throw new IllegalArgumentException("주문하신 상품은 존재하지 않습니다.");
        else {
            if(!product.isAvailable(quantity))
                throw new IllegalArgumentException("재고가 부족합니다.");
            else
                order.addItem(productId, quantity);
        }
    }

//    === 주문 내역 ===
//    주문번호: O1
//----------------------------
//    노트북 x 1 = 1500000원
//    마우스 x 2 = 60000원
//    키보드 x 1 = 80000원
//----------------------------
//    총 금액: 1640000원
    public void processOrder(Order order){
        order.calculateTotal(this);
        System.out.println("=== 주문 내역 ===");
        System.out.println("주문번호: "+order.getOrderId());
        System.out.println("----------------------------");
        for(int i = 0; i < order.getItemCount(); i++){
            Product product = findProductById(order.getProductIds()[i]);
            int quantities = order.getQuantities()[i];
            int price = product.getPrice() * quantities;
            System.out.println(product.getName() + " X " + quantities + " = " + price+"원");
            product.decreaseStock(quantities);
        }
        System.out.println("----------------------------");
        System.out.println("총 금액: " + order.getTotalAmount() + "원");
        
        order.complete();
        orders[orderCount] = order;
        orderCount++;
        System.out.println("[" + order.getStatus() + "] " + order.getOrderId());
    }

    public Order findOrderById(String orderId){
        Order order = null;
        for(int i = 0; i < orderCount; i++){
            if(orderId.equals(orders[i].getOrderId()))
                order = orders[i];
        }
        return order;
    }

    public void printAllOrders(){
        for(int i = 0; i < orderCount; i++){
            System.out.println((i+1) + ". [" + orders[i].getOrderId() + "] " + orders[i].getTotalAmount() + "원 (" + orders[i].getStatus() + ")");
        }
    }

}
