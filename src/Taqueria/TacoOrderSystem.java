package Taqueria;

import Taqueria.Order.Order;
import Taqueria.Order.Status;

import java.io.*;
import java.util.ArrayList;

public class TacoOrderSystem {

    ArrayList<Order> activeOrderList;
    ArrayList<Order> finishedOrderList;

    public TacoOrderSystem(){
    }

    public void createOrder(){
    }

    public String searchOrdersByStatus(Status status, ArrayList<Order> orderList){ //vill vi kunna söka i bägge listor?
        String temp = "";
        return temp;
    }

    public String searchOrder(String id, ArrayList<Order> activeOrderList, ArrayList<Order> finishedOrderList){ //är metodnamnet passande?
        String temp = "";
        return temp;
    }
    public void changeOrderStatus(int id, Status status){

    }
    public void updateKitchenGUI(ArrayList<Order> activeOrderList){

    }
}