package net.myapps.springEnterpriseApplication.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author rmandada
 */
public class EmitLogDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("ipsoft");
        factory.setPassword("ipsoft");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String[] severity = {"error", "info", "warning"};
        String[] message = {"Error log", "info log", "warning log"};

        for (int i = 0; i <3 ; i++) {
            channel.basicPublish(EXCHANGE_NAME, severity[i], null, message[i].getBytes());
            System.out.println(" [x] Sent '" + severity[i] + "':'" + message[i] + "'");
        }

        channel.close();
        connection.close();
    }
}
