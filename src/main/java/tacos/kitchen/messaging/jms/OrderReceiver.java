package tacos.kitchen.messaging.jms;

import tacos.TacoOrder;

public interface OrderReceiver {

  TacoOrder receiveOrder();
}
