package concurrent;

public class TemplateDemo {
    static abstract class Template {
        public final void templateMethod(){
            add();
            sub();
        }
        protected abstract void add();
        protected abstract void sub();
    }

    static class TemplateImpl extends Template{

        @Override
        protected void add() {
            System.out.println(1);
        }

        @Override
        protected void sub() {
            System.out.println(2);
        }
    }

    public static void main(String[] args) {
        Template template = new TemplateImpl();
        template.templateMethod();
    }
}
