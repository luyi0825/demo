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

import java.util.List;

public class ProducerNode {
    private String msgId;
    private String tags;
    private String keys;
    private String offSetMsgId;
    private String topic;
    private String groupName;
    private TraceNode traceNode;
    private List<TraceNode> transactionNodeList;

    public String getMsgId() {
        return msgId;
    }

    public ProducerNode setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }

    public String getTags() {
        return tags;
    }

    public ProducerNode setTags(String tags) {
        this.tags = tags;
        return this;
    }

    public String getKeys() {
        return keys;
    }

    public ProducerNode setKeys(String keys) {
        this.keys = keys;
        return this;
    }

    public String getOffSetMsgId() {
        return offSetMsgId;
    }

    public ProducerNode setOffSetMsgId(String offSetMsgId) {
        this.offSetMsgId = offSetMsgId;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public ProducerNode setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public ProducerNode setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public TraceNode getTraceNode() {
        return traceNode;
    }

    public ProducerNode setTraceNode(TraceNode traceNode) {
        this.traceNode = traceNode;
        return this;
    }

    public List<TraceNode> getTransactionNodeList() {
        return transactionNodeList;
    }

    public ProducerNode setTransactionNodeList(List<TraceNode> transactionNodeList) {
        this.transactionNodeList = transactionNodeList;
        return this;
    }
}
