package com.unisoft.algotrader.provider.ib.api.exception;

import com.unisoft.algotrader.provider.ib.api.model.system.ClientMessageCode;

/**
 * Created by alex on 8/26/15.
 */
public class RequestException extends IBApiClientException {
    private final String requestId;

    public RequestException(final RequestException exception) {
        this(exception.getClientMessageCode(), exception.getDetailedMessage(), exception.getRequestId(), exception
                .getCause());
    }

    public RequestException(final ClientMessageCode clientMessageCode, final String detailedMessage,
                            final String requestId, final Throwable cause) {
        super(clientMessageCode, detailedMessage, cause);
        this.requestId = requestId;
    }

    public RequestException(final ClientMessageCode clientMessageCode, final String detailedMessage,
                            final String requestId) {
        this(clientMessageCode, detailedMessage, requestId, null);
    }

    public RequestException(final ClientMessageCode clientMessageCode, final String detailedMessage) {
        this(clientMessageCode, detailedMessage, null, null);
    }

    public final String getRequestId() {
        return requestId;
    }
}
