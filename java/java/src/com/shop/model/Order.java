package com.shop.model;

import com.shop.manager.ShopManager;
import com.shop.utils.IdGenerator;

// 주문 정보를 관리하는 클래스 (배열로 간단히 관리)
public class Order {
    private String orderId;           // 주문 ID (자동 생성)
    private String[] productIds;      // 주문한 상품 ID 배열 (크기 10)
    private int[] quantities;         // 각 상품의 수량 배열 (크기 10)
    private int itemCount;            // 현재 담긴 상품 종류 수
    private int totalAmount;          // 총 금액
    private String status;            // 주문 상태: "결제대기", "결제완료", "취소"

    public Order() {
        this.orderId = IdGenerator.getInstance().generateOrderId();
        this.productIds = new String[10];
        this.quantities = new int[10];
        this.itemCount = 0;
        this.totalAmount = 0;
        this.status = "결제대기";
    }

    public String getOrderId() {
        return orderId;
    }

    public String[] getProductIds() {
        return productIds;
    }

    public int[] getQuantities() {
        return quantities;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void addItem(String productId, int quantity){
        if(itemCount >= 10)
            throw new IllegalArgumentException("상품을 더이상 추가할 수 없습니다.");
        else{
            if(quantity >= 1){
                productIds[itemCount] = productId;
                quantities[itemCount] = quantity;
                itemCount++;
            }
        }
    }

    public void calculateTotal(ShopManager manager){
        totalAmount = 0;
        for(int i = 0; i < itemCount; i++){
            totalAmount += manager.findProductById(productIds[i]).getPrice()*quantities[i];
        }
    }

    public void complete(){
        this.status = "결제 완료";
    }
}
