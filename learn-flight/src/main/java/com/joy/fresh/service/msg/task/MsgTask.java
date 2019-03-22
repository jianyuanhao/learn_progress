package com.joy.fresh.service.msg.task;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.joy.fresh.service.msg.Constants;
import com.joy.fresh.service.msg.Message;
import com.joy.fresh.service.msg.MessageService;

/**
 * Created by jianyuanhao on 19-3-13.
 */
@Service
public class MsgTask {
    @Resource
    MessageService messageService;

    public void doMsgTask() { // 12:00拉10:00-11:30拉msg==init消息
        List<Message> msgList = Lists.newArrayList();

        for (Message msg : msgList) {
            //定时处理sent消息未发送和消息未可靠发送情况，直至最终一致性为END　
            if (msg.getStatus() == Constants.MessageStatus.INIT) {
                if (checkOrder(msg.getBizId())) {
                    // 订单创建成功　sent消息失败　重新发消息
                    msg.setStatus(Constants.MessageStatus.SENT);
                    messageService.receiveMsg(msg);
                } else {
                    // 订单创建失败　丢弃消息　状态置为END
                    msg.setStatus(Constants.MessageStatus.END);
                }

            }
        }
    }

    private boolean checkOrder(Integer bizId) {
        return true;
    }
}
