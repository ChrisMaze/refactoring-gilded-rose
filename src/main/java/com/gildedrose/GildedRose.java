package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    private Item[] items;

    public Item[] getItems() {
        return items;
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        Arrays.stream(items).forEach(item -> {
                if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.quality = item.quality - 1;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;

                        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (item.sell_in < 11) {
                                item.quality = item.quality + 1;
                            }

                            if (item.sell_in < 6) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }


                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.sell_in = item.sell_in - 1;
                }


                if (item.sell_in < 0) {
                    if (!item.name.equals("Aged Brie")) {
                        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
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
        );
    }
}
