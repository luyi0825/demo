/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.dashboard.model.trace;

import lombok.Data;

public class TraceNode {
    private String requestId;
    private String storeHost;
    private String clientHost;
    private int costTime;
    private long beginTimestamp;
    private long endTimestamp;
    private int retryTimes;
    private String status;
    private String transactionState;
    private String transactionId;
    private boolean fromTransactionCheck;
    private String msgType;

    public String getRequestId() {
        return requestId;
    }

    public TraceNode setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public String getStoreHost() {
        return storeHost;
    }

    public TraceNode setStoreHost(String storeHost) {
        this.storeHost = storeHost;
        return this;
    }

    public String getClientHost() {
        return clientHost;
    }

    public TraceNode setClientHost(String clientHost) {
        this.clientHost = clientHost;
        return this;
    }

    public int getCostTime() {
        return costTime;
    }

    public TraceNode setCostTime(int costTime) {
        this.costTime = costTime;
        return this;
    }

    public long getBeginTimestamp() {
        return beginTimestamp;
    }

    public TraceNode setBeginTimestamp(long beginTimestamp) {
        this.beginTimestamp = beginTimestamp;
        return this;
    }

    public long getEndTimestamp() {
        return endTimestamp;
    }

    public TraceNode setEndTimestamp(long endTimestamp) {
        this.endTimestamp = endTimestamp;
        return this;
    }

    public int getRetryTimes() {
        return retryTimes;
    }

    public TraceNode setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TraceNode setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getTransactionState() {
        return transactionState;
    }

    public TraceNode setTransactionState(String transactionState) {
        this.transactionState = transactionState;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public TraceNode setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public boolean isFromTransactionCheck() {
        return fromTransactionCheck;
    }

    public TraceNode setFromTransactionCheck(boolean fromTransactionCheck) {
        this.fromTransactionCheck = fromTransactionCheck;
        return this;
    }

    public String getMsgType() {
        return msgType;
    }

    public TraceNode setMsgType(String msgType) {
        this.msgType = msgType;
        return this;
    }
}
