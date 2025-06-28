package com.controller.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.entities.Order;
import com.model.utils.OrderDBUtil;

@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String orderId = request.getParameter("orderId");

        // 1. Get order details to retrieve quantity and productId
        List<Order> orderData = OrderDBUtil.getInstance().getOrderDetails(orderId);

        boolean isStockRestored = false;
        boolean isDeleted = false;

        if (!orderData.isEmpty()) {
            Order order = orderData.get(0);
            int quantity = order.getQuantity();
            int productId = order.getProductId();

            // 2. Restore stock
            isStockRestored = OrderDBUtil.getInstance().addStock(productId, quantity);
            System.out.println("restock status "+ isStockRestored);
            System.out.println("ProductID "+ productId);
            System.out.println("Quantity "+ quantity);

            // 3. Proceed with deletion only if stock was successfully restored
            if (isStockRestored) {
                isDeleted = OrderDBUtil.getInstance().deleteOrder(orderId);
            }
        }

        if (isDeleted) {
            RequestDispatcher dis = request.getRequestDispatcher("AddOrder.jsp");
            dis.forward(request, response);
        } else {
            request.setAttribute("orderData", orderData);
            RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
            dis2.forward(request, response);
        }
    }
}
