package com.feilis.model.chain.principle;

/**
 * @ClassName ConcreteHandler1
 * @Description TODO 具体处理对象1
 * @Author lf199
 * @Date 2020/10/15 12:39
 * @Version V1.0
 */
public class ConcreteHandler2 extends Handler {
    @Override
    public void handler(String request) {
        if (request.equals("two")) System.out.println("具体处理者2来处理该请求");
        else {
            Handler next = this.getNext();
            if (next == null) {
                System.out.println("流程终止，无后续处理者");
                return;
            }
            //下一步具体处理者处理该请求
            next.handler(request);
        }
    }
}
