package com.shaunthomas999.advanced.collections.common;

import java.util.Map;

public class MapCollectionSample {

  enum Token {
    RED,
    GREEN,
    BLUE,
    WHITE,
    BLACK
  }

  record Player(Map<Token, Integer> money){}
  record Card(Map<Token, Integer> cost){}

  public static boolean canPurchase(Card card, Player player) {
    for(Map.Entry<Token, Integer> entry : card.cost.entrySet()) {
      if (!player.money.containsKey(entry.getKey())) {
        return false;
      }
      if (player.money.get(entry.getKey()) < entry.getValue()) {
        return false;
      }
    }

    return true;
  }
}
