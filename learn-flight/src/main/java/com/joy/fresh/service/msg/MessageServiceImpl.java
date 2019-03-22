package com.joy.fresh.service.msg;

import org.springframework.stereotype.Service;

/**
 * Created by jianyuanhao on 19-3-13.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public void receiveMsg(Message msg) {
        switch (msg.getStatus()) {
        case Constants.MessageStatus.INIT:
            // save msg
            System.out.println("保存初始消息");
            break;
        case Constants.MessageStatus.SENT:
            // 发送消息，更改状态为sent
            if (msg.getBizType() == "your business queue") {

            }
            System.out.println("");
            break;
        case Constants.MessageStatus.END:
            // 更改消息为end
            break;

        }
    }
}
