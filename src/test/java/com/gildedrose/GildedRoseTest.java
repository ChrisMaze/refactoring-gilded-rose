package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQualityAndSellIn();
        Item[] appItems = app.getItems();
        assertEquals("foo", appItems[0].name);
        assertThat(appItems[0].quality, is(4));
        assertThat(appItems[0].sell_in, is(0));
    }

}
