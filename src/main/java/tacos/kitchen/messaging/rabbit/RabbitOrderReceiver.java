package tacos.kitchen.messaging.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import tacos.TacoOrder;
import tacos.kitchen.messaging.OrderReceiver;

@Component
public class RabbitOrderReceiver implements OrderReceiver {

  private RabbitTemplate rabbit;
  private MessageConverter converter;

  @Autowired
  public RabbitOrderReceiver(RabbitTemplate rabbit) {
    this.rabbit = rabbit;
    this.converter = rabbit.getMessageConverter();
  }

  @Override
  public TacoOrder receiveOrder() {
    return rabbit.receiveAndConvert("tacocloud.order",
      new ParameterizedTypeReference<TacoOrder>() {}
    );
  }
}
