package com.shaunthomas999.advanced.collections.common;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapCollectionSampleTest {

  @Test
  void canPurchase() {

    var player = new MapCollectionSample.Player(Map.of(
        MapCollectionSample.Token.RED, 10,
        MapCollectionSample.Token.BLUE, 30
    ));
    var card = new MapCollectionSample.Card(Map.of(
        MapCollectionSample.Token.GREEN, 10
    ));

    assertFalse(MapCollectionSample.canPurchase(card, player));
  }
}
