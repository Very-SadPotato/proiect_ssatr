/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.rabbitmq.taxi;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author rares
 */
public class Start {
    
    /**
     * @throws IOException
     * @throws TimeoutException 
     */
    public static void DeclareExchange() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();       
        channel.exchangeDeclare("booking-requests", BuiltinExchangeType.FANOUT, true);
        channel.close();
    }
    
    public static void main(String[] args) throws IOException, TimeoutException {
        
        DeclareExchange();
        
        MainWindow m = new MainWindow();
        m.setVisible(true);
    }
}
