package com.unisoft.algotrader.provider.ib.api.serializer;

import com.unisoft.algotrader.provider.ib.api.model.data.MarketScannerFilter;
import com.unisoft.algotrader.provider.ib.api.model.system.OutgoingMessageId;

/**
 * Created by alex on 8/7/15.
 */
public class MarketScannerSubscriptionRequestSerializer extends Serializer{

    private static final int VERSION = 3;

    public MarketScannerSubscriptionRequestSerializer(int serverCurrentVersion){
        super(serverCurrentVersion);
    }

    public byte [] serialize(long requestId, MarketScannerFilter filter){
        ByteArrayBuilder builder = new ByteArrayBuilder();

        builder.append(OutgoingMessageId.MARKET_SCANNER_SUBSCRIPTION_REQUEST.getId());
        builder.append(VERSION);
        builder.append(requestId);
        appendMarketScannerFilter(builder, filter);
        return builder.toBytes();
    }

    protected void appendMarketScannerFilter(ByteArrayBuilder builder, MarketScannerFilter marketScannerFilter) {
        builder.append(marketScannerFilter.getNumberOfRows());
        builder.append(marketScannerFilter.getInstrument());
        builder.append(marketScannerFilter.getLocationCode());
        builder.append(marketScannerFilter.getScannerCode());
        builder.append(marketScannerFilter.getAbovePrice());
        builder.append(marketScannerFilter.getBelowPrice());
        builder.append(marketScannerFilter.getAboveVolume());
        builder.append(marketScannerFilter.getAboveMarketCapitalization());
        builder.append(marketScannerFilter.getBelowMarketCapitalization());
        builder.append(marketScannerFilter.getAboveMoodyRating());
        builder.append(marketScannerFilter.getBelowMoodyRating());
        builder.append(marketScannerFilter.getAboveSpRating());
        builder.append(marketScannerFilter.getBelowSpRating());
        builder.append(marketScannerFilter.getAboveMaturityDate());
        builder.append(marketScannerFilter.getBelowMaturityDate());
        builder.append(marketScannerFilter.getAboveCouponRate());
        builder.append(marketScannerFilter.getBelowCouponRate());
        builder.append(marketScannerFilter.getExcludeConvertible());
        builder.append(marketScannerFilter.getAboveAverageVolumeOption());
        builder.append(marketScannerFilter.getScannerSettingPairs());
        builder.append(marketScannerFilter.getStockType().getLabel());
    }

}
