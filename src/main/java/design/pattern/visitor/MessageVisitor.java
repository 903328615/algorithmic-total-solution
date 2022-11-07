package design.pattern.visitor;

public interface MessageVisitor {

    void visitMessage(Message message);

    void visitImgMessage(ImgMessage imgMessage);
}
