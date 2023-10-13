package design.pattern.visitor;


/**
 * @program: algorithmic-total-solution
 * @description:
 * @author: wangzibin
 * @create: 2021-12-29
 **/
public class Main {
    public static void main(String[] args) {
        Message message=new Message();
        message.setContext("大家好呀");
        ManagerVisitor managerVisitor=new ManagerVisitor();
        SenderVisitor senderVisitor=new SenderVisitor();
        RecipientVisitor recipientVisitor=new RecipientVisitor();
        SubManagerVisitor subManagerVisitor=new SubManagerVisitor();
        message.accept(managerVisitor);
        message.accept(senderVisitor);
        message.accept(recipientVisitor);
        message.accept(subManagerVisitor);

        ImgMessage imgMessage=new ImgMessage();
        imgMessage.setContext("好看的图片");
        imgMessage.setUrl("http://img.url.nice.png");

        imgMessage.accept(managerVisitor);
        imgMessage.accept(senderVisitor);
        imgMessage.accept(recipientVisitor);
        imgMessage.accept(subManagerVisitor);
    }
}

