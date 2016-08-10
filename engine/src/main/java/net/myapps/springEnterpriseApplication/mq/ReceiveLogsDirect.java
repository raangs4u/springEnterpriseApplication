package net.myapps.springEnterpriseApplication.mq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author rmandada
 */
public class ReceiveLogsDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("ipsoft");
        factory.setPassword("ipsoft");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        //String queueName = channel.queueDeclare().getQueue();

        String[] argv = {"warning", "info", "error"};
        String[] queues = {channel.queueDeclare().getQueue(), channel.queueDeclare().getQueue(),channel.queueDeclare().getQueue()};

        for (int i = 0; i <3 ; i++) {
            channel.queueBind(queues[i], EXCHANGE_NAME, argv[i]);
        }

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        for (int i = 0; i <3 ; i++) {
            channel.basicConsume(queues[i], true, consumer);
        }

    }
}
