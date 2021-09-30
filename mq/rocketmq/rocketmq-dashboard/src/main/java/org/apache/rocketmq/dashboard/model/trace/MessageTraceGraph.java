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
import org.apache.rocketmq.dashboard.model.MessageTraceView;

import java.util.List;


public class MessageTraceGraph {
    private ProducerNode producerNode;
    private List<SubscriptionNode> subscriptionNodeList;
    private List<MessageTraceView> messageTraceViews;

    public ProducerNode getProducerNode() {
        return producerNode;
    }

    public MessageTraceGraph setProducerNode(ProducerNode producerNode) {
        this.producerNode = producerNode;
        return this;
    }

    public List<SubscriptionNode> getSubscriptionNodeList() {
        return subscriptionNodeList;
    }

    public MessageTraceGraph setSubscriptionNodeList(List<SubscriptionNode> subscriptionNodeList) {
        this.subscriptionNodeList = subscriptionNodeList;
        return this;
    }

    public List<MessageTraceView> getMessageTraceViews() {
        return messageTraceViews;
    }

    public MessageTraceGraph setMessageTraceViews(List<MessageTraceView> messageTraceViews) {
        this.messageTraceViews = messageTraceViews;
        return this;
    }
}
