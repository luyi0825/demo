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
package org.apache.rocketmq.dashboard.model.request;

import lombok.Data;


public class SendTopicMessageRequest {
    private String topic;
    private String key;
    private String tag;
    private String messageBody;
    private boolean traceEnabled;

    public String getTopic() {
        return topic;
    }

    public SendTopicMessageRequest setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public String getKey() {
        return key;
    }

    public SendTopicMessageRequest setKey(String key) {
        this.key = key;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public SendTopicMessageRequest setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public SendTopicMessageRequest setMessageBody(String messageBody) {
        this.messageBody = messageBody;
        return this;
    }

    public boolean isTraceEnabled() {
        return traceEnabled;
    }

    public SendTopicMessageRequest setTraceEnabled(boolean traceEnabled) {
        this.traceEnabled = traceEnabled;
        return this;
    }
}
