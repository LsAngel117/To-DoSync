package com.todo.sync.util.paginacion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class pageItem {

    private int num;
    private boolean actual;

    public pageItem(int num, boolean actual) {
        this.num = num;
        this.actual = actual;
    }
}
