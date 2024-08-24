package controller;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.PaymentRequest;
import model.PaymentResponse;
//import model.OrderService;
import model.PaymentService;

@Path("/payment")
public class PaymentController {

    @Inject
    private PaymentService paymentService;

    @Inject
//    private OrderService orderService;

    @POST
    @Path("/process")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response processPayment(PaymentRequest request) {
        boolean paymentSuccess = paymentService.processPayment(request.getCardNumber(), request.getAmount());

        if (paymentSuccess) {
            try {
//                int orderId = orderService.createOrder(request.getAmount());

                int orderId = 1; // \TODO: replace with orderID of some orderService class
            	PaymentResponse response = new PaymentResponse("Order successfully placed!", request.getAmount(), orderId);
                return Response.ok(response).build();
            } catch (Exception e) {
                e.printStackTrace();
                PaymentResponse response = new PaymentResponse("Order creation failed.", 0);
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
            }
        } else {
            PaymentResponse response = new PaymentResponse("Credit Card Authorization Failed. Please try again.", 0);
            return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
        }
    }
}
