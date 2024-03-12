package com.todo.sync.util.paginacion;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class pageRender<T> {

    private String url;
    private Page<T> page;
    private int totalPaginas;
    private int numElementosPorPagina;
    private int paginaActual;
    private List<pageItem> paginas;

    public pageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.paginas = new ArrayList<pageItem>();

        numElementosPorPagina = 5;
        totalPaginas = page.getTotalPages();
        paginaActual = page.getNumber() + 1;

        int from, to;
        if (totalPaginas <= numElementosPorPagina) {
            from = 1;
            to = totalPaginas;
        } else {
            if (paginaActual <= numElementosPorPagina / 2) {
                from = 1;
                to = numElementosPorPagina;
            } else if (paginaActual >= totalPaginas - numElementosPorPagina / 2) {
                from = totalPaginas - numElementosPorPagina + 1;
                to = numElementosPorPagina;
            } else {
                from = paginaActual - numElementosPorPagina / 2;
                to = numElementosPorPagina;
            }
        }
        for (int i = 0; i < to; i++) {
            paginas.add(new pageItem(from + i, paginaActual == from + i));
        }
    }
    public boolean isLast() {
        return page.isLast();
    }
    public boolean isHasNext() {
        return page.hasNext();
    }
    public boolean isHasPrevius() {
        return page.hasPrevious();
    }
}
