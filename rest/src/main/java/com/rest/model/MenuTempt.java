package com.rest.model;

import java.util.List;

/**
 * Created by KaiLin.Guo on 2018-01-12.
 */
public class MenuTempt extends Resources {

    private Boolean hasChild;

    private List<Resources> child;

    public List<Resources> getChild() {
        return child;
    }

    public void setChild(List<Resources> child) {
        this.child = child;
    }

    public Boolean getHasChild() {
        return hasChild;
    }

    public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }
}
