package com.gildedrose;

import java.util.Arrays;

class GildedRose {
  public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
  public static final String CONCERT = "Backstage passes to a TAFKAL80ETC concert";
  public static final String AGED_BRIE = "Aged Brie";

  private Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public Item[] getItems() {
    return items;
  }

  public void updateQualityAndSellIn() {
    Arrays.stream(items).forEach(item -> {
      updateQualityByName(item);

      updateSellInByName(item);

      updateQualityBySellIn(item);
    });
  }

  private void updateQualityBySellIn(Item item) {
    if (item.sell_in < 0) {
      if (!item.name.equals(AGED_BRIE)) {
        if (!item.name.equals(CONCERT) && item.quality > 0 && !item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
          item.quality = item.quality - 1;
        } else {
          item.quality = 0;
        }
      } else {
        if (item.quality < 50) {
          item.quality = item.quality + 1;
        }
      }
    }
  }

  private void updateSellInByName(Item item) {
    if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
      item.sell_in = item.sell_in - 1;
    }
  }

  private void updateQualityByName(Item item) {
    if (!item.name.equals(AGED_BRIE)
        && !item.name.equals(CONCERT)) {
      if (item.quality > 0 && !item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
        item.quality = item.quality - 1;
      }
    } else {
      if (item.quality < 50) {
        item.quality = item.quality + 1;
        if (item.name.equals(CONCERT)) {
          if (item.sell_in < 11) {
            item.quality = item.quality + 1;
          }
          if (item.sell_in < 6) {
            item.quality = item.quality + 1;
          }
        }
      }
    }
  }
}
