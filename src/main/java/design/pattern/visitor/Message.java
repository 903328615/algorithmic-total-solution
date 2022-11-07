package design.pattern.visitor;

/**
 * @program: algorithmic-total-solution
 * @description: 普通消息
 * @author: wangzibin
 * @create: 2021-12-29
 **/
public class Message {

    protected String context;

    protected Long fromId;

    protected Long toId;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public void  accept(MessageVisitor messageVisitor){
       messageVisitor.visitMessage(this);
    }
}

