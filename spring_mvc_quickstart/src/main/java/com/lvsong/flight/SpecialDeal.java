package com.lvsong.flight;

import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lvsong on 7/15/15.
 */
public class SpecialDeal {
    private Airport departFrom;
    private Airport arriveAt;

    private BigDecimal cost;
    private Date beginOn;
    private Date endOn;

    public SpecialDeal(Airport arriveAt, Airport departFrom, BigDecimal cost,
                       Date beginOn, Date endOn) {
        this.arriveAt = arriveAt;
        this.departFrom = departFrom;
        this.cost = cost;
        this.beginOn = beginOn;
        this.endOn = endOn;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public Airport getDepartFrom() {
        return departFrom;
    }

    public Airport getArriveAt() {
        return arriveAt;
    }

    public boolean isValidNow() {
        return isValidOn(new Date());
    }

    public boolean isValidOn(Date date) {
        Assert.notNull(date, "Date must not be null");
        Date dateCopy = new Date(date.getTime());    // 防御性副本

        return ((dateCopy.equals(beginOn) || dateCopy.after(beginOn)) &&
                (dateCopy.equals(endOn) || dateCopy.before(endOn))
        );
    }

}
