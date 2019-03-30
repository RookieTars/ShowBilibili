package com.example.showbilibili;

import java.util.List;

public class Videos {
    public List<Lists> list;

    public List<Lists> getList() {
        return list;
    }

    public void setList(List<Lists> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Videos{" +
                "list=" + list +
                '}';
    }
}
