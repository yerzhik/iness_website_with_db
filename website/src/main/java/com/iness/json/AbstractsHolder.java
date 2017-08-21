package com.iness.json;

import com.iness.model.main.Abstract;

import java.util.List;

/**
 * Created by Erjik on 08/07/2016.
 */
public class AbstractsHolder {
    private List<Abstract> oral;
    private List<Abstract> poster;

    public List<Abstract> getOral() {
        return oral;
    }

    public void setOral(List<Abstract> oral) {
        this.oral = oral;
    }

    public List<Abstract> getPoster() {
        return poster;
    }

    public void setPoster(List<Abstract> poster) {
        this.poster = poster;
    }
}
