package org.onlab.onos.store.service.impl;

import org.onlab.onos.store.service.WriteResult;

public class InternalWriteResult {

    public enum Status {
        OK,
        ABORTED,
        NO_SUCH_TABLE,
        OPTIMISTIC_LOCK_FAILURE,
        PREVIOUS_VALUE_MISMATCH
    }

    private final Status status;
    private final WriteResult result;

    public InternalWriteResult(Status status, WriteResult result) {
        this.status = status;
        this.result = result;
    }

    public Status status() {
        return status;
    }

    public WriteResult result() {
        return result;
    }
}