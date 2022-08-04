package tacos.kitchen.messaging;

import tacos.TacoOrder;

public interface OrderReceiver {

  TacoOrder receiveOrder();
}
