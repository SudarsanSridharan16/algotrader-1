package com.unisoft.algotrader.provider.ib.api.event;

import com.unisoft.algotrader.provider.ib.api.model.CommissionReport;

/**
 * Created by alex on 8/26/15.
 */
public class CommissionReportEvent extends IBEvent<CommissionReportEvent>  {

    public final CommissionReport commissionReport;

    public CommissionReportEvent(final CommissionReport commissionReport){
        this.commissionReport = commissionReport;
    }

    @Override
    public void on(IBEventHandler handler) {
        handler.onCommissionReportEvent(this);
    }

    @Override
    public String toString() {
        return "CommissionReportEvent{" +
                "commissionReport=" + commissionReport +
                "} " + super.toString();
    }
}