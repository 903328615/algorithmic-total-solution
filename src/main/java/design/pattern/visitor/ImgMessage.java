package design.pattern.visitor;

/**
 * @program: algorithmic-total-solution
 * @description: 图片消息
 * @author: wangzibin
 * @create: 2021-12-29
 **/
public class ImgMessage extends Message{

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void accept(MessageVisitor messageVisitor) {
        messageVisitor.visitImgMessage(this);
    }
}

