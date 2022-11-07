package design.pattern.visitor;

/**
 * @program: algorithmic-total-solution
 * @description: 管理员访问者
 **/
public class ManagerVisitor implements MessageVisitor {

    @Override
    public void visitMessage(Message message) {
        System.out.println("管理员访问消息" + message.getContext());
    }

    @Override
    public void visitImgMessage(ImgMessage imgMessage) {
        System.out.println("管理员访问图片" + imgMessage.getContext() + " " + imgMessage.getUrl());
    }
}

