package com.unisoft.algotrader.provider.ib.api.serializer;

import com.unisoft.algotrader.provider.ib.api.model.system.OutgoingMessageId;

/**
 * Created by alex on 8/7/15.
 */
public class ServerCurrentTimeRequestSerializer extends Serializer{

    private static final int VERSION = 1;
    public ServerCurrentTimeRequestSerializer(int serverCurrentVersion){
        super(serverCurrentVersion, OutgoingMessageId.SERVER_CURRENT_TIME_REQUEST);
    }

    public byte [] serialize(){

        ByteArrayBuilder builder = getByteArrayBuilder();
        builder.append(messageId.getId());
        builder.append(VERSION);
        return builder.toBytes();
    }

}
