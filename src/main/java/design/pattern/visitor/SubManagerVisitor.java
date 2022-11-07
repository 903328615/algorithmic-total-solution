package design.pattern.visitor;

/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-12-29
 **/
public class SubManagerVisitor implements MessageVisitor{
    @Override
    public void visitMessage(Message message) {
        System.out.println("子管理员访问消息" + message.getContext());
    }

    @Override
    public void visitImgMessage(ImgMessage imgMessage) {
        System.out.println("子管理员访问图片" + imgMessage.getContext() + " " + imgMessage.getUrl());
    }
}

