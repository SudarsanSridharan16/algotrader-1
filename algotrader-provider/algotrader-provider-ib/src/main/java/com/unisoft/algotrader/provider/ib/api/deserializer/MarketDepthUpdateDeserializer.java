package com.unisoft.algotrader.provider.ib.api.deserializer;

import com.unisoft.algotrader.provider.ib.IBProvider;
import com.unisoft.algotrader.provider.ib.api.model.constants.BookSide;
import com.unisoft.algotrader.provider.ib.api.model.constants.IncomingMessageId;
import com.unisoft.algotrader.provider.ib.api.model.constants.Operation;

import java.io.InputStream;

import static com.unisoft.algotrader.provider.ib.InputStreamUtils.readDouble;
import static com.unisoft.algotrader.provider.ib.InputStreamUtils.readInt;

/**
 * Created by alex on 8/13/15.
 */
public class MarketDepthUpdateDeserializer extends Deserializer {


    public MarketDepthUpdateDeserializer(){
        super(IncomingMessageId.MARKET_DEPTH_UPDATE);
    }

    @Override
    public void consumeVersionLess(final int version, final InputStream inputStream, final IBProvider ibProvider) {
        final int requestId = readInt(inputStream);
        final int rowId = readInt(inputStream);
        final int operation = readInt(inputStream);
        final int bookSide = readInt(inputStream);
        final double price = readDouble(inputStream);
        final int size = readInt(inputStream);

        ibProvider.onMarketDepthUpdateEvent(requestId, rowId, Operation.fromValue(operation),
                BookSide.fromValue(bookSide), price, size);
    }
}