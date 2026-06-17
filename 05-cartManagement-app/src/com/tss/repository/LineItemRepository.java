package com.tss.repository;

import com.tss.model.LineItem;

import java.util.*;

public class LineItemRepository {
    private static HashMap<Long, LineItem> lineItemHashMap=new HashMap<>();
    public LineItem addLineItem(LineItem lineItem)
    {
        if (lineItemHashMap.containsKey(lineItem.getProductId()))
        {
            lineItemHashMap.get(lineItem.getProductId()).addQuantity(lineItem.getQuantity());
            return null;
        }
        else {
            lineItemHashMap.put(lineItem.getProductId(),lineItem);
            return lineItem;
        }
    }
    public List<LineItem> getAllLineItem()
    {
        return new ArrayList<>(lineItemHashMap.values());
    }
    public List<LineItem> checkAllStockAvailable()
    {
        List<LineItem> outOfStock=new ArrayList<>();
        for (LineItem lineItem:lineItemHashMap.values())
        {
            if (lineItem.getQuantity()>lineItem.getProductQuantity())
                outOfStock.add(lineItem);
        }
        return outOfStock;
    }
    public boolean removeLineItem(long productId)
    {
        if (lineItemHashMap.get(productId)==null)
            return false;
        lineItemHashMap.remove(productId);
        return true;

    }
    public void clear()
    {
        lineItemHashMap.clear();
    }
}
