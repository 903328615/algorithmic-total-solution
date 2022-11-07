package design.pattern.visitor;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-12-29
 **/
public class SenderVisitor implements MessageVisitor{

    @Override
    public void visitMessage(Message message) {
        System.out.println("发送方访问消息" + message.getContext());
    }

    @Override
    public void visitImgMessage(ImgMessage imgMessage) {
        System.out.println("发送方访问图片" + imgMessage.getContext() + " " + imgMessage.getUrl());
    }
}

