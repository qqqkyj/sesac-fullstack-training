package com.shop.utils;

// 상품 ID와 주문 ID를 자동으로 생성하는 싱글톤 클래스
public class IdGenerator {
    private static IdGenerator instance;  // 싱글톤 인스턴스
    private int productIdCounter;         // 상품 ID 카운터
    private int orderIdCounter;            // 주문 ID 카운터

    private IdGenerator() {
        this.productIdCounter = 1;
        this.orderIdCounter = 1;
    }

    public static IdGenerator getInstance(){
        if(instance == null){
            synchronized (IdGenerator.class) {
                if(instance == null){
                    instance = new IdGenerator();
                }
            }
        }
        return instance;
    }

    //productID
    public String generateProductId(){
        return "P" + productIdCounter++;
    }

    //orderID
    public String generateOrderId(){
        return "O" + orderIdCounter++;
    }
}
