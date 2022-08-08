package tacos.kitchen.messaging.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import tacos.TacoOrder;
import tacos.kitchen.KitchenUI;

@Component
public class OrderListener {
  private KitchenUI ui;

  public OrderListener(KitchenUI ui) {
    this.ui = ui;
  }

  @KafkaListener(topics = "tacocloud.orders.topic")
  public void handle(TacoOrder order) {
    ui.displayOrder(order);
  }
}
