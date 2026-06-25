package com.tss.isp.violation.Repository;

import com.tss.isp.violation.model.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepository {
    List<LibraryItem> libraryItems=new ArrayList<>();
    public void addItem(LibraryItem libraryItem)
    {
        libraryItems.add(libraryItem);
    }
    public LibraryItem getItem(String id)
    {
        for (LibraryItem libraryItem:libraryItems)
        {
            if (libraryItem.getId()==id)
                return libraryItem;
        }
        return null;
    }
}
